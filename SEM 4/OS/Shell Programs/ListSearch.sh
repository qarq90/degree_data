echo "Enter elements of the list (separated by spaces):"
read -a list

echo "Enter the element to search:"
read element

found=0
for item in "${list[@]}"; do
    if [ $item -eq $element ]; then
        found=1
        break
    fi
done

if [ $found -eq 1 ]; then
    echo "$element is present in the list."
else
    echo "$element is not present in the list."
fi