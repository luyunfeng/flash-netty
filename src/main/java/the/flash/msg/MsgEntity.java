package the.flash.msg;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author yunfeng.lu
 * @date 2018/10/10
 */
public class MsgEntity implements Serializable{

    private String msgId;

    private Date date;

    private String content;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MsgEntity{" +
            "msgId='" + msgId + '\'' +
            ", date=" + date +
            ", content='" + content + '\'' +
            '}';
    }
}
