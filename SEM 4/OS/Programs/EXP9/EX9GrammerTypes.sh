if [ -z "$1" ]; then
  read -p "Enter the filename: " filename
else
  filename=$1
fi

if [ ! -f "$filename" ]; then
  echo "Error: File '$filename' not found!"
  exit 1
fi

char_count=$(wc -m < "$filename")
word_count=$(wc -w < "$filename")
line_count=$(wc -l < "$filename")

echo "Characters: $char_count"
echo "Words: $word_count"
echo "Lines: $line_count"
