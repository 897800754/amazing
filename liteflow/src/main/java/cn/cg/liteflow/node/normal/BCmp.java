package cn.cg.liteflow.node.normal;

import com.yomahub.liteflow.core.NodeComponent;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component("b")
public class BCmp extends NodeComponent {

    @Override
    @SneakyThrows
    public void process() {
        System.out.println("B do something....");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("B do something finished....");
    }
}
