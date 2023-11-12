package cn.cg.flink.kafka;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Main {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

//        KafkaSource<String> source = KafkaSource.<String>builder()
//                .setBootstrapServers(brokers)
//                .setTopics("input-topic")
//                .setGroupId("my-group")
//                .setStartingOffsets(OffsetsInitializer.earliest())
//                .setValueOnlyDeserializer(new SimpleStringSchema())
//                .build();
//
//        env.execute("Flink add data source");
    }
}
