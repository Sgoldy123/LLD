package kafka_2;

import lombok.*;
import lombok.experimental.NonFinal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@Getter
@Setter
public class Consumer {
//    private final AtomicInteger offset;
    private Map<String,Integer> mapOffset;
    private String consumerId;
    public Consumer(){
//        this.offset=new AtomicInteger(0);
        mapOffset=new HashMap<>();
    }
    public void consumedMessage(String msg,String topicId){
        System.out.println(Thread.currentThread().getName()+"**"+ topicId + " - " + consumerId + " consume - " + msg);
    }
    public int getOffSetWRTTopic(String topicId){
        return mapOffset.get(topicId);
    }
    public  void setOffsetWRTTopic(String topicId){
        if(mapOffset.containsKey(topicId))
        mapOffset.put(topicId,mapOffset.get(topicId)+1);
        else{
            mapOffset.put(topicId,0);
        }
    }
}
