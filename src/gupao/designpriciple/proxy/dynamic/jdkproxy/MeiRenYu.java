package gupao.designpriciple.proxy.dynamic.jdkproxy;

public class MeiRenYu implements IAnimal, IPerson{
    @Override
    public void eat() {
        System.out.println("美人鱼吃小鱼");
    }

    @Override
    public void findGirlFriends() {
        System.out.println("美人鱼找女朋友");
    }
}
