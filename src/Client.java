import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private PrintWriter writer = null;
    private Socket socket = null;
    private String host = "localhost";
    private int port = 8087;
    private Scanner scanner = new Scanner(System.in);

    private void connect() throws Exception{
        System.out.println("开始创建连接，等待respond");
        socket = new Socket(host,port);
        System.out.println("套接字创建成功");
        int a = 1;
        if(socket != null){
            System.out.println("开始创建输入流");
            writer = new PrintWriter(socket.getOutputStream(),true);
            System.out.println("输入流创建成功");
            while (true){
                System.out.println("输入信息：");
//                System.out.println(socket.getInetAddress());
//                System.out.println(socket.getLocalPort());
//                System.out.println(socket.getPort());
//                System.out.println(socket.getLocalSocketAddress());
                writer.println(scanner.nextLine());
//                writer.flush();
            }

        }
    }

    public static void main(String[] args) throws Exception{
        Client client = new Client();
        client.connect();
    }
}
