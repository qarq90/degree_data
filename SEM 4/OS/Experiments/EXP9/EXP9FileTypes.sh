echo "Files in the current directory:"
ls -p | egrep -v /

echo ""
echo "Files grouped by extension:"
for ext in $(ls -1 | awk -F. 'NF>1 {print $NF}' | sort -u); do
    echo -e "\n* .$ext files:"
    ls *.$ext 2>/dev/null
done
