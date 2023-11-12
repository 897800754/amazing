package cn.cg.unsafe;

/**
 * @author: cg
 * @date: 2023-03-17 18:15
 **/
public class MemoryOperation {


    public static void main(String[] args) {
        int size = 4;
        long addr = UnSafeUtils.getUnsafe().allocateMemory(size);
        long addr3 = UnSafeUtils.getUnsafe().reallocateMemory(addr, size * 2);
        System.out.println("addr: " + addr);
        System.out.println("addr3: " + addr3);
        try {
            UnSafeUtils.getUnsafe().setMemory(null, addr, size, (byte) 1);
            for (int i = 0; i < 2; i++) {

                UnSafeUtils.getUnsafe().copyMemory(null, addr, null, addr3 + size * i, 4);
            }
            System.out.println(UnSafeUtils.getUnsafe().getInt(addr));
            System.out.println(UnSafeUtils.getUnsafe().getLong(addr3));
        } finally {
            UnSafeUtils.getUnsafe().freeMemory(addr);
            UnSafeUtils.getUnsafe().freeMemory(addr3);
        }
    }


}
