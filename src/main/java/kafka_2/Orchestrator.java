package kafka_2;

public class Orchestrator {
    public static void main(String[] args) {

        Kafka kafka=Kafka.getInstance();

        //   *********** create topic *******
        kafka.createTopic("topic1");
        kafka.createTopic("topic2");


        // **********  producer create *********
        kafka.createProducer("producer1");
        kafka.createProducer("producer2");

        // ************ consumer create *********
        kafka.createConsumer("consumer1");
        kafka.createConsumer("consumer2");
        kafka.createConsumer("consumer3");
        kafka.createConsumer("consumer4");
        kafka.createConsumer("consumer5");

        // ******* consumer consumer topic
        kafka.addConsumerToTopic("topic1","consumer1");
        kafka.addConsumerToTopic("topic1","consumer2");
        kafka.addConsumerToTopic("topic1","consumer3");
        kafka.addConsumerToTopic("topic1","consumer4");
        kafka.addConsumerToTopic("topic1","consumer5");


        kafka.addConsumerToTopic("topic2","consumer1");
        kafka.addConsumerToTopic("topic2","consumer3");
        kafka.addConsumerToTopic("topic2","consumer4");


        // **** publish message *******
        kafka.publishMessage("producer1","topic1","thread1msg"+"notOk:(");
//       Thread t1=new Thread(()-> {
//           for(int i=0;i<2;i++){
//               kafka.publishMessage("producer1","topic1","thread1msg"+i);
//           }
//       });
//
//        Thread t2=new Thread(()-> {
//           for(int i=0;i<2;i++){
//            kafka.publishMessage("producer2","topic1","thread2msg"+i);
//           }
//        });
//
//        t1.start();
//        t2.start();








    }
}