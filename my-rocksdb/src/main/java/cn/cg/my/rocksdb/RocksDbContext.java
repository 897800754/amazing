package cn.cg.my.rocksdb;

import org.rocksdb.*;

import java.util.*;

public class RocksDbContext {

    static {

        RocksDB.loadLibrary();

    }

    private static String path = "./my-rocksdb/data";
    private static volatile RocksDB rocksDB;

    private static Map<String, ColumnFamilyHandle> columnFamilyHandleMap = new HashMap<>(16);

    public static String second = "second";

    public static String first = "default";

    public static ColumnFamilyHandle getColumnFamily(String name) throws NoSuchFieldException {
        ColumnFamilyHandle columnFamilyHandle = columnFamilyHandleMap.get(name);
        if (Objects.isNull(columnFamilyHandle)) {
            throw new NoSuchFieldException(String.format("no find handle %s", name));
        }
        return columnFamilyHandle;
    }


    public static RocksDB getDb() throws RocksDBException {

        if (Objects.isNull(rocksDB)) {
            synchronized (RocksDbContext.class) {
                if (Objects.nonNull(rocksDB)) {
                    return rocksDB;
                }

                ColumnFamilyOptions cfOpts = new ColumnFamilyOptions().optimizeUniversalStyleCompaction();

                // list of column family descriptors, first entry must always be default column family
                List<ColumnFamilyDescriptor> cfDescriptors = Arrays.asList(
                        new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY, cfOpts),
                        new ColumnFamilyDescriptor(second.getBytes(), cfOpts));

                // a list which will hold the handles for the column families once the db is opened
                List<ColumnFamilyHandle> columnFamilyHandleList = new ArrayList<>();

                DBOptions options = new DBOptions().setCreateIfMissing(true).setCreateMissingColumnFamilies(true);
                rocksDB = RocksDB.open(options, RocksDbContext.path, cfDescriptors, columnFamilyHandleList);

                for (ColumnFamilyHandle columnFamilyHandle : columnFamilyHandleList) {
                    columnFamilyHandleMap.put(new String(columnFamilyHandle.getName()), columnFamilyHandle);
                }

            }
        }
        return rocksDB;
    }


    public static void scanAll() {

        for (Map.Entry<String, ColumnFamilyHandle> entry : columnFamilyHandleMap.entrySet()) {

            RocksIterator iter = rocksDB.newIterator(entry.getValue());

            System.out.println("===================================");

            System.out.printf("column family [%s] all key and value: \n", entry.getKey());

            for (iter.seekToFirst(); iter.isValid(); iter.next()) {

                System.out.println("iter key: " + new String(iter.key()) + ",iter value: " +

                        new String(iter.value()));

            }
            System.out.println("===================================");
        }

    }

}
