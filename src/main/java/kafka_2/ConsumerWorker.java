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
            int offset=consumer.getOffset().get();
            List<String> queueMsg=topic.getMsgQueue();
            do{
                while(offset>=queueMsg.size()) {
                    try {
                        consumer.wait();
                    } catch (Exception e) {
                    }
                }
                consumer.consumedMessage(queueMsg.get(offset),topic.getTopicId());
                consumer.getOffset().compareAndSet(offset,offset+1);
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
