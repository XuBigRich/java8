package socket.basics.server;

public class ServerBoot {
    private static final int PORT=8080;
    public static void main(String[] args) {
    		Server server=new Server(PORT);
    		server.start();
    }
}
