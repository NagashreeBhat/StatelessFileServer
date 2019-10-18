# CSC502-Signature Project
 ITU CSC502 Signature Project - Stateless File Server with Client Side Cache 
 
### Requirements

- Java 8 SDK

### Building (Gradle)

We use Gradle for build automation. If gradle is not installed on your system you can use the provided Gradle Wrapper to perform all build commands. **gradle.bat** for Windows systems and **gradle** for Linux/MacOS systems. Java 8 must be installed on your system with a proper JAVA_HOME environment variable.

#### Build an executable JAR from source

Clean the project build paths by running 'gradle clean'

* ##### Server

To build an executable jar for the Server run: gradle jarServer

You will find the resulting server jar inside ./build/libs.

* ##### Client 

To build an executable jar for the Client run: gradle jarClient

You will find the resulting client jar inside ./build/libs.

### Running the Server & Client

* ##### Server

Run the server in the command line with: java -jar server*.jar

* ##### Client
 
Run the client in the command line with: java -jar client*.jar
 
When prompted for a port, enter a port that is available on your system.

### Group members:

- Nagashree Bhat

