package cn.cg.spring.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

/**
 * @author: cg
 * @date: 2022-12-06 11:41
 **/
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class KfKTest {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Resource
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    public void test1() {
        int i = 100;
        while ((i = i - 1) > 0) {
            Model model = new Model();
            model.setId(100L);
            model.setName(String.valueOf(i));
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send("test", objectMapper.writeValueAsString(model));
            System.out.println("sendMessage,result:" + objectMapper.writeValueAsString(future.get()));
        }
    }

    /**
     * 指定分区
     */
    @Test
    @SneakyThrows
    public void test2() {
        int i = 100;
        while ((i = i - 1) > 0) {
            Model model = new Model();
            model.setId(100L);
            model.setName(String.valueOf(i));
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send("partition-test", 0, "123", objectMapper.writeValueAsString(model));
            System.out.println("sendMessage,result:" + objectMapper.writeValueAsString(future.get()));
        }
    }

    /**
     * #不指定数字分区时，按照key的hash决定分区
     */
    @Test
    @SneakyThrows
    public void test3() {


        kafkaTemplate.setProducerListener(new ProducerListener() {
            @Override
            public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
                log.info("我已经接收到消息-----message={}", producerRecord.value());

            }

            @SneakyThrows
            @Override
            public void onError(ProducerRecord producerRecord, Exception exception) {
                log.info("失败:{},{}", objectMapper.writeValueAsString(producerRecord), ExceptionUtils.getStackTrace(exception));
            }
        });

        int i = 100;
        while ((i = i - 1) > 0) {
            Model model = new Model();
            model.setId(100L);
            model.setName(String.valueOf(i));
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send("partition-test", String.valueOf(i), objectMapper.writeValueAsString(model));
            System.out.println("sendMessage,result:" + objectMapper.writeValueAsString(future.get()));
        }
    }


    @Data
    public static class Model {
        private Long id;
        private String name;

    }

}
