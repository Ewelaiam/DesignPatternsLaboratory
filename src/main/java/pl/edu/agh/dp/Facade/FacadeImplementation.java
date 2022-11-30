import java.io.IOException;
import java.net.UnknownHostException;

public class FacadeImplementation implements Facade {

    private NetworkManager networkManager = new NetworkManager();

    @Override
    public void joinToChat(String nickname, String portNumber){
        networkManager.joinToChat(nickname, portNumber);
    };

    @Override
    public void showAllConnectedNodes(){
        networkManager.showAllConnectedNodes();
    };

    @Override
    public void addPeerPort(String node) throws IOException{
        networkManager.addPeerPort(node);
    };

    @Override
    public void deletePeerPort(String node) throws IOException {
        networkManager.deletePeerPort(node);
    }

        @Override
    public void sendBroadcastMessageToAllConnected(String message){
        networkManager.sendBroadcastMessageToAllConnected(message);
    };
    @Override
    public void sendBroadcastMessage(String message){
        networkManager.sendBroadcastMessage(message);
    }


}
