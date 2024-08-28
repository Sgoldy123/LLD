package kafka_2;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Queue;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Topic {
    private String topicId;
    private List<String> msgQueue;
    private List<Consumer>  consumersList;
    private Map<String,ConsumerWorker> consumerWorkerMapForConsumerThread;

    synchronized public void addMessage(String msg){
        this.msgQueue.add(msg);
    }

    public void publish(){
        for(Consumer consumer: consumersList){
            notifyConsumer(consumer);
        }
    }

    private void  notifyConsumer(Consumer consumer){

            if(!consumerWorkerMapForConsumerThread.containsKey(consumer.getConsumerId())){
                final ConsumerWorker consumerWorker=new ConsumerWorker(this,consumer);
                consumerWorkerMapForConsumerThread.put(consumer.getConsumerId(),consumerWorker);
                new Thread(consumerWorker).start();
            }
            final  ConsumerWorker consumerWorker = consumerWorkerMapForConsumerThread.get(consumer.getConsumerId());
            consumerWorker.wakeUpThreadIfNeeded();



    }
}
