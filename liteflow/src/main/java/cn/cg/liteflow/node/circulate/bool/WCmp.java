package cn.cg.liteflow.node.circulate.bool;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeWhileComponent;

@LiteflowComponent("w")
public class WCmp extends NodeWhileComponent {
    @Override
    public boolean processWhile() throws Exception {
        //这里根据业务去返回while的结果
        //
        return System.currentTimeMillis() / 2 == 1 ? true : false;
    }
}
