seneca-java-driver
==================

Java driver for Seneca, the micro-services toolkit for Node.js.  Allows you to call remote microservices and create microservices in Java.

Usage
-----

To import the seneca driver in your maven project, add the following dependency in your pom.xml:

```XML
<dependency>
    <groupId>org.senecajs.seneca-java-driver</groupId>
    <artifactId>seneca-java-driver</artifactId>
    <version>1.0.0</version>
</dependency>
```

In your Java files, you can import the SenecaDriver class with the following code:

```Java
import org.senecajs.seneca_java_driver.SenecaDriver

...

SenecaDriver client = new SenecaDriver("localhost", 10101);
```

Example
-------

A simple use case for the Seneca microservice toolkit is to set up a reusable configuration service that provides universal conviguration properties accross your entire app.

First, you can add the `config` command to a JavaScript file config-server.js:

```JavaScript
var seneca = require('seneca')()

seneca.add( {cmd:'config'}, function(args,callback){
  var config = {
    rate: 0.23
  }
  var value = config[args.prop]
  callback(null,{value:value})
})

seneca.listen()
```

Then, you can run the `config` command from the Seneca Driver:

```Java
public void main(String args[]) {
	SenecaDriver client = new SenecaDriver();
  String responseString = client.act("{\"cmd\": \"config\", \"prop\": "rate\"}");

  System.out.println(responseString);
}
```

This will print out the string `{"value":0.23}`.

Testing
-------

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

```
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
