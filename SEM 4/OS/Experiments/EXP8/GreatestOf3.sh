echo "Enter three numbers (separated by white spaces):"
read x y z

if [ $x -gt $y ] && [ $x -gt $z ]; then
    echo "$x is the largest."
elif [ $y -gt $x ] && [ $y -gt $z ]; then
    echo "$y is the largest."
else
    echo "$z is the largest."
fi