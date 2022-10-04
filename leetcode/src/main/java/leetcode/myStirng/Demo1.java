package leetcode.myStirng;

/**
 * 字符串:abacdbbbcaadfceaeeenmhkyyyyllldfdssFFHHAdfdsjklFDSFa
 * 去掉重复字符,小写输出
 */
public class Demo1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String target = "abacdbbbcaadfceaeeenmhkyyyyllldfdssFFHHAdfdsjklFDSFa";
        for (int i = 0; i < 10; i++) {
            target += target;
        }
        char[] charArr = target.toLowerCase().toCharArray();
        char[] charArr2 = new char[200];
        for (int i = 0; i < charArr.length; i++) {
            if (charArr2[charArr[i]] != charArr[i]) {
                charArr2[charArr[i]] = charArr[i];
            }
        }
        for (int i = 0; i < charArr2.length; i++) {
            if (charArr2[i] != '\0') {
                System.out.print(charArr2[i]);
            }
        }
        System.out.println(target);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
