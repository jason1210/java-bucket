package cn.blingfeng.websocket.pojo;

import java.util.Date;

public class Client2ServerMessage {
    private String message;

    private Date sendDate;

    private Integer type;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
