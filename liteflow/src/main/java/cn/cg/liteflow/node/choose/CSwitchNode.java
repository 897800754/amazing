package cn.cg.liteflow.node.choose;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;

/**
 * @author: cg
 * @date: 2023-08-01 16:41
 **/
@LiteflowComponent("c")
public class CSwitchNode extends NodeSwitchComponent {
    @Override
    public String processSwitch() throws Exception {
        return "a";
    }
}
