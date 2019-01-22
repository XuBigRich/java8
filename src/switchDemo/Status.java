package switchDemo;

public enum Status {
    PROCESSING("aaa","bbb"),
    OPEN("aa","bb"),
    CLOSE("a","b");
    private String key;
    private String value;
    private Status(String key,String value){
        this.key=key;
        this.value=value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
