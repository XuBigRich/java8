package meijv;

    public enum Zhi {
        NOT_EXISTS("NULL", "商家授权信息不存在"),
        SYS_ERROR("E04", "系统异常"),
        REGISTER_ERROR("E05", "注册失败"),
        REGISTER_EXCEPTION("E01", "系统异常，可重试"),
        SUCCESS("SUC", "成功"),
        ;
        private String code;
        private String msg;
        Zhi(String code, String msg) {

            this.code = code;
            this.msg = msg;
        }
        @Override
        public String toString() {
            return super.toString();
        }
    }
