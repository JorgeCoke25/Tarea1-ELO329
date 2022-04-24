JFLAGS = -g
JC = javac
JVM = java
FILE = "configuration.txt"


.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Stage1.java \
	Cloud.java \
	Lamp.java \
	LampControl.java \
	LampState.java \
	Operator.java 

MAIN = Stage1

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
		$(JVM) $(MAIN) $(FILE) > salida.csv

clean:
	$(RM) *.class