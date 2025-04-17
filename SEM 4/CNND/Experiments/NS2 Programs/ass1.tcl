# Simulation parameters setup
set val(stop) 10.0 ;# time of simulation end

# Initialization
set ns [new Simulator]

# Open the NS trace file
set tracefile [open out.tr w]
$ns trace-all $tracefile

# Open the NAM trace file
set namfile [open out.nam w]
$ns namtrace-all $namfile

# Create nodes
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]

# Define links between nodes
$ns duplex-link $n0 $n4 100.0Mb 10ms DropTail
$ns queue-limit $n0 $n4 50

$ns duplex-link $n1 $n4 100.0Mb 10ms DropTail
$ns queue-limit $n1 $n4 50

$ns duplex-link $n2 $n4 100.0Mb 10ms DropTail
$ns queue-limit $n2 $n4 50

$ns duplex-link $n3 $n4 100.0Mb 10ms DropTail
$ns queue-limit $n3 $n4 50

$ns duplex-link $n3 $n0 100.0Mb 10ms DropTail
$ns queue-limit $n3 $n0 50

# Define TCP connection
set tcp0 [new Agent/TCP]
$ns attach-agent $n0 $tcp0

set sink1 [new Agent/TCPSink]
$ns attach-agent $n2 $sink1

$ns connect $tcp0 $sink1

# Define UDP connection
set udp1 [new Agent/UDP]
$ns attach-agent $n1 $udp1

set null3 [new Agent/Null]
$ns attach-agent $n3 $null3

$ns connect $udp1 $null3
$udp1 set packetSize_ 1500

# Setup FTP application over TCP
set ftp1 [new Application/FTP]
$ftp1 attach-agent $tcp0

$ns at 1.0 "$ftp1 start"
$ns at 10.0 "$ftp1 stop"

# Setup Telnet application over UDP
set telnet0 [new Application/Telnet]
$telnet0 set interval_ 0.001
$telnet0 attach-agent $udp1

$ns at 1.0 "$telnet0 start"
$ns at 10.0 "$telnet0 stop"

# Termination function
proc finish {} {
    global ns tracefile namfile
    $ns flush-trace
    close $tracefile
    close $namfile
    exec nam out.nam &
    exit 0
}

# Schedule simulation end
$ns at $val(stop) "finish"
$ns at $val(stop) "puts \"done\" ; $ns halt"

# Run simulation
$ns run

