package cn.cg.liteflow.node.condition;

import com.yomahub.liteflow.core.NodeIfComponent;
import org.springframework.stereotype.Component;

@Component("x")
public class XCmp extends NodeIfComponent {
    @Override
    public boolean processIf() throws Exception {
        System.out.println("x do something ....");
        return true;
    }
}
