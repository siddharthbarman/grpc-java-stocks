### Projects

This list of the projects is below - Client and Server were the initial POC projects which have a lot of code duplication. Interface, ClientB & ServerB define the best way to implement the solution. 



##### Interface

This project builds the service proto file and generates a JAR file which contains the classes required to implement the grpc-server and grpc-client. The pom.xml file can be modified in future so as to create two JAR files one for implementing the server & the other for implementing the client. Presently, a single JAR is created which is a bit large in size around 13 MBs. A number of concepts are used:

- Creating a FAT JAR
- Generating a sources JAR



#### ServerB

This project includes the interface JAR and implements the GRPC server. 



#### Server

This project is based on various tutorials on the web which generates Java classes by using the GRPC Maven generator and also implements the server.



##### ClientB

This project implements the client by linking with the Interface JAR. 



##### Client

This project implements the client by generating Java classes using the proto service file. This is a bad way of doing things as there are two copies of the same service proto file - one in the Server and one here. ClientB and ServerB sharing the definition present in the Interface JAR is the best approach.