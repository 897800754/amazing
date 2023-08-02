package cn.cg.liteflow.data.context;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.DefaultContext;

/**
 * @author: cg
 * @date: 2023-08-01 17:35
 **/
@LiteflowComponent("bData")
public class BDataNode extends NodeComponent {
    @Override
    public void process() throws Exception {
        DefaultContext contextBean = this.getContextBean(DefaultContext.class);
        Object hello = contextBean.getData("hello");
        System.out.println(hello);
    }
}
