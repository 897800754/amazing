package leetcode.myStirng;

import java.util.ArrayList;

/**
 * 入参是两个分数，例如1/3和4/5，程序输出两个分数的加合，最后用分数表示。
 */
public class Demo12 {
    public static void main(String[] args) {
        //目标分数
        String num1 = "9/16";
        String num2 = "3/35";
        String[] num1Arr = num1.split("/");
        String[] num2Arr = num2.split("/");
        //将字符串解析
        int num1mu = Integer.parseInt(num1Arr[1]);
        int num1zi = Integer.parseInt(num1Arr[0]);
        int num2mu = Integer.parseInt(num2Arr[1]);
        int num2zi = Integer.parseInt(num2Arr[0]);
        //计算分母
        int mu = num1mu * num2mu;
        //计算分子
        int zi = num1mu * num2zi + num2mu * num1zi;
        //结果
        System.out.println("约分前的结果为:" + zi + "/" + mu);
        //约分
        ArrayList<Integer> ziList = new ArrayList<>();
        ArrayList<Integer> muList = new ArrayList<>();
        Demo12.factorization(zi, ziList);
        Demo12.factorization(mu, muList);
        for (int i = 0; i < muList.size(); i++) {
            for (int j = 0; j < ziList.size(); j++) {
                if (muList.get(i) == ziList.get(j)) {
                    muList.remove(i);
                    ziList.remove(j);
                }
            }
        }
       /* System.out.println(muList.toString());
        System.out.println(ziList.toString());*/
        //最终结果
        int finalzi = 1;
        int finalmu = 1;
        for (Integer i : muList) {
            finalmu *= i;
        }
        for (Integer i : ziList) {
            finalzi *= i;
        }
        System.out.println("最简结果为:" + finalzi + "/" + finalmu);
    }

    //对int类型数字进行因式分解
    public static void factorization(Integer i, ArrayList<Integer> arr) throws RuntimeException {
        if (i == 1) {
            return;
        }
        if (i % 2 == 0) {
            //能够被整除,说明是偶数
            arr.add(2);
            factorization(i / 2, arr);
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
            factorization(i / num, arr);
        }
    }
}
