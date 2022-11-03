package gupao.factory.method;

import gupao.factory.simple.IFactory;
import gupao.factory.simple.ITea;
import gupao.factory.simple.RedTea;

public class RedTeaFactory implements IFactory {

    @Override
    public ITea getInstance(ITea tea) {
        return new RedTea(tea.getName(), tea.getColor());
    }
}
