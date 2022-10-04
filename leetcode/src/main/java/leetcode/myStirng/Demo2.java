package leetcode.myStirng;


public class Demo2 {
    private static String str;

    public void doIt() {
        str = "abacdbbbcaadfceaeeenmhkyyyyllldfdssFFHHAdfdsjklFDSFa".toLowerCase();
        for (int i = 0; i < 10; i++) {
            str += str;
        }
        char[] s = str.toCharArray();
        char[] t = new char[100];
        int i, j;
        char k;
        for (i = 0; i < s.length; i++) {
            for (j = i + 1; j < s.length; j++) {
                if (s[i] == s[j] && s[i] != 0) {
                    s[j] = 0;
                }
            }
        }
        i = 0;
        j = 0;
        while (i < s.length) {
            if (s[i] != 0) {
                t[j] = s[i];
                j++;
            }
            i++;
        }
        for (i = 0; i < t.length; i++) {
            for (j = i + 1; j < t.length; j++) {
                if (t[i] > t[j]) {
                    k = t[j];
                    t[j] = t[i];
                    t[i] = k;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (i = 0; i < t.length; i++) {
            sb.append(t[i]);
        }
        str = sb.toString();
        System.out.println(str);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Demo2 t = new Demo2();
        t.doIt();
        System.out.println(str);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}

