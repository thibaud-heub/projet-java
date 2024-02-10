cd src/
javac -d ../class/ */*.java
cd ../
jar cfe dukes-adventures.jar app.Main font/ image/ -C class/ .