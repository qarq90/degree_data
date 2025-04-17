echo "Enter first string:"
read s1

echo "Enter second string:"
read s2

if [ "$s1" == "$s2" ]; then
    echo "Strings are equal."
else
    echo "Strings are not equal."
fi