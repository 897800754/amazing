package spendreport;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author: cg
 * @date: 2023-11-06 16:18
 **/
public class Main {
    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<Person> dataStreamSource = env.fromElements(new Person("张三", 1),
                new Person("李四", 10),
                new Person("王五", 20)

        );
        //env.readTextFile()
        //env.socketTextStream()

        SingleOutputStreamOperator<Person> filter = dataStreamSource.filter(new FilterFunction<Person>() {

            @Override
            public boolean filter(Person value) throws Exception {
//                return value.age < 15;
                return true;
            }
        });
        filter.print();

        env.execute("flink-hell-dataSteam-api");
    }

    public static class Person {
        private String name;

        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
