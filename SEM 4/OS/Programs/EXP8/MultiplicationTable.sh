echo "Enter a number:"
read x

i=1
while [ $i -le 10 ]; do
    echo "$x * $i = $((x * i))"
    i=$((i + 1))
done