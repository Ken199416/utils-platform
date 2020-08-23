package app.entity;

import java.io.PipedReader;
import java.util.Date;
import java.io.Serializable;

/**
 * 用户的课程记录表(UserLessonLearningRecord)实体类
 *
 * @author makejava
 * @since 2020-07-05 10:25:12
 */
public class UserLessonLearningRecord implements Serializable {
    private static final long serialVersionUID = 313824671445971032L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 用户id
    */
    private Integer passportId;
    /**
    * 用户编码
    */
    private String riseId;
    /**
    * 学籍号
    */
    private String registrationId;
    /**
    * 课表id
    */
    private Integer termTimetableId;
    /**
    * 排期id
    */
    private Integer termScheduleId;
    /**
    * 排期编码
    */
    private String termScheduleCode;
    /**
    * 课程包id
    */
    private Integer lessonPackageId;
    /**
    * 课程包编码
    */
    private String lessonPackageCode;
    /**
    * 课程id
    */
    private Integer lessonId;
    /**
    * 课程编码
    */
    private String lessonCode;
    /**
    * z主辅修0:主修,1:辅修
    */
    private Integer lessonType;
    /**
    * 课程标题
    */
    private String title;
    /**
    * 已完成的小节数
    */
    private Integer sectionProgress;
    /**
    * 小节总数
    */
    private Integer sectionTotal;
    /**
    * 课程进度，0初始状态 1已开始 2已完成 3已过期
    */
    private Integer progress;
    /**
    * 解锁标识：0，未使用过解锁卡；1，使用过解锁卡
    */
    private Integer unlockFlag;
    /**
    * 课程评价弹框,默认0不可弹框,1可弹框,2已弹框
    */
    private Integer bulletBox;
    /**
    * 状态，0有效 1无效
    */
    private Integer status;

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;

    private Integer step;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPassportId() {
        return passportId;
    }

    public void setPassportId(Integer passportId) {
        this.passportId = passportId;
    }

    public String getRiseId() {
        return riseId;
    }

    public void setRiseId(String riseId) {
        this.riseId = riseId;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public Integer getTermTimetableId() {
        return termTimetableId;
    }

    public void setTermTimetableId(Integer termTimetableId) {
        this.termTimetableId = termTimetableId;
    }

    public Integer getTermScheduleId() {
        return termScheduleId;
    }

    public void setTermScheduleId(Integer termScheduleId) {
        this.termScheduleId = termScheduleId;
    }

    public String getTermScheduleCode() {
        return termScheduleCode;
    }

    public void setTermScheduleCode(String termScheduleCode) {
        this.termScheduleCode = termScheduleCode;
    }

    public Integer getLessonPackageId() {
        return lessonPackageId;
    }

    public void setLessonPackageId(Integer lessonPackageId) {
        this.lessonPackageId = lessonPackageId;
    }

    public String getLessonPackageCode() {
        return lessonPackageCode;
    }

    public void setLessonPackageCode(String lessonPackageCode) {
        this.lessonPackageCode = lessonPackageCode;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonCode() {
        return lessonCode;
    }

    public void setLessonCode(String lessonCode) {
        this.lessonCode = lessonCode;
    }

    public Integer getLessonType() {
        return lessonType;
    }

    public void setLessonType(Integer lessonType) {
        this.lessonType = lessonType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSectionProgress() {
        return sectionProgress;
    }

    public void setSectionProgress(Integer sectionProgress) {
        this.sectionProgress = sectionProgress;
    }

    public Integer getSectionTotal() {
        return sectionTotal;
    }

    public void setSectionTotal(Integer sectionTotal) {
        this.sectionTotal = sectionTotal;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getUnlockFlag() {
        return unlockFlag;
    }

    public void setUnlockFlag(Integer unlockFlag) {
        this.unlockFlag = unlockFlag;
    }

    public Integer getBulletBox() {
        return bulletBox;
    }

    public void setBulletBox(Integer bulletBox) {
        this.bulletBox = bulletBox;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}