package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.example.KafkaController,com.example.KafkaService")
public class SpringBootPlusKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPlusKafkaApplication.class, args);
	}

}
/*1. Install Kafka (if it is lower than 4.x version then zookeeper service required)
 * 
 * 2.Go to C:\kafka_2.12-3.4.0
 * 
 * edit zookeeper.properties : dataDir=C://kafka_2.12-3.4.0//zookeeper-data
 * 
 * edit server.properties : log.dirs=C://kafka_2.12-3.4.0//kafka-logs
 * 
 * 2.a. execute .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
 * 2.b. open another cmd and execute .\bin\windows\kafka-server-start.bat .\config\server.properties
 * 
 * 2.c.create topic : kafka-topics.bat --create --topic MyTopic --bootstrap-server localhost:9092
 * 
 * Note: 9092 is default port for kafka server
 * 
 * "MyTopic" is the topic name we created
 * 
 * 3. Start Spring boot application creation:----
 * 
 * 3.a.add dependency web,kafka
 * 3.b.create producer,consumer and controller class
 * 3.c. In producer , autowire KafkaTemplate
 * 
 * Note: KafkaTemplate<K,V> is like map where key is topic where consumer will listen to and Value is like list of messages
 * (we can consider each message as partition)
 * 
 * we are creating consumer group and that consumer group will listen to particular topic (KEY) and each consumer from
 * consumer group will listen to each partition (messages) in round robin fashion
 * 
 * KafkaTemplate<Topic,List<Partition1,Partition2....>
 * 
 * 3.d. we are using send function in kafkaTemplate and pass topic as key and message as partition
 * 
 * 3.e.start consumer console : kafka-console-consumer -bootstrap-server localhost:9092 -topic MyTopic
 * pass topic name so that consumer will listen to particular topic
 * 
 * When we hit end point for producer we will get output in consumer console 
 * 
 */