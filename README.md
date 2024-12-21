# kafka-spring-flow
## CMD Commands for Windows

Starting the Zookeeper </br>
D:\kafka> </br>
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

Starting the Kafka Server </br>
D:\kafka> </br>
.\bin\windows\kafka-server-start.bat .\config\server.properties

Creating a Topic (Not required as code will do it)</br>
D:\kafka> </br>
.\bin\windows\kafka-server-start.bat .\config\server.properties

List All Created Topics </br>
D:\kafka> </br>
.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

View Messages Received by a Specific Topic </br>
D:\kafka> </br>
.\bin\windows\kafka-console-consumer.bat --topic order_topics --from-beginning --bootstrap-server localhost:9092