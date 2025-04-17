if [ -z "$1" ]; then
  read -p "Enter the filename: " filename
else
  filename=$1
fi

if [ ! -f "$filename" ]; then
  echo "Error: File '$filename' not found!"
  exit 1
fi

if [ -z "$2" ]; then
  read -p "Enter the word to replace: " old_word
else
  old_word=$2
fi

if [ -z "$3" ]; then
  read -p "Enter the new word: " new_word
else
  new_word=$3
fi

sed -i "s/$old_word/$new_word/g" "$filename"
echo "Replaced all occurrences of '$old_word' with '$new_word' in '$filename'."
