package cn.cg.spring.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: cg
 * @date: 2022-12-06 15:52
 **/
@Component
@Slf4j
public class KafkaConsumer {


    @KafkaListener(topics = "partition-test"
//            , topicPartitions = {
//                    @TopicPartition(topic = "partition-test",
//                            partitionOffsets = {@PartitionOffset(partition = "0", initialOffset = "0")}
//
//                    )}
                    ,
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listener(List<ConsumerRecord<String, String>> records, Consumer consumer) {
        for (ConsumerRecord<String, String> record : records) {
            log.info("S5收到的数据key-------------" + record.key());
            log.info("S5收到的数据value-------------" + record.value());
        }
        //同步提交
        consumer.commitAsync();
    }


//    @KafkaListener(topics = "partition-test",
//            topicPartitions = {
//                    @TopicPartition(topic = "partition-test",
//                            partitionOffsets = {@PartitionOffset(partition = "0", initialOffset = "0")
//                                    , @PartitionOffset(partition = "1", initialOffset = "0")
//                                    , @PartitionOffset(partition = "2", initialOffset = "0")}
//
//                    )}, containerFactory = "kafkaListenerContainerFactory2"
//    )
//    public void listener2(List<ConsumerRecord<String, String>> records, Consumer consumer, Acknowledgment acknowledgment) {
//        for (ConsumerRecord<String, String> record : records) {
//            log.info("S6收到的数据key-------------" + record.key());
//            log.info("S6收到的数据value-------------" + record.value());
//        }
//        //同步提交
//        consumer.commitAsync();
//    }
}
