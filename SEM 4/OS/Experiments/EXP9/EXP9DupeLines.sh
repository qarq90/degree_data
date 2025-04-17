
if [ -z "$1" ]; then
  read -p "Enter the filename: " filename
else
  filename=$1
fi

if [ ! -f "$filename" ]; then
  echo "Error: File '$filename' not found!"
  exit 1
fi

awk '
  { count[$0]++ }
  count[$0] > 1 { print $0 }
' "$filename"
