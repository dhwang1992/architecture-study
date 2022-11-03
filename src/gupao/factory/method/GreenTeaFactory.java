package gupao.factory.method;

import gupao.factory.simple.GreenTea;
import gupao.factory.simple.IFactory;
import gupao.factory.simple.ITea;

public class GreenTeaFactory implements IFactory {
    @Override
    public ITea getInstance(ITea tea) {
        return new GreenTea(tea.getName(), tea.getColor());
    }
}
