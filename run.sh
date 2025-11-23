#!/bin/bash

# Course Management System - Compile and Run Script

echo "🔨 Compiling Course Management System..."

# Create target directory if it doesn't exist
mkdir -p target/classes

# Compile all backend and UI classes
javac -d target/classes src/main/java/com/cms/backend/*.java src/main/java/com/cms/ui/*.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "✅ Compilation successful!"
    echo "🚀 Running Course Management System..."
    echo ""
    
    # Run the program
    java -cp target/classes com.cms.ui.Main
else
    echo "❌ Compilation failed. Please check the errors above."
    exit 1
fi
