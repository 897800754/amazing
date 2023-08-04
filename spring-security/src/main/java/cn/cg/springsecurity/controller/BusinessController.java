package cn.cg.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cg
 * @date: 2023-08-03 17:50
 **/
@RestController
public class BusinessController {

    @RequestMapping("/bus")
    public Object business() {
        Map<String, Object> res = new HashMap<>(2);
        res.put("data", "business-data");
        return res;
    }

}
