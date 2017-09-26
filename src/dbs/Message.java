package dbs;

/**
 * Created by HastuneMiku on 2017/8/17.
 */
public class Message {
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void println(){
        System.out.println("---");
        System.out.println("status:"+getStatus());
        System.out.println("msg:"+getMsg());
    }

    private String msg;
    private Boolean status;
}
