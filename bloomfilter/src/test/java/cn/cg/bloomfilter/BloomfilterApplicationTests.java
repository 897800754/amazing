package cn.cg.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.Charset;
import java.util.Random;

@SpringBootTest
class BloomfilterApplicationTests {
    /**
     * guava实现
     */
    @Test
    void contextLoads() {
//        BloomFilter<String> filter = BloomFilter.create(
//                Funnels.stringFunnel(Charset.defaultCharset()),
//                1500,
//                0.01);

        BloomFilter<String> filter = BloomFilter.create(
                Funnels.stringFunnel(Charset.defaultCharset()),
                //最多存放元素数量
                1500,
                //容忍误判概率
                0.00000001);

        Random random = new Random();

        int i = 10;

        while (i-- > 0) {
            filter.put(String.valueOf(random.nextInt(10)));
        }
//        filter.put("100");

        System.out.println(filter.mightContain("100"));

        System.out.println(filter.mightContain("10000000000000000"));

    }

    /**
     * redis实现
     */
    @Test
    void forRedis() {

    }


}
