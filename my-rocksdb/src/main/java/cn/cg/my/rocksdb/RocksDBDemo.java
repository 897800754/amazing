package cn.cg.my.rocksdb;

import org.rocksdb.RocksDB;

import java.util.Random;

public class RocksDBDemo {


    public static void main(String[] args) throws Exception {

        RocksDB rocksDB = RocksDbContext.getDb();

        Random random = new Random();

        String key = "key"+random.nextInt(1000);
        String value = "value"+random.nextInt(1000);


        System.out.printf("put: key is %s, value is %s%n", key, value);

        rocksDB.put(key.getBytes(), value.getBytes());

        System.out.println("===================================");

        byte[] bytes = rocksDB.get(key.getBytes());

        System.out.printf("get: key is %s, value is %s%n", key, new String(bytes));

        RocksDbContext.scanAll();


    }

}