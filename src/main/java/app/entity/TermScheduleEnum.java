package app.entity;

public enum TermScheduleEnum {
    WAIT(0,"待报名"),
    DOING(1,"报名中"),
    WAIT_START(2,"待开营"),
    STARTED(3,"已开营"),
    END(4,"已结束");
    private String termScheduleStatusDesc;
    private int termScheduleStatus;

    private TermScheduleEnum(int termScheduleStatus,String termScheduleStatusDesc){
        this.termScheduleStatus = termScheduleStatus;
        this.termScheduleStatusDesc = termScheduleStatusDesc;
    }

}
