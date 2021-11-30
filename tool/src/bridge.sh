#!/bin/sh
cd python
python3 filecreator.py
cd ..
javac java/grocery/*.java 
cd java
java grocery.Purchasing
cd ..