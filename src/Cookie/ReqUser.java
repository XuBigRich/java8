package Cookie;

public class ReqUser {
    private String username;
    private String password;

    public ReqUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * json
     *
     * @return
     */
//    @Override
//    public String toString() {
//        return "{" +
//                "\"username\":\"" + username + '\"' +
//                ", \"password\":\"" + password + '\"' +
//                '}';
//    }

    /**
     * x-www-form-urlencoded
     *
     * @return
     */
    @Override
    public String toString() {
        return "username=" + username + "&password=" + password;
    }
}
