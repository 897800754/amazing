package leetcode.structure.string;

/**
 * https://leetcode.cn/problems/remove-letter-to-equalize-frequency/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_2423_删除字符使频率相同_TODO {
    public static void main(String[] args) {
        System.out.println(equalFrequency("aa"));
//        System.out.println(equalFrequency("aazz"));
    }

    /**
     * 使用hash表记录每个字母出现的频率,
     * 所有频率相减 = 0 返回false. =1
     *
     * @param word
     * @return
     */
    public static boolean equalFrequency(String word) {
        int[] ints = new int['z' - 'a' + 1];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            ints[c - 'a']++;
        }
        //每个字符出现的次数.

        //每种频次出现的字符数,  仅当有两种频次,且其中一个频次-1 = 第二个频次
        int[] hz = new int[2];
        for (int anInt : ints) {
            if (anInt == 0) {
                continue;
            }
            if (hz[0] == 0 || hz[0] == anInt) {
                hz[0] = anInt;
            } else if (hz[1] == 0 || hz[1] == anInt) {
                hz[1] = anInt;
            } else {
                return false;
            }
        }
        if (hz[0] == 0 || hz[1] == 0) {
            return true;
        }
        return hz[0] - 1 == hz[1] || hz[1] - 1 == hz[0];
    }
}
