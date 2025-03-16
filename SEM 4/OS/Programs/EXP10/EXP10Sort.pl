my @array = (5, 3, 8, 1, 9, 2);

my @sorted_array = sort { $a <=> $b } @array;

print "Sorted Array: @sorted_array\n";