package app.entity;
//课程解锁规则
public enum LessonUnlockRuleEnum {
    SX(1,"顺序解锁"),
    WAIT(2,"开课后{0}天解锁{1}小节");

    private int flag;
    private String desc;
    private LessonUnlockRuleEnum(int flag,String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public static String getLessonUnlockRuleDesc(int flag){
        LessonUnlockRuleEnum [] lessonUnlockRuleEnums = values();
        for (LessonUnlockRuleEnum lessonUnlockRuleEnum : lessonUnlockRuleEnums) {
            if (lessonUnlockRuleEnum.flag == flag){
                return lessonUnlockRuleEnum.desc;
            }
        }
        return "未知状态";
    }
}
