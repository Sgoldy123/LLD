package Kafka;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;

import java.util.List;
import java.util.Queue;

@Builder
@Getter
public class Topic {
    private Integer id;

    private List<Consumer> consumerList;

    private Queue<String> messageQueue;
}
