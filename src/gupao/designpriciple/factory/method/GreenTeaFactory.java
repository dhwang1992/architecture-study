package gupao.designpriciple.factory.method;

import gupao.designpriciple.factory.simple.GreenTea;
import gupao.designpriciple.factory.simple.IFactory;
import gupao.designpriciple.factory.simple.ITea;

public class GreenTeaFactory implements IFactory {
    @Override
    public ITea getInstance(ITea tea) {
        return new GreenTea(tea.getName(), tea.getColor());
    }
}
