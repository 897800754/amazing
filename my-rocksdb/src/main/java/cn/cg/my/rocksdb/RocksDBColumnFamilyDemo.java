package cn.cg.my.rocksdb;

import org.rocksdb.*;

import java.util.*;

/*
 *
 * 列族 demo
 */
public class RocksDBColumnFamilyDemo {


    public static void main(String[] args) throws Exception {

        RocksDB db = RocksDbContext.getDb();

        ColumnFamilyHandle columnFamily = RocksDbContext.getColumnFamily(RocksDbContext.second);


        Random random = new Random();

        String key = "key" + random.nextInt(1000);
        String value = "value" + random.nextInt(1000);

        System.out.printf("put: ColumnFamily %s key is %s, value is %s%n",RocksDbContext.second, key, value);

        db.put(columnFamily,key.getBytes(), value.getBytes());

        RocksDbContext.scanAll();




    }

}
