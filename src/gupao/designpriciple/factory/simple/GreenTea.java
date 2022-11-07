package gupao.designpriciple.factory.simple;

public class GreenTea implements ITea{

    private String name;
    private String color;

    public GreenTea(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getColor() {
        System.out.println("Green Tea color is"+color);
        return this.color;
    }

    @Override
    public String getName() {
        System.out.println("Green Tea name is"+name);
        return this.name;
    }
}
