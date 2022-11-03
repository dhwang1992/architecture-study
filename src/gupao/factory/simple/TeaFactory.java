package gupao.factory.simple;

public class TeaFactory implements IFactory{

    @Override
    public ITea getInstance(ITea tea) {
        if ("green".equals(tea.getColor())) {
            return new GreenTea(tea.getName(), tea.getColor());
        } if ("red".equals(tea.getColor())){
            return new RedTea(tea.getName(), tea.getColor());
        } else {
            return new LongjinTea(tea.getName(),  tea.getColor());
        }
    }
}
