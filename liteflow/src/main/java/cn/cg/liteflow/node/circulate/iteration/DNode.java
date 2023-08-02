package cn.cg.liteflow.node.circulate.iteration;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @author: cg
 * @date: 2023-08-01 17:05
 **/
@LiteflowComponent("d")
public class DNode extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("d do something ");
        Object currLoopObj = this.getCurrLoopObj();
        System.out.println(currLoopObj.toString());
    }
}
