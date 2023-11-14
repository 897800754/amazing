package cn.cg.my.sentinel.cloud.server;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    @SentinelResource(value = "HelloWorld", blockHandler = "helloWorldBlockHandler")
    public String helloWorld() throws InterruptedException {
        Thread.sleep(100);
        return "hello world";
    }

    // blockHandler 函数，原方法调用被限流/降级/系统保护的时候调用
    public String helloWorldBlockHandler(String id, BlockException ex) {
        System.out.printf("helloWorldBlockHandler id:%s exception:%s%n", id, ExceptionUtils.getStackTrace(ex));
        return "retry again";
    }

}
