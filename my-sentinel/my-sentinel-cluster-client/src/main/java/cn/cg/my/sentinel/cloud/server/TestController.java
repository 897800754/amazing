package cn.cg.my.sentinel.cloud.server;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    @SentinelResource("HelloWorld")
    public String helloWorld() throws InterruptedException {
        Thread.sleep(100);
        return "hello world";
    }



}
