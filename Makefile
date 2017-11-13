all:			ChungToiClient.class ChungToiServer.class \
			ChungToiImpl.class ChungToiInterface.class \
			ChungToi.class Player.class

ChungToiImpl.class:	ChungToiImpl.java ChungToiInterface.class
			javac ChungToiImpl.java

ChungToiInterface.class:	ChungToiInterface.java
			javac ChungToiInterface.java

ChungToiClient.class:	ChungToiClient.java
			javac ChungToiClient.java

ChungToiServer.class:	ChungToiServer.java
			javac ChungToiServer.java

ChungToi.class:	ChungToi.java
			javac ChungToi.java

Player.class:	Player.java
			javac Player.java

run:			all
			java ChungToiServer &
			sleep 1
			java ChungToiClient &
			sleep 1
			java ChungToiClient

clean:
			rm -f *.class *~

info:
			echo "(c) Roland Teodorowitsch (08 abr. 2015)"

