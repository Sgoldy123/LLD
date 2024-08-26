package Kafka;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MessageQueue {

    private static MessageQueue instance;
    private final List<Producer> producers = new ArrayList<>();
    private final List<Topic> topics = new ArrayList<>();

    // prevent instance
    private MessageQueue() {
    }

    // get the single instance
    public static synchronized MessageQueue getInstance() {
        if (instance == null) {
            instance = new MessageQueue();
        }
        return instance;
    }


    public void buildArchitecture() {

        //create producers
        producers.add(Producer.builder().id(1).build());
        producers.add(Producer.builder().id(2).build());

        // create Consumers
        Consumer consumer1 = Consumer.builder().id(1).build();
        Consumer consumer2 = Consumer.builder().id(2).build();
        Consumer consumer3 = Consumer.builder().id(3).build();
        Consumer consumer4 = Consumer.builder().id(4).build();
        Consumer consumer5 = Consumer.builder().id(5).build();
        List<Consumer> consumerList1 = List.of(consumer1, consumer2, consumer3, consumer4, consumer5);
        List<Consumer> consumerList2 = List.of(consumer1, consumer3, consumer4);

        // Creating Topic 1 --> Consumers 1, 2, 3, 4, 5
        Topic topic1 = Topic.builder().id(1).consumerList(consumerList1).messageQueue(new LinkedList<>()).build();
        topics.add(topic1);

        // Creating Topic 2 --> Consumers 1, 3, 4
        Topic topic2 = Topic.builder().id(2).consumerList(consumerList2).messageQueue(new LinkedList<>()).build();
        topics.add(topic2);
    }

    // producers to publish messages to a topic
    public void publishMessage(Integer producerId, Integer topicId, String message) throws InterruptedException {
        System.out.println("Producer: " + producerId + " published message to Topic: " + topicId + ": \"" + message + "\"");
        for (Topic topic : topics) {
            if (topic.getId().equals(topicId)) {
                topic.getMessageQueue().add(message);
            }
        }
        notifyConsumers(topicId);
    }

    // notigy consumers
    void notifyConsumers(Integer topicId) throws InterruptedException {
        for (Topic topic : topics) {
            if (topic.getId().equals(topicId)) {
                while(topic.getMessageQueue().size()>0) {
                    String currMsg = topic.getMessageQueue().poll();
                    for (Consumer consumer : topic.getConsumerList()) {
                        System.out.println("Consumer " + consumer.getId() + " received message: \"" + currMsg + "\" from Topic " + topicId);
                        Thread.sleep(2000);
                    }
                }
            }
        }
    }
}
