package gupao.designpriciple.adapter;

public class Europe extends Adapter1 {

    public Europe(Adaptee adaptee) {
        super(adaptee);
    }

    @Override
    public int change220v() {
        int v = adaptee.change110v();
        System.out.println("输出330V电压");
        return v * 3;
        // 适配中国，就加一个中国的实现类
    }
}
