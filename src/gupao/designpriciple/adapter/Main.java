package gupao.designpriciple.adapter;

public class Main {

    public static void main(String[] args) {
        int i = new Adapter().change220v();
        System.out.println(i);

        Europe europe = new Europe(new American());
        europe.change220v();
    }
}
