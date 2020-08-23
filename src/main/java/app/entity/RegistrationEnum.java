package app.entity;

public enum RegistrationEnum {
    OPEN(0,"学籍开启"),
    CLOSE(1,"学籍关闭"),
    CHANGE(8,"学籍变更");
    private String registrationStatusDesc;
    private int registrationStatus;

    private RegistrationEnum(int registrationStatus,String registrationStatusDesc){
        this.registrationStatus = registrationStatus;
        this.registrationStatusDesc = registrationStatusDesc;
    }


    public static String getRegistrationStatusDesc(int registrationStatus){
//        获取全部的枚举
        RegistrationEnum [] registrationEnums = values();
        for (RegistrationEnum registrationEnum : registrationEnums) {
            if (registrationEnum.registrationStatus == registrationStatus){
                return registrationEnum.registrationStatusDesc;
            }
        }
        return "未知状态";
    }
}
