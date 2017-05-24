package contactdemo.contactdemo;

/**
 * Created by XUERU on 2017/5/24.
 */

public class CuntryBean {


    /**
     * cc : AF
     * en : Afghanistan
     * cn : 阿富汗
     * no : 93
     */

    private String cc;
    private String en;
    private String cn;
    private String no;

    public CuntryBean(String cn) {
        this.cn = cn;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
