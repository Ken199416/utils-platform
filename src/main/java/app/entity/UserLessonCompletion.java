package app.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户的课程完成状态(UserLessonCompletion)实体类
 *
 * @author makejava
 * @since 2020-07-05 11:05:58
 */
public class UserLessonCompletion implements Serializable {
    private static final long serialVersionUID = -99465723156371660L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 用户id
    */
    private Integer passportId;
    /**
    * 学籍号
    */
    private String registrationId;
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
    * 状态，0完成,1未完成
    */
    private Object status;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;

    private Integer progress;

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

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

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
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

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
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