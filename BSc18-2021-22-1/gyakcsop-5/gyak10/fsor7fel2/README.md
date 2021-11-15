## Windows

~~~
javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar BookTest.java
java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore BookTest
~~~

## Linux

~~~
javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar BookTest.java
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore BookTest
~~~


