package gupao.designpriciple.composite;

public class Main {

    /**
     * 合成(组合)聚合复用原则
     * 组合：contain A
     * 聚合：has A
     * 集成: is A
     * 尽量少的使用集成，而应该多使用组合，聚合
     * 何为组合 合成？ 两个类保持同样的生命周期，一损俱损
     * public class A {
     *     Class B = new B()
     * }
     *
     * 何为聚合？
     * A中拥有B，但是B的生命周期由其他角色来维护，A只负责使用
     * public class A {
     *     private B b;
     *     constructor() {
     *       b = new B();
     *     }
     * }
     * @param args
     */
    public static void main(String[] args) {

    }
}
