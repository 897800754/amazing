package cn.cg.liteflow.node.normal;

import com.yomahub.liteflow.core.NodeComponent;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component("a")
public class ACmp extends NodeComponent {

    @SneakyThrows
    @Override
    public void process() {
        System.out.println("A do something....");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("A do something finished....");

    }
}
