package cn.cg.spring.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cg
 * @date: 2022-12-06 15:54
 **/
@Configuration
@Slf4j
public class Config {


    @Value("${spring.kafka.bootstrap-servers}")
    private String servers;

    /**
     * 消费者基础配置
     *
     * @return Map
     */
    private Map<String, Object> consumerProps() {
        Map<String, Object> props = new HashMap<>(9);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 100 * 1000);
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 100 * 1000);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, 1000);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "s5");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        //auto.offset.reset
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return props;
    }

//    private Map<String, Object> consumerProps2() {
//        Map<String, Object> props = new HashMap<>(9);
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
//        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 100 * 1000);
//        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 100 * 1000);
//        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
//        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, 1000);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "s6");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//
//        //auto.offset.reset
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        return props;
//    }


    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Object>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerProps()));
        //并发数量
        factory.setConcurrency(100);
        //开启批量监听
        factory.setBatchListener(true);
        // 被过滤的消息将被丢弃
        factory.setAckDiscarded(true);
        // 设置记录筛选策略
        factory.setRecordFilterStrategy(new RecordFilterStrategy() {
            @Override
            public boolean filter(ConsumerRecord consumerRecord) {
                String msg = consumerRecord.value().toString();
//                if (Integer.parseInt(msg.substring(msg.length() - 1)) % 2 == 0) {
//                    return false;
//                }
                if (StringUtils.isEmpty(msg)) {
                    return true;
                }
                log.info("filter--->>>>>{}", msg);
                // 返回true消息将会被丢弃
                return false;
            }
        });
        // ack模式
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        return factory;
    }


//    @Bean
//    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Object>> kafkaListenerContainerFactory2() {
//        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerProps2()));
//        //并发数量
//        factory.setConcurrency(10);
//        //开启批量监听
//        factory.setBatchListener(true);
//        // 被过滤的消息将被丢弃
//        factory.setAckDiscarded(true);
//
////        factory.setau
//
//        // 设置记录筛选策略
//        factory.setRecordFilterStrategy(new RecordFilterStrategy() {
//            @Override
//            public boolean filter(ConsumerRecord consumerRecord) {
//                String msg = consumerRecord.value().toString();
////                if (Integer.parseInt(msg.substring(msg.length() - 1)) % 2 == 0) {
////                    return false;
////                }
//                if (StringUtils.isEmpty(msg)) {
//                    return true;
//                }
//                log.info("filter--->>>>>{}", msg);
//                // 返回true消息将会被丢弃
//                return false;
//            }
//        });
//        // ack模式
//        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
//        return factory;
//    }

    @Bean
    public NewTopic topic() {
        //主题 分区数  副本数
        return new NewTopic("test111111", 10, (short) 1);
    }

//    @Bean
//    public NewTopic topic1() {
//        return TopicBuilder.name("replication-test")
//                .partitions(10)
//                .replicas(3)
//                .compact()
//                .build();
//    }

}
