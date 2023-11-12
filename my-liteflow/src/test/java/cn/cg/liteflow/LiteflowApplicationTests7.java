package cn.cg.liteflow;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class LiteflowApplicationTests7 {

    @Autowired
    private FlowExecutor flowExecutor;

    /**
     * 数据上下文
     */
    @Test
    void contextLoads() {
        LiteflowResponse response = flowExecutor.execute2Resp("chain101", "arg");
        System.out.println(response.getCode());
    }

}
