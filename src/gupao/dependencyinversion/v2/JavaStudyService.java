package gupao.dependencyinversion.v2;

public class JavaStudyService implements IStudyService{
    @Override
    public void study() {
        System.out.println("正在学习Java");
    }
}
