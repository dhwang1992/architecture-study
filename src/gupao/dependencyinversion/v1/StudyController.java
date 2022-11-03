package gupao.dependencyinversion.v1;

public class StudyController {

    // studyController依赖了studyService这个实现
    // 但假如有一天我想使用JavaStudyService的study方法，那么在这种设计下，我必须
    /**private JavaStudyService studyService;

     * public StudyController(JavaStudyService studyService) {
     *         this.studyService = studyService;
     *     }
     */
    private StudyService studyService;

    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }

    public void study() {
        this.studyService.study();
    }
}
