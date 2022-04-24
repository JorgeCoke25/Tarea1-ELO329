JFLAGS = -g
JC = javac
JVM = java
FILE = "configuration.txt"


.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Stage2.java \
	Cloud.java \
	DomoticDevice.java \
	DomoticDeviceControl.java \
	Lamp.java \
	LampControl.java \
	LampState.java \
	Operator.java \
	RollerShade.java \
	ShadeControl.java 

MAIN = Stage2

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
		$(JVM) $(MAIN) $(FILE) > salida.csv

clean:
	$(RM) *.class
	$(RM) *.csv