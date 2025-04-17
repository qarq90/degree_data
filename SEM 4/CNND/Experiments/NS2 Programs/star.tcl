# Create global variables
set ns [new Simulator]

# Set nam trace
set namf [open star.nam w]
$ns namtrace-all $namf

# Open the trace file
set tracef [open star.tr w]
$ns trace-all $tracef

# Creating nodes
set central [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]
set n6 [$ns node]

# Establish links (Star topology - all connect to central node)
$ns duplex-link $central $n1 2Mb 10ms DropTail
$ns duplex-link $central $n2 2Mb 10ms DropTail
$ns duplex-link $central $n3 2Mb 10ms DropTail
$ns duplex-link $central $n4 2Mb 10ms DropTail
$ns duplex-link $central $n5 2Mb 10ms DropTail
$ns duplex-link $central $n6 2Mb 10ms DropTail

# Label nodes
# $ns at 0.0 "$central label Central Switch"
$ns at 0.0 "$n1 label Host1"
$ns at 0.0 "$n2 label Host2"
$ns at 0.0 "$n3 label Host3"
$ns at 0.0 "$n3 label Host4"
$ns at 0.0 "$n3 label Host5"
$ns at 0.0 "$n3 label Host6"
# Node colors
$central color red
$n1 color blue
$n2 color green
$n3 color yellow
$n4 color blue
$n5 color green
$n6 color yellow

# Procedure to finish simulation
proc finish {} {
	global ns tracef namf
	$ns flush-trace
	close $tracef
	close $namf
	exec nam star.nam &
	exit 0
}

# Schedule finish procedure
$ns at 5.0 "finish"
$ns run

