package leetcode.myStirng;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 将一个正整数,分解因数,例如:输入90,打印出90=2*3*3*5
 */
public class Demo6 {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Integer i = sc.nextInt();
        if (i == 1 || i <= 0) {
            System.out.println("请输入大于1的正整数");
            return;
        }
        //将因数写入集合
        Demo6.ss(i, arr);
        //遍历因数
        for (int j = 0; j < arr.size(); j++) {
            if (arr.size() == 1) {
                System.out.println(i + "为素数");
            } else if (j + 1 == arr.size()) {
                //最后一个因数
                System.out.print(arr.get(j));
            } else {
                System.out.print(arr.get(j) + "*");
            }
        }

    }

    public static void ss(Integer i, ArrayList<Integer> arr) throws RuntimeException {
        if (i == 1) {
            return;
        }
        if (i % 2 == 0) {
            //能够被整除,说明是偶数
            arr.add(2);
            ss(i / 2, arr);
        } else {
            //为奇数
            int num = 3;
            while (i % num != 0) {
                num += 2;
            }
            if (num == i) {
                //素数
                arr.add(i);
                return;
            }
            arr.add(num);
            ss(i / num, arr);
        }
    }
}
