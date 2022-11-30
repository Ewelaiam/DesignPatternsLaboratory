import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

public class PeerServerThread extends Thread{
    private final String port;
    private final ServerSocket serverSocket;
    private Set<P2PThread> p2pThreads;

    public PeerServerThread(String port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(Integer.parseInt(port));
        p2pThreads = new HashSet<>();
    }

    public void sendMsg(String message) {
        try {
            for (P2PThread p2PThread : p2pThreads){
                p2PThread.getWriter().println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Set<P2PThread> getP2PThreads() {
        return p2pThreads;
    }

    public String getPortString(){ return "" + port;}

    @Override
    public void run() {
        try {
            while (true) {
                P2PThread p2pThread = new P2PThread(serverSocket.accept(), this);
                p2pThreads.add(p2pThread);
                p2pThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            for (P2PThread p2pThread : p2pThreads){
                (new Thread(p2pThread)).stop();
            }
        }
    }


}
