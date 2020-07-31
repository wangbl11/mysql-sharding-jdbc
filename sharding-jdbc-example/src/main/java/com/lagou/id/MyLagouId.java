package com.lagou.id;

import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.io.Serializable;
import java.util.Properties;

public class MyLagouId implements ShardingKeyGenerator {
    private SnowflakeShardingKeyGenerator snowflakeShardingKeyGenerator =new SnowflakeShardingKeyGenerator();
    @Override
    public Comparable<?> generateKey() {
        System.out.println("--------执行了自定义主键生成器MyLagouId-------------------");
        return snowflakeShardingKeyGenerator.generateKey();
    }

    @Override
    public String getType() {
        return "LAGOUKEY";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
