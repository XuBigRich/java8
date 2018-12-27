//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package meijv;
/*
* java1.5更新的 枚举类
* 这种 枚举类 常用于 很多属性  像  下面例子一样 有很多个属性
* 而 只有一个 属性的话 值需声明一个static final 来 表示 单个属性的枚举 就可以了
* */
public enum Meij {
    NOT_EXISTS("NULL", "商家授权信息不存在"),
    SYS_ERROR("E04", "系统异常"),
    REGISTER_ERROR("E05", "注册失败"),
    REGISTER_EXCEPTION("E01", "系统异常，可重试"),
    SUCCESS("SUC", "成功");

    private String code;
    private String msg;

    private Meij(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
