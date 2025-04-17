if [ -z "$1" ] || [ -z "$2" ]; then
  echo "Usage: $0 <start> <end>"
  exit 1
fi

start=$1
end=$2

awk -v start="$start" -v end="$end" 'BEGIN {
  first = 1
  for (i = start; i <= end; i++) {
    if (i % 2 == 0) {
      if (first) {
        printf "%d", i
        first = 0
      } else {
        printf " %d", i
      }
    }
  }
  print "" 
}'