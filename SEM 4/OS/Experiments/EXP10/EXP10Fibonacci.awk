read -p "Enter the number of terms for Fibonacci series: " terms

awk -v terms="$terms" 'BEGIN {
  a = 0
  b = 1
  print "Fibonacci Series:"
  for (i = 1; i <= terms; i++) {
    print "Term [" , i , "] : " , a
    c = a + b
    a = b
    b = c
  }
}'