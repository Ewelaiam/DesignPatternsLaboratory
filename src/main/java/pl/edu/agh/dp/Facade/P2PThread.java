import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class P2PThread extends Thread{
    private final PeerServerThread peerServerThread;
    private final Socket socket;
    private PrintWriter writer;

    public P2PThread(Socket socket, PeerServerThread peerServerThread) {
        this.peerServerThread = peerServerThread;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.writer = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                peerServerThread.sendMsg(reader.readLine());
            }
        } catch (IOException e) {
            peerServerThread.getP2PThreads().remove(this);
        }
    }

    public PrintWriter getWriter() {
        return writer;
    }

}
