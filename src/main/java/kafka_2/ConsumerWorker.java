package kafka_2;
// this class is for running consumer thread

import lombok.SneakyThrows;

import java.util.List;

public class ConsumerWorker implements Runnable{

    private Topic topic;
    private Consumer consumer;
    public ConsumerWorker(Topic topic,Consumer consumer){
        this.topic=topic;
        this.consumer=consumer;
    }
//    @SneakyThrows
    @Override
    public void run() {

        synchronized (consumer){
//            int curOffset = consumer.getOffset().get();

            List<String> queueMsg=topic.getMsgQueue();

            do{
                int curOffset = consumer.getOffSetWRTTopic(topic.getTopicId());
                System.out.println(Thread.currentThread().getName()+"**"+consumer.getConsumerId()+" "+curOffset);


                while(curOffset>=queueMsg.size()) {   //why while so need to wake up it can automatically run..
                    try {
                        consumer.wait();
                    } catch (Exception e) {
                    }
                }
                String msg=queueMsg.get(curOffset);
                consumer.consumedMessage(msg,topic.getTopicId());
//                consumer.getOffset().compareAndSet(curOffset,curOffset+1);
                consumer.setOffsetWRTTopic(topic.getTopicId());
//                curOffset=1;
//                System.out.println(" ######## ####  ###" + consumer.getOffset());
            }
            while(true);
        }

    }

    public synchronized void wakeUpThreadIfNeeded(){
        synchronized (consumer){
            consumer.notify();
        }
    }

}
