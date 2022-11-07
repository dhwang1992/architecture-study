package gupao.designpriciple.factory.method;

import gupao.designpriciple.factory.simple.IFactory;
import gupao.designpriciple.factory.simple.ITea;
import gupao.designpriciple.factory.simple.LongjinTea;

public class LongjinTeaFactory implements IFactory {
    @Override
    public ITea getInstance(ITea tea) {
        return new LongjinTea(tea.getName(), tea.getColor());
    }
}
