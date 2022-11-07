package gupao.designpriciple.interfaceisolation;

public interface IOrder {
    /**
     * 接口隔离原则
     * 接口隔离原则可以单一职责一起来看
     * 单一职责，讲究的是类的业务职责单一，而接口隔离原则更多是看接口设计层面，接口的设计是否是高内聚，低耦合，也就是接口内部的方法内聚性高，和外部的接口之间解耦
     * 在这个例子中，加入我有一天要对OperationOrder加入Delete方法，则我们在Iorder中添加方法，而我们明明只需要修改OperationOrder，但却对SalesOrder也做了改动
     * 这就是我们通常所说的胖接口，需要解耦接口
     */
    void apply();

    void approve();

    void imported();

    void export();
}
