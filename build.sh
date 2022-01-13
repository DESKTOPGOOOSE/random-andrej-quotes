@echo off
echo Compile code
cd src/main/java
javac AndrejQuote.java
echo Main-Class: AndrejQuote >manifest.txt
echo Build jar
mkdir bin
jar cvfm AndrejQuote.jar manifest.txt *.class
mv AndrejQuote.jar bin
echo Jar was built at src/main/java/bin/AndrejQuote.jar
