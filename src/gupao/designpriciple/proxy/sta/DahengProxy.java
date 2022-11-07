package gupao.designpriciple.proxy.sta;

public class DahengProxy {

    private IPerson iPerson;

    public DahengProxy(IPerson iPerson) {
        this.iPerson = iPerson;
    }

    public void findGirlFriends() {
        System.out.println("物色");
        iPerson.findGirlFriends();
        System.out.println("完成");
    }
}
