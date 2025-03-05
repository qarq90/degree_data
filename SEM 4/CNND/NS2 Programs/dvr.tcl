# Define the simulation environment
set ns [new Simulator]
# Open the trace file for recording data
set tracefile [open out.tr w]
$ns trace-all $tracefile
# Define the finish procedure
proc finish {} {
global ns tracefile
$ns flush-trace
close $tracefile
exec nam out.nam &
exit 0
}
# Create network nodes
set node1 [$ns node]
set node2 [$ns node]
set node3 [$ns node]
set node4 [$ns node]
set node5 [$ns node]

# Create duplex links between nodes with different delays and bandwidths
$ns duplex-link $node1 $node2 10Mb 10ms DropTail
$ns duplex-link $node2 $node3 10Mb 10ms DropTail
$ns duplex-link $node3 $node4 10Mb 10ms DropTail
$ns duplex-link $node4 $node5 10Mb 10ms DropTail
$ns duplex-link $node1 $node5 5Mb 50ms DropTail
$ns duplex-link $node2 $node4 5Mb 30ms DropTail

# Enable dynamic routing protocol (Distance Vector – DV)
$ns rtproto DV
# Attach TCP agents for traffic generation
set tcp [new Agent/TCP]
$ns attach-agent $node1 $tcp
set sink [new Agent/TCPSink]
$ns attach-agent $node5 $sink

# Connect the TCP agent and sink
$ns connect $tcp $sink
# Create an FTP application and attach it to TCP
set ftp [new Application/FTP]
$ftp attach-agent $tcp
# Start the FTP application at 1 second
$ns at 1.0 “$ftp start”
# Simulate link failure between node2 and node3 at time 3.0 seconds
$ns rtmodel-at 3.0 down $node2 $node3
# Restore the link between node2 and node3 at time 6.0 seconds
$ns rtmodel-at 6.0 up $node2 $node3
# Stop the simulation at 10.0 seconds
$ns at 10.0 “finish”
# Run the simulation
$ns run
