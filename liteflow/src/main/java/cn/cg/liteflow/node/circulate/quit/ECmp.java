package cn.cg.liteflow.node.circulate.quit;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeBreakComponent;

@LiteflowComponent("e")
public class ECmp extends NodeBreakComponent {
    @Override
    public boolean processBreak() throws Exception {
        //这里根据业务去返回break的结果
        return true;
    }
}
