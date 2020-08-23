package app.entity;

public enum OrderStatusEnum {
    CREATED(0,"已创建"),
    WAIT_PAY(1,"待支付"),
    PAYED(2,"已支付"),
    CLOSE(3,"已关闭"),
    PART_REFUND(4,"部分退款"),
    FULL_REFUND(5,"全部退款"),
    WAIT_SEND(6,"待发货"),
    WAIT_CHECK(7,"待签收"),
    COMPLETED(8,"已完成");
    private String orderStatusDesc;
    private int orderStatus;

    private OrderStatusEnum(int orderStatus,String orderStatusDesc){
        this.orderStatus = orderStatus;
        this.orderStatusDesc = orderStatusDesc;
    }


    public static String getOrderStatusDesc(int orderStatus){
//        获取全部的枚举
        OrderStatusEnum [] orderStatusEnums = values();
        for (OrderStatusEnum orderstatusEnum : orderStatusEnums) {
            if (orderstatusEnum.orderStatus == orderStatus){
                return orderstatusEnum.orderStatusDesc;
            }
        }
        return "未知状态";
    }

}
