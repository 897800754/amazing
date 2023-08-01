package cn.cg.liteflow;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class LiteflowApplicationTests3 {

    @Autowired
    @Resource
    private FlowExecutor flowExecutor;

    /**
     * 次数循环组件
     */
    @Test
    void contextLoads() {
        LiteflowResponse response = flowExecutor.execute2Resp("chain4", "arg");
        System.out.println(response.getCode());
    }

}
