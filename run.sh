
echo "starting..."
cd staging
cp ../resources/links.txt .
java -jar homer.jar links.txt resources/homer.properties
cd - 
