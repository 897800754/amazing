package leetcode.myStirng;

import java.util.Arrays;

/**
 * @author Administrator
 * @title: Demo11
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/7/722:05
 */
public class Demo11 {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        int[] arr = {12, 11, 15, 11, 12, 11, 51};
        Demo11 d = new Demo11();
        System.out.println(Arrays.toString(d.getnewArr(arr)));
    }

    public static int[] getnewArr(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    break;
                }
            }
        }
        int newArr[] = new int[arr.length - count];
        int a = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    break;
                } else if (arr[i] != arr[j]) {
                    newArr[a] = arr[i];
                    a++;
                }
            }
        }
        newArr[arr.length - count - 1] = arr[arr.length - 1];
        return newArr;
    }
}



