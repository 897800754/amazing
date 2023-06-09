package cn.cg.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: cg
 * @date: 2023-06-05 18:01
 **/
@RestController
public class TestController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        redisTemplate.opsForValue().increment("hello");
        return "hell world " + redisTemplate.opsForValue().get("hello");
    }
}
