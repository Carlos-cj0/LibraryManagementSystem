**LibraryManagementSystem**

This project is a Library Management System developed with Java for the main project classes and javaFX for an interactive system User Interface

*Features*

**Admin**
Manage Books:  Add Books, Remove Books , Display Books And Their availability Status , Search Books 
Manage Users: Add Users, Remove Users, Display Added Users

**User**
A User Can: Borrow Books, Return Books , View All Books In The Library And Their Availability Status
View Books Issued To Them Specifically, Search Books In The Library

Common Features: Both The User And Admin can Sign In First To Personalize Their User Experience 

**Technologies Used To Develop This System**
-Java
-JavaFX and CSS properties for UI Styling 
-Junit5 For testing class methods

**Project Directory Structure**
The following is the project's directory structure 

LibraryManagementSystem/
├── bin/                  #Compiled class files will be placed here
├── src/                  #Source code directory
│   ├── main/
│   │   ├── java/
│   │   │   ├── models/   #Model classes
│   │   │   ├── utils/    # Utility classes
│   │   │   └── Main.java # Main application entry point
│   └── test/             #Test files

**Prerequisites To Compile And Run The Application Successfully**

1.Java Development Kit(JDK):
-JDK 21
-Add the  JDK bin directory to your system's PATH

2.JavaFX SDK:
-Download the javaFX SDK from the official website https://openjfx.io

**How To Compile The Project**

Generic CommandLine command to compile the project

javac --module-path <path-to-javafx-sdk-lib> --add-modules javafx.controls -d bin src/main/java/models/*.java src/main/java/utils/*.java src/main/java/Main.java

Example compile command from my PC's Terminal(macOS):

From the project's directory: 
eclipse-workspace/LibraryManagementSystem

Compile Command:

javac --module-path ~/Downloads/javafx-sdk-21.0.5/lib --add-modules javafx.controls -d bin src/main/java/models/*.java src/main/java/utils/*.java src/main/java/Main.java 

**How To Run The Project**

Generic Command:

java --module-path <path-to-javafx-sdk-lib> --add-modules javafx.controls -cp bin main.java.Main

Example compile command from my PC's Terminal (macOS):

Upon successful compilation;
java --module-path ~/Downloads/javafx-sdk-21.0.5/lib --add-modules javafx.controls -cp bin main.java.Main

**Points To Note For Successful Compilation And Running Of The Project**

1.JavaFX Path:

•Kindly endeavor to replace <path-to-javafx-sdk-lib> with the actual path to the lib directory of your JavaFX SDK.
• macOS/Linux : ~/Downloads/javafx-sdk-21.0.5/lib
• Windows: C:\path\to\javafx-sdk-21.0.5\lib

2.Directory Structure:

•Kindly Endeavor to pay attention to the directory structure, It could differ from the one described in this ReadMe file
3.Troubleshooting

•If you encounter a module not found error verify the JavaFX SDK path and make sure it includes javaFX.controls.jar this is the base jar for displaying the UI
•Kindly endeavor to check that all .java files are in their correct directories on your PC as shown in the project directory structure defined in this ReadMe file

Also, note that a database has not yet been incorporated to the project yet so any data entered when using this System shall not persist
when The Session Is Terminated.

**Enjoy the LibraryManagementSystem Experience**







