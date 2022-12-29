package cn.cg.spring.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: cg
 * @date: 2022-12-06 15:33
 **/
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)

public class KfKPartitionTest {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Resource
    private ObjectMapper objectMapper;


    public void setKafkaTemplate() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        //注意分区器在这里！！！
        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, MyPartitioner.class);
        this.kafkaTemplate = new KafkaTemplate<String, Object>(new DefaultKafkaProducerFactory<>(props));
    }

    /**
     * 自定义
     */
    @Test
    @SneakyThrows
    public void test4() {
        setKafkaTemplate();
        int i = 100;
        while ((i = i - 1) > 0) {
            Model model = new Model();
            model.setId(100L);
            model.setName(String.valueOf(i));
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send("partition-test", String.valueOf(i), objectMapper.writeValueAsString(model));
            //同步模式
            System.out.println("sendMessage,result:" + objectMapper.writeValueAsString(future.get()));
        }
    }


    public static class MyPartitioner implements Partitioner {

        /**
         * Compute the partition for the given record.
         *
         * @param topic      The topic name
         * @param key        The key to partition on (or null if no key)
         * @param keyBytes   The serialized key to partition on( or null if no key)
         * @param value      The value to partition on or null
         * @param valueBytes The serialized value to partition on or null
         * @param cluster    The current cluster metadata
         */
        @Override
        public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
            String keyStr = key + "";
            if (keyStr.startsWith("0")) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public void close() {

        }

        @Override
        public void configure(Map<String, ?> map) {

        }
    }

    @Data
    public static class Model {
        private Long id;
        private String name;

    }
}
