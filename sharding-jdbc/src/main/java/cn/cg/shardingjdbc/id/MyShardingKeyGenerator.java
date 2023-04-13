package cn.cg.shardingjdbc.id;

import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;

/**
 * @author: cg
 * @date: 2022-11-30 15:50
 **/
public class MyShardingKeyGenerator implements ShardingKeyGenerator {
    @Override
    public Comparable<?> generateKey() {
        return "simple:" + System.currentTimeMillis();
    }

    @Override
    public String getType() {
        return "SIMPLE";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }

}

