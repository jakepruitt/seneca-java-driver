seneca-java-driver
==================

Java driver for Seneca, the micro-services toolkit for Node.js.  Allows you to call remote microservices and create microservices in Java.

Usage
-----

After downloading the repository, make sure you have maven and npm installed by running:

```
	mvn -v
	npm -v
```

After you have maven and npm installed, run the following commands to build the repository:

```
	npm install
	mvn compile
```

In order to test the package, run the following commands in order, which creates a background node seneca server to test the client functionality:

``
	node src/test/javascript/config-server.js --seneca.log.quiet &
	CONFIG_SERVER_PID=$!
	sleep 1
	mvn test
	kill $CONFIG_SERVER_PID
```

TODO
----
	- [ ] Write description of use case
	- [ ] Handle various .act() exceptions
	- [ ] Configure maven to automatically start config-server.js
	- [ ] Create an override for .act() that accepts any object and parses to JSON
	- [ ] Create .add() and .listen() functionality
	- [ ] Deploy to maven