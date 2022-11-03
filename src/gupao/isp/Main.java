package gupao.isp;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.fun(3, 2);
        // 调用A的fun方法时，会相加，结果为3
        // 此时如果将A替换为B， 结果会变成1，违背了里式替换原则
        // 定义，在所有使用类型T 的对象o1的地方，都可以使用类型为S的对象o2来替换，且对程序不会有任何影响，那么我们就可以认为S是T的子类
        // 很明显在这种情况下 B 就不应该是A的子类
        A b = new B();
        b.fun(3, 2);

        // 子类可以增加自己的方法 B不应该重写A的方法，但是可以新增一个自己的方法
        // 前提：子类不应该重写父类的方法，但是子类重载或者实现父类的方法时，参数需要比父类更为宽松
        /***
         * public class A {
         *     void fun(HashMap hashMap) {
         *         sout("size is:"+ hashMap.size());
         *     }
         * }
         *
         * B中的fun不能重写A，重写则不符合里式替换原则，所以这里只能是重载，那么在重载时，如果参数比HashMap 更为严格
         * public class B extends A {
         *     void fun(Map map) {
         *
         *     }
         * }
         *
         * A a = new A();
         * HashMap map = new HashMap();
         * a.fun(map);
         *
         *
         * A b = new B();
         * b.fun(map);
         *
         * 如果这里的参数不宽松一些的话，那么b.fun调用则会调用到重载的方法，而不是原来的父类方法，会影响程序本身的运行结果
         *
         * SIP主要符合以下四个规则
         * 1. 子类不应该重写父类的方法
         * 2. 子类可以实现自己的方法
         * 3. 子类重载父类的方法时，要求入参必须比父类更宽松
         * 4. 子类实现父类的方法时，返回值必须比父类更严格（返回值必须和父类保持一致，或者是父类返回的子类，不然编译会报错）
         */
    }
}
