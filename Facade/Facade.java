import java.io.IOException;
import java.net.UnknownHostException;

public interface Facade {
    public void joinToChat(String nickname, String portNumber);
    public void showAllConnectedNodes();
    public void addPeerPort(String node) throws IOException;
    public void deletePeerPort(String node) throws IOException;
    public void sendBroadcastMessageToAllConnected(String message);
    public void sendBroadcastMessage(String message);
}
