package app.entity;

import lombok.Data;

@Data
public class ResponseBean {
    private int code;
    private String msg;
    private Object data;

    public ResponseBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
