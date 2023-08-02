package cn.cg.liteflow;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class LiteflowApplicationTests4 {

    @Autowired
    private FlowExecutor flowExecutor;

    /**
     * 条件循环组件
     */
    @Test
    void contextLoads() {
        LiteflowResponse response = flowExecutor.execute2Resp("chain5", "arg");
        System.out.println(response.getCode());
    }

}
