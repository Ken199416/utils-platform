package app.entity;
// 完课规则
public enum LessonFinishRuleEnum {
    ONE(1,"完成知识点"),
    TWO(2,"完成客观题"),
    THREE(3,"完成主观题"),
    FOUR(4,"完成课程作业");

    private String desc;
    private int flag;

    private LessonFinishRuleEnum(int flag,String desc){
        this.flag = flag;
        this.desc = desc;
    }


    public static String getLessonFinishRuleDesc(int flag){
//        获取全部的枚举
        LessonFinishRuleEnum [] lessonFinishRuleEnums = values();
        for (LessonFinishRuleEnum lessonFinishRuleEnum : lessonFinishRuleEnums) {
            if (lessonFinishRuleEnum.flag == flag){
                return lessonFinishRuleEnum.desc;
            }
        }
        return "未知状态";
    }
}
