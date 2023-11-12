package leetcode.structure.arr;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/boats-to-save-people/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_881_救生艇 {

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }

    public static int numRescueBoats(int[] people, int limit) {
        if (people.length == 0) {
            return 0;
        }
        int count = 0;
        //对体重进行排序
        Arrays.sort(people);
        int l = 0;
        int h = people.length - 1;

        //体重最高的+体重最小的 小于等于limit 即 +1

        while (l <= h) {
            if (l == h) {
                count++;
                break;
            }
            int lp = people[l];
            int hp = people[h];
            //尝试加上体重最轻的
            if (lp + hp <= limit) {
                count++;
                l++;
                h--;
            } else if (hp <= limit) {
                count++;
                h--;
            }
        }
        return count;
    }
}




