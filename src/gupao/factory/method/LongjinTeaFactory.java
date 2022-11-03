package gupao.factory.method;

import gupao.factory.simple.IFactory;
import gupao.factory.simple.ITea;
import gupao.factory.simple.LongjinTea;

public class LongjinTeaFactory implements IFactory {
    @Override
    public ITea getInstance(ITea tea) {
        return new LongjinTea(tea.getName(), tea.getColor());
    }
}
