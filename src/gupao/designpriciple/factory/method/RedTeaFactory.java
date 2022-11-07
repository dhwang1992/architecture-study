package gupao.designpriciple.factory.method;

import gupao.designpriciple.factory.simple.IFactory;
import gupao.designpriciple.factory.simple.ITea;
import gupao.designpriciple.factory.simple.RedTea;

public class RedTeaFactory implements IFactory {

    @Override
    public ITea getInstance(ITea tea) {
        return new RedTea(tea.getName(), tea.getColor());
    }
}
