package gupao.designpriciple.adapter;

/**
 * 适配Target的需求，输出220V电压
 * 假如现在要适配欧洲的请求呢？ 得针对欧洲再加一个适配器？
 */
public class Adapter extends American implements Target{
    @Override
    public int change220v() {
        int originV = super.change110v();
        System.out.println("输出220V电压");
        return originV * 2;
    }
}
