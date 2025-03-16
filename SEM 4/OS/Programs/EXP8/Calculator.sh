echo "Select Mode:"
echo "1. Addition"
echo "2. Subtraction"
echo "3. Product"
echo "4. Division"
read choice

echo "Enter two numbers:"
read x y

case $choice in
    1) echo "Addition: $(($x + $y))" ;;
    2) echo "Subtraction: $(($x - $y))" ;;
    3) echo "Product: $(($x * $y))" ;;
    4) echo "Division: $(($x / $y))" ;;
    *) echo "I do not know this, sorry" ;;
esac