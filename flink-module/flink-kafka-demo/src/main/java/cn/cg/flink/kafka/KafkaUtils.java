package cn.cg.flink.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * @author: cg
 * @date: 2023-11-03 20:26
 **/
public class KafkaUtils {

    static String serverList = "localhost:9092";

    static String topic = "";

    public static void writeToKafka() throws ExecutionException, InterruptedException {

        Properties props = new Properties();
        props.put("bootstrap.servers", serverList);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); //key 序列化
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); //value 序列化

        KafkaProducer producer = new KafkaProducer<String, String>(props);

        Map<String, Object> message = new HashMap<>();

        Random random = new Random();

        message.put("id", random.nextInt(10000));

        ProducerRecord record = new ProducerRecord<String, String>(topic, null, null, JSON.toJSONString(message));

        Future send = producer.send(record);

        producer.flush();

        send.get();

        System.out.println("发送数据: " + JSON.toJSONString(message));
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        while (true) {
            Thread.sleep(300);
            writeToKafka();
        }
    }
}
