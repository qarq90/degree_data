# Create global variables
set ns [new Simulator]

# Set nam trace
set namf [open ring.nam w]
$ns namtrace-all $namf

# Open the trace file
set tracef [open ring.tr w]
$ns trace-all $tracef

# Creating nodes
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]

# Establish links (Ring topology - closed loop)
$ns duplex-link $n0 $n1 3Mb 3ms DropTail
$ns duplex-link $n1 $n2 3Mb 3ms DropTail
$ns duplex-link $n2 $n3 3Mb 3ms DropTail
$ns duplex-link $n3 $n4 3Mb 3ms DropTail
$ns duplex-link $n4 $n5 3Mb 3ms DropTail
$ns duplex-link $n5 $n0 3Mb 3ms DropTail

# Label nodes
$ns at 0.0 "$n0 label Node1"
$ns at 0.0 "$n1 label Node2"
$ns at 0.0 "$n2 label Node3"
$ns at 0.0 "$n3 label Node4"
$ns at 0.0 "$n4 label Node5"
$ns at 0.0 "$n5 label Node6"

# Node colors
$n0 color blue
$n1 color red
$n2 color green
$n3 color yellow
$n4 color white
$n5 color green

# Procedure to finish simulation
proc finish {} {
	global ns tracef namf
	$ns flush-trace
	close $tracef
	close $namf
	exec nam ring.nam &
	exit 0
}

# Schedule finish procedure
$ns at 5.0 "finish"
$ns run

