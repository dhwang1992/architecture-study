package gupao.dependencyinversion.v2;

public class StudyController {

    //依赖倒置原则，1.底层模块不应该依赖高层模块，高层模块依赖的是底层模块的抽象 2.所有我们始终依赖的是抽象，而不是实现
    // 在这个例子中，如果有一天我们需要使用JavaStudyService 的study方法，我们只需要
    // new StudyController(new JavaStudyService())，而不用去改StudyController的代码
    private IStudyService studyService;

    public StudyController(IStudyService studyService) {
        this.studyService = studyService;
    }

    public void study() {
        this.studyService.study();
    }
}
