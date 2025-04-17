print "Enter a number: ";
my $num = <STDIN>;
chomp($num);

my $is_prime = 1;
if ($num <= 1) {
  $is_prime = 0;
} else {
  for (my $i = 2; $i <= sqrt($num); $i++) {
    if ($num % $i == 0) {
      $is_prime = 0;
      last;
    }
  }
}

if ($is_prime) {
  print "$num is a prime number.\n";
} else {
  print "$num is not a prime number.\n";
}