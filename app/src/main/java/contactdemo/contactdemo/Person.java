package contactdemo.contactdemo;

/**
 * Created by ChenJiangFeng on 2017/1/5.
 */

public class Person {
    private String name;
    private  String pinyin;
    public Person(String name){
        this.name = name;
        this.pinyin = PinYinUtils.getPinYin(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                '}';
    }
}
