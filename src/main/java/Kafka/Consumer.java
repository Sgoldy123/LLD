package Kafka;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Consumer {
    private Integer id;
    private List<Topic> topicList;
}
