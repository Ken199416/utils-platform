package app.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单表(QwOrder)实体类
 *
 * @author makejava
 * @since 2020-07-07 11:45:58
 */
public class QwOrder implements Serializable {
    private static final long serialVersionUID = -55934043806661405L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 订单号
    */
    private String orderId;
    /**
    * 用户编码
    */
    private String riseId;
    /**
    * 用户Id
    */
    private Integer passportId;
    /**
    * 一级下单平台，0-H5，1-WECHAT(微信)，2-PC
    */
    private Integer platformType;
    /**
    * 订单状态,CREATED(0,已创建),WAIT_PAY(1,待支付),PAYED(2,已支付),CLOSE(3,已关闭),PART_REFUND(4,部分退款),FULL_REFUND(5,全部退款),WAIT_SEND(6,待发货),WAIT_CHECK(7,待签收),COMPLETED(8,已完成)
    */
    private Integer orderStatus;
    /**
    * 优惠金额
    */
    private Integer couponDiscount;
    /**
    * 活动优惠金额
    */
    private Integer activityDiscount;
    /**
    * 商品合计金额 = 所有商品销售金额之和
    */
    private Integer goodsPrice;
    /**
    * 兑换金额, 应付金额 - ( 积分 + 兑换金额 ) = 实付金额
    */
    private Integer exchangePrice;
    /**
    * 订单实付金额 = 订单应付金额 - 积分/储值等其他支付方式（本期暂无）+ 运费
    */
    private Integer realPrice;
    /**
    * 退款进度,0-无退款进度,1-退款待审批,2-退款中(审批通过),3-已退款,4-退款关闭
    */
    private Integer refundProcess;
    /**
    * 退款金额,已退真实金额
    */
    private Integer refundPrice;
    /**
    * 投放码
    */
    private String extensionCode;
    /**
    * 渠道码
    */
    private String channelCode;
    /**
    * 订单来源,冗余字段，就是渠道类型
    */
    private String channelType;
    /**
    * 渠道类型Id
    */
    private Integer channelTypeId;
    /**
    * 渠道分组
    */
    private String channelGroup;
    /**
    * 渠道分组Id
    */
    private Integer channelGroupId;
    /**
    * 交易单号
    */
    private String paymentOrderId;
    /**
    * 支付渠道返回的交易单号
    */
    private String transactionId;
    /**
    * 一级支付类型, DIRECT(0,直连),SHOUQIANBA(1,收钱吧),CHANMING(2,蝉鸣),QUANWAI(3,圈外),OFFLINE(4,线下),EXCHANGE(5,兑换)
    */
    private Integer paymentType;
    /**
    * 二级支付类型, WECHAT(0,微信), ALI(1,支付宝),BALANCE(2,余额),QUANWAI(3,圈外),YOUZAN(4,有赞),COUPON(5,优惠券全额抵扣)
    */
    private Integer paymentSubType;
    /**
    * 付款时间、兑换时间
    */
    private Date paidTime;
    /**
    * 订单支付状态,0-待付费，1-付费中,2-已付费，3-付费取消
    */
    private Integer paymentStatus;
    /**
    * 前端支付通知,0-无通知，1-前端支付成功，2-异常通知, 后端回调来也更新它
    */
    private Integer callbackStatus;
    /**
    * 支付回调金额，实际付款金额，渠道可能有自己的红包
    */
    private Integer callbackPrice;
    /**
    * 0 正常  1 删除
    */
    private Object status;
    /**
    * 添加时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 创建人
    */
    private String createdBy;
    /**
    * 更新人
    */
    private String modifiedBy;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRiseId() {
        return riseId;
    }

    public void setRiseId(String riseId) {
        this.riseId = riseId;
    }

    public Integer getPassportId() {
        return passportId;
    }

    public void setPassportId(Integer passportId) {
        this.passportId = passportId;
    }

    public Integer getPlatformType() {
        return platformType;
    }

    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(Integer couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public Integer getActivityDiscount() {
        return activityDiscount;
    }

    public void setActivityDiscount(Integer activityDiscount) {
        this.activityDiscount = activityDiscount;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getExchangePrice() {
        return exchangePrice;
    }

    public void setExchangePrice(Integer exchangePrice) {
        this.exchangePrice = exchangePrice;
    }

    public Integer getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Integer realPrice) {
        this.realPrice = realPrice;
    }

    public Integer getRefundProcess() {
        return refundProcess;
    }

    public void setRefundProcess(Integer refundProcess) {
        this.refundProcess = refundProcess;
    }

    public Integer getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(Integer refundPrice) {
        this.refundPrice = refundPrice;
    }

    public String getExtensionCode() {
        return extensionCode;
    }

    public void setExtensionCode(String extensionCode) {
        this.extensionCode = extensionCode;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public Integer getChannelTypeId() {
        return channelTypeId;
    }

    public void setChannelTypeId(Integer channelTypeId) {
        this.channelTypeId = channelTypeId;
    }

    public String getChannelGroup() {
        return channelGroup;
    }

    public void setChannelGroup(String channelGroup) {
        this.channelGroup = channelGroup;
    }

    public Integer getChannelGroupId() {
        return channelGroupId;
    }

    public void setChannelGroupId(Integer channelGroupId) {
        this.channelGroupId = channelGroupId;
    }

    public String getPaymentOrderId() {
        return paymentOrderId;
    }

    public void setPaymentOrderId(String paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getPaymentSubType() {
        return paymentSubType;
    }

    public void setPaymentSubType(Integer paymentSubType) {
        this.paymentSubType = paymentSubType;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getCallbackStatus() {
        return callbackStatus;
    }

    public void setCallbackStatus(Integer callbackStatus) {
        this.callbackStatus = callbackStatus;
    }

    public Integer getCallbackPrice() {
        return callbackPrice;
    }

    public void setCallbackPrice(Integer callbackPrice) {
        this.callbackPrice = callbackPrice;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

}