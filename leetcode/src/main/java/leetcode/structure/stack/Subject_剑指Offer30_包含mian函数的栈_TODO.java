package leetcode.structure.stack;

import java.util.Stack;

/**
 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/50bp33/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_剑指Offer30_包含mian函数的栈_TODO {

    public static void main(String[] args) {

    }


    class CQueue {

        private Stack<Integer> stack1 = new Stack();

        private Stack<Integer> stack2 = new Stack();


        public CQueue() {

        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            //先出stack2
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            //已经出完了,那么将stack1的元素加入到stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            return -1;
        }
    }


}




