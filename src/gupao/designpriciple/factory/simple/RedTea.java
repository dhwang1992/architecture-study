package gupao.designpriciple.factory.simple;

public class RedTea implements ITea{

    private String name;
    private String color;

    public RedTea(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getColor() {
        System.out.println("Red Tea color is"+color);
        return this.color;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
