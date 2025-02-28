echo "Enter the directory/file name:"
read name

if [ -e "$name" ]; then
    echo "$name exists."
else
    echo "$name does not exist. Creating it..."
    mkdir -p "$name"  
fi