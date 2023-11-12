package spendreport;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.CoFlatMapFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.walkthrough.common.entity.Alert;
import org.apache.flink.walkthrough.common.sink.AlertSink;

/**
 * @author: cg
 * @date: 2023-11-06 16:18
 **/
public class Main {
    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<Person> one = env.fromElements(new Person("张三", 1),
                new Person("李四", 10),
                new Person("王五", 20)

        );

        DataStreamSource<Person> two = env.fromElements(new Person("张三1", 10),
                new Person("李四1", 100),
                new Person("王五1", 200)

        );
        SingleOutputStreamOperator<Alert> streamOperator = one.connect(two)
                .flatMap(new CoFlatMapFunction<Person, Person, Person>() {
                    @Override
                    public void flatMap1(Person value, Collector<Person> out) throws Exception {
                        out.collect(value);
                    }

                    @Override
                    public void flatMap2(Person value, Collector<Person> out) throws Exception {
                        out.collect(value);
                    }
                }).map(x -> {

                    Alert alert = new Alert();
                    alert.setId(x.getId());
                    return alert;
                });
        ;

        streamOperator
                .addSink(new AlertSink())
                .name("send-alerts");


        env.execute("flink-hell-pipeline");
    }

    public static class Person {


        private String name;

        private Integer id;

        public Person(String name, Integer id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
