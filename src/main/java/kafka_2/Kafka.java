package kafka_2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.*;

@Builder
@AllArgsConstructor
public class Kafka {
    private static Kafka kafkaInstance=new Kafka();
    private Map<String, Topic> topicMap;
    private Map<String,Consumer> consumerMap;
    private Map<String,Producer>producerMap;


    private Kafka(){
         topicMap=new HashMap<>();
         consumerMap=new HashMap<>();
         producerMap=new HashMap<>();
    }
    public static Kafka getInstance(){
        return kafkaInstance;
    }

    public void createTopic(String topicID){
        Topic topic=Topic.builder().topicId(topicID).consumersList(new ArrayList<>()).msgQueue(new ArrayList<>()).consumerWorkerMapForConsumerThread(new HashMap<>()).build();
        topicMap.put(topicID,topic);
    }
    public void createConsumer(String consumerId){
//       Consumer consumer=Consumer.builder().consumerId(consumerId).offset(0).build();
      Consumer consumer=new Consumer();
      consumer.setConsumerId(consumerId);
       consumerMap.put(consumerId,consumer);
    }
    public void createProducer(String producerId){
        Producer producer=Producer.builder().producerId(producerId).build();
        producerMap.put(producerId,producer);
    }


    synchronized public  void  publishMessage(String producerId, String topicId, String msg){
       final Topic topic=topicMap.get(topicId);
        topic.addMessage(msg);
        System.out.println(producerId+" - publish "+topicId+" "+msg);
        new Thread(()->topic.publish()).start();
    }


    public void addConsumerToTopic(String topicid,String consumerId){
        topicMap.get(topicid).getConsumersList().add(consumerMap.get(consumerId));
    }

}
