package kafka_2;

import lombok.*;
import lombok.experimental.NonFinal;

import java.util.concurrent.atomic.AtomicInteger;


@Getter
@Setter
public class Consumer {
    private final AtomicInteger offset;
    private String consumerId;
    public Consumer(){
        this.offset=new AtomicInteger(0);
    }
    public void consumedMessage(String msg,String topicId){
        System.out.println(topicId + " - " + consumerId + " consume - " + msg);
    }
}
