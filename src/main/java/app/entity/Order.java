package app.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单表 (Order)实体类
 *
 * @author makejava
 * @since 2020-07-04 14:40:11
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 176742691222315167L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 订单号
    */
    private String orderId;
    /**
    * 订单类型，0-普通订单，1-外部订单，2-兑换订单，3-分销订单
    */
    private Object orderType;
    /**
    * 平台类型，0-平台类型，WEB(WEB），1-WECHAT(微信公号)，2-YOUZAN(有赞)
    */
    private Object platformType;
    /**
    * 客户端类型,0-H5(WEBH5),1-YZ_EXCHANGE(有赞兑换码)
    */
    private Object platformSubType;
    /**
    * 用户Id
    */
    private Integer passportId;
    /**
    * 用户编码
    */
    private String riseId;
    /**
    * 订单状态,CREATED(0,已创建),WAIT_PAY(1,待支付),PAYED(2,已支付),CLOSE(3,已关闭),PART_REFUND(4,部分退款),FULL_REFUND(5,全部退款),WAIT_SEND(6,待发货),WAIT_CHECK(7,待签收),COMPLETED(8,已完成)
    */
    private Object orderStatus;
    /**
    * 退款进度,0-无退款进度,1-退款待审批,2-退款中(审批通过),3-已退款,4-退款关闭
    */
    private Object refundProcess;
    /**
    * 订单的退款状态，订单所有金额都退完后算全部退款,0-无退款，1-部分退款，2-全部退款
    */
    private Object refundStatus;
    /**
    * 退款金额
    */
    private Integer refundPrice;
    /**
    * 商品合计金额 = 所有商品销售金额之和
    */
    private Integer orderGoodsPrice;
    /**
    * 优惠价格,优惠合计金额，单位分
    */
    private Integer orderDiscount;
    /**
    * 订单应付金额 = 商品合计金额 - 优惠合计金额 + 运费
    */
    private Integer orderShouldPrice;
    /**
    * 兑换金额, 应付金额 - ( 积分 + 兑换金额 ) = 实付金额
    */
    private Integer exchangePrice;
    /**
    * 订单实付金额 = 订单应付金额 - 积分/储值等其他支付方式（本期暂无）
    */
    private Integer orderRealPrice;
    /**
    * 【渠道信息】渠道码
    */
    private String channelCode;
    /**
    * 推广码
    */
    private String extensionCode;
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
    * 渠道名称
    */
    private String channelName;
    /**
    * 交易单号
    */
    private String paymentOrderId;
    /**
    * 支付配置id
    */
    private Integer paymentConfigId;
    /**
    * 支付渠道编码
    */
    private String paymentCode;
    /**
    * 支付类型, 0-付款渠道付款，1-贡献值，2-兑换码,3-组合支付
    */
    private Object paymentType;
    /**
    * 付款时间、兑换时间
    */
    private Date paidTime;
    /**
    * 订单支付状态,0-待付费，1-已付费，2-付费取消, 更具体的支付信息在支付详情表
    */
    private Object paymentStatus;
    /**
    * 前端支付通知,0-无通知，1-前端支付成功，2-异常通知
    */
    private Object frontPayReturn;
    /**
    * 昵称
    */
    private String nickname;
    /**
    * 真实姓名
    */
    private String realName;
    /**
    * 手机号
    */
    private String mobile;
    /**
    * 收件地址，省市区拼接详细地址, 具体的收货地址见order_shipping表
    */
    private String receiverAddress;
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

    public Object getOrderType() {
        return orderType;
    }

    public void setOrderType(Object orderType) {
        this.orderType = orderType;
    }

    public Object getPlatformType() {
        return platformType;
    }

    public void setPlatformType(Object platformType) {
        this.platformType = platformType;
    }

    public Object getPlatformSubType() {
        return platformSubType;
    }

    public void setPlatformSubType(Object platformSubType) {
        this.platformSubType = platformSubType;
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

    public Object getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Object orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Object getRefundProcess() {
        return refundProcess;
    }

    public void setRefundProcess(Object refundProcess) {
        this.refundProcess = refundProcess;
    }

    public Object getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Object refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(Integer refundPrice) {
        this.refundPrice = refundPrice;
    }

    public Integer getOrderGoodsPrice() {
        return orderGoodsPrice;
    }

    public void setOrderGoodsPrice(Integer orderGoodsPrice) {
        this.orderGoodsPrice = orderGoodsPrice;
    }

    public Integer getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(Integer orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public Integer getOrderShouldPrice() {
        return orderShouldPrice;
    }

    public void setOrderShouldPrice(Integer orderShouldPrice) {
        this.orderShouldPrice = orderShouldPrice;
    }

    public Integer getExchangePrice() {
        return exchangePrice;
    }

    public void setExchangePrice(Integer exchangePrice) {
        this.exchangePrice = exchangePrice;
    }

    public Integer getOrderRealPrice() {
        return orderRealPrice;
    }

    public void setOrderRealPrice(Integer orderRealPrice) {
        this.orderRealPrice = orderRealPrice;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getExtensionCode() {
        return extensionCode;
    }

    public void setExtensionCode(String extensionCode) {
        this.extensionCode = extensionCode;
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

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getPaymentOrderId() {
        return paymentOrderId;
    }

    public void setPaymentOrderId(String paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }

    public Integer getPaymentConfigId() {
        return paymentConfigId;
    }

    public void setPaymentConfigId(Integer paymentConfigId) {
        this.paymentConfigId = paymentConfigId;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public Object getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Object paymentType) {
        this.paymentType = paymentType;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Object getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Object paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Object getFrontPayReturn() {
        return frontPayReturn;
    }

    public void setFrontPayReturn(Object frontPayReturn) {
        this.frontPayReturn = frontPayReturn;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
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