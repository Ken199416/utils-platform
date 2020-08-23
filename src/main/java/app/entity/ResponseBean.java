package app.entity;

import lombok.Data;

@Data
public class ResponseBean {
    private int code;
    private String msg;
    private Object data;
    private Object extend;

    public ResponseBean(int code, String msg, Object data ,Object extend) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.extend = extend;
    }

    public ResponseBean(int code, String msg, Object data ) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseBean(int code, String msg ) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseBean(){

    }
}
