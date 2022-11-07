package gupao.designpriciple.dependencyinversion.v2;

public class StudyService implements IStudyService{

    @Override
    public void study() {
        System.out.println("正在学习中");
    }
}
