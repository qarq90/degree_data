# Create a Simulator instance
set ns [new Simulator]

# Open Trace and NAM files
set tr [open ls.tr w]
$ns trace-all $tr
set nf [open ls.nam w]
$ns namtrace-all $nf

# Finish procedure
proc finish {} {
    global ns tr nf
    $ns flush-trace
    close $tr
    close $nf
    exec nam ls.nam &
    exit 0
}

# Create Nodes
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]

# Create Duplex Links with DropTail queue
$ns duplex-link $n0 $n1 10Mb 10ms DropTail
$ns duplex-link $n1 $n3 10Mb 10ms DropTail
$ns duplex-link $n2 $n1 10Mb 10ms DropTail

# Set Link Orientations
$ns duplex-link-op $n0 $n1 orient right-down
$ns duplex-link-op $n1 $n3 orient right
$ns duplex-link-op $n2 $n1 orient right-up

# Attach TCP Agent and FTP
set tcp [new Agent/TCP]
$ns attach-agent $n0 $tcp
set sink [new Agent/TCPSink]
$ns attach-agent $n3 $sink
$ns connect $tcp $sink

# Create FTP application
set ftp [new Application/FTP]
$ftp attach-agent $tcp

# Attach UDP Agent and CBR Traffic
set udp [new Agent/UDP]
$ns attach-agent $n2 $udp
set null [new Agent/Null]
$ns attach-agent $n3 $null
$ns connect $udp $null

# Create CBR application
set cbr [new Application/Traffic/CBR]
$cbr attach-agent $udp

# Enable Link State (LS) Routing Protocol
$ns rtproto LS

# Simulate Link Failure and Recovery
$ns rtmodel-at 1.0 down $n1 $n3
$ns rtmodel-at 2.0 up $n1 $n3

# Start Traffic
$ns at 0.0 "$ftp start"
$ns at 0.0 "$cbr start"

# Stop Simulation
$ns at 5.0 "finish"

# Run Simulation
$ns run