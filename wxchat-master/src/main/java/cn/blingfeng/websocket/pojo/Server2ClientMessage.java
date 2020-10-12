package cn.blingfeng.websocket.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Server2ClientMessage {
    private static  SimpleDateFormat time=new SimpleDateFormat("HH:mm:ss");
    public Server2ClientMessage(String message,Date date,Integer type){
        this.message = message;
        this.date = date;
        this.type = type;
    }
   private String message;

   private Date date;

   private Integer type;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return time.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}