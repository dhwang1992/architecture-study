package gupao.designpriciple.proxy.sta;

public class Main {
    public static void main(String[] args) {
        // 代理特定的人
        DahengProxy proxy = new DahengProxy(new XiaoQiang());
        proxy.findGirlFriends();

        // 代理一类人
        DahengProxy proxy1 = new DahengProxy(new Jingzhang());
        proxy1.findGirlFriends();

        // 那如果现在代理的人不是人的需求呢？ 如果现在小强要找男朋友了呢？
        // 那我们是不是要添加一个新的代理类
    }
}
