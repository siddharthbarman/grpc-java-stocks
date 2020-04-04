set PROTO_BIN="c:\Utilities\protobuf\bin"
set MAVEN_BIN="C:\Java\apache-maven-3.6.3\bin"

cd ..\Interface
%MAVEN_BIN%\mvn package|more
copy target\ServiceInterface-1.0.jar ..\lib\

cd ..\build