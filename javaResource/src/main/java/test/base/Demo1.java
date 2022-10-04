package test.base;

/**
 * @author: cg1
 * @date: 2021-06-09 13:58
 **/
public class Demo1 {
    public static void main(String[] args) {
        B b = new B();
    }

    public static class A {
        private String name;
        private String nickname;

        protected A show() {
            return new A();
        }

    }

    public static class B extends A {
        @Override
        public B show() {
            return new B();
        }
    }
}
