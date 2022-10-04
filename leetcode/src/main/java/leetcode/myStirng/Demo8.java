package leetcode.myStirng;


/**
 * 有1,2,3,4个数字,能组成多少个互不相同且无重复数字的三位数?都是多少?
 */
public class Demo8 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        //计数器
        int count = 0;
        //和
        int sum = 0;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            //百位
            for (int j = 0; j < arr.length; j++) {
                //十位
                for (int k = 0; k < arr.length; k++) {
                    //个位
                    if (i != j && i != k && j != k) {
                        count++;
                        temp = arr[i] * 100 + arr[j] * 10 + arr[k];
                        System.out.println(temp);
                        sum += temp;
                    }

                }
            }
        }
        System.out.println("共有: " + count);
        System.out.println("和为: " + sum);
    }
}
