# Cinema XXI Layout

This project is a Java application that displays a layout of a Cinema XXI.

## Prerequisites

- Java 20
- Junit-platform-console-standalone-1.9.2.jar

## Compiling

To compile the project, run the following command:

for windows:

```
javac -d bin -cp .\lib\* .\src\cinema\*.java .\src\handler\*.java .\src\helper\*.java .\src\App.java
```

for linux:

```
javac -d bin -cp ./lib/* ./src/cinema/*.java ./src/handler/*.java ./src/helper/*.java ./src/App.java
```

## Running

To run the app, execute the following command:

```
java -cp bin App
```

## Testing

To compile the tests, run the following command:

for windows:

```
javac -d test -cp .\lib\junit-platform-console-standalone-1.9.2.jar .\src\cinema\*.java .\src\helper\*.java
```

for linux/unix:

```
javac -d test -cp ./lib/junit-platform-console-standalone-1.9.2.jar ./src/cinema/*.java ./src/helper/*.java
```

To run the tests, execute the following command:

for windows:

```
java -jar .\lib\junit-platform-console-standalone-1.9.2.jar --class-path test --scan-class-path
```

for linux/unix:

```
java -jar ./lib/junit-platform-console-standalone-1.9.2.jar --class-path test --scan-class-path
```
