package gupao.designpriciple.factory.simple;

public class LongjinTea implements ITea{

    private String name;

    private String color;

    public LongjinTea(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
