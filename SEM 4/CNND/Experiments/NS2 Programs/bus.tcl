# Create global variables
set ns [new Simulator]

# Set nam trace
set namf [open bus.nam w]
$ns namtrace-all $namf

# Open the trace file
set tracef [open bus.tr w]
$ns trace-all $tracef

# Creating nodes
set nA [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set nZ [$ns node]

# Establish links (Bus topology - all connected in a single line)
$ns duplex-link $nA $nZ 2Mb 10ms DropTail
$ns duplex-link $n1 $n2 2Mb 10ms DropTail
$ns duplex-link $n3 $n4 2Mb 10ms DropTail

# Label nodes
$ns at 0.0 "$nA label Host1"
$ns at 0.0 "$n1 label Switch"
$ns at 0.0 "$n2 label Host2"
$ns at 0.0 "$n3 label Switch"
$ns at 0.0 "$n4 label Host2"
$ns at 0.0 "$nZ label Host3"

# Node colors
$nA color blue
$n1 color red
$n2 color green
$n3 color red
$n4 color green
$nZ color yellow

# Procedure to finish simulation
proc finish {} {
	global ns tracef namf
	$ns flush-trace
	close $tracef
	close $namf
	exec nam bus.nam &
	exit 0
}

# Schedule finish procedure
$ns at 5.0 "finish"
$ns run

