# Create global variables
set ns [new Simulator]

# Set nam trace
set namf [open wired1.nam w]
$ns namtrace-all $namf

# Open the trace file
set tracef [open wired1.tr w]
$ns trace-all $tracef

# Creating nodes
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]

# Establish links between nodes
$ns duplex-link $n0 $n1 2Mb 100ms DropTail
$ns duplex-link $n1 $n2 200Kb 100ms DropTail

# Label nodes
$ns at 0.0 "$n0 label Client1"
$ns at 0.0 "$n1 label Server"
$ns at 0.0 "$n2 label Client2"

# Node colors
$n0 color blue
$n1 color red
$n2 color green

# Procedure to finish simulation
proc finish {} {
	global ns tracef namf
	$ns flush-trace
	close $tracef
	close $namf
	exec nam wired1.nam &
	exit 0
}

# Schedule finish procedure
$ns at 2.0 "finish"
$ns run
