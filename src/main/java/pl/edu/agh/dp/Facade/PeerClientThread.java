import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class PeerClientThread extends Thread {
    private final BufferedReader bufferedReader;
    private final int port;
    private final int localPort;
    private final String hostAddress;

    public PeerClientThread(Socket socket) throws IOException {
        this.localPort = socket.getLocalPort();
        this.port = socket.getPort();
        this.hostAddress = socket.getInetAddress().getHostName();
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public int getPort() {
        return port;
    }

    public String getHostAddress() {
        return hostAddress;
    }
    public String getLocalPortString(){ return "" + localPort; }

    @Override
    public void run() {
        while (true) {
            try {
                String message = this.bufferedReader.readLine();
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
                interrupt();
                break;
            }
        }
    }

}
