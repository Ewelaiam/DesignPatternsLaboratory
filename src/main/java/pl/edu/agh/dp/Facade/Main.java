import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Facade networkManagerFacade = new FacadeImplementation();
        boolean isEndOfChat = false;

        System.out.println("Welcome in peer2peer chat!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your nickname: ");
        String nickname = reader.readLine();
        System.out.println("Enter your listening port: ");
        String portNumber = reader.readLine();
        networkManagerFacade.joinToChat(nickname, portNumber);

        System.out.println("Choose one of the available option:\n 1 - broadcast msg to all connected nodes \n " +
                "2 - list all connected nodes \n 3 - msg to connected node about disconnection \n " +
                "4 - remove new node to contact \n 5 - add new node to contact");

        while (true) {
            System.out.println("Enter your option: ");
            String command = reader.readLine();
            switch (command) {
                case "1" -> {
                    System.out.println("Enter broadcast message to all connected: ");
                    String input = reader.readLine();
                    networkManagerFacade.sendBroadcastMessageToAllConnected(input);
                }
                case "2" -> networkManagerFacade.showAllConnectedNodes();
                case "3" -> {
                    isEndOfChat = true;
                    networkManagerFacade.sendBroadcastMessage("I gotta go - bye!");
                }
                case "4" -> {
                    System.out.println("Enter your peer listening port: ");
                    String input = reader.readLine();
                    networkManagerFacade.deletePeerPort(input);
                }
                case "5" -> {
                    System.out.println("Enter your peer listening port: ");
                    String input = reader.readLine();
                    networkManagerFacade.addPeerPort(input);
                }
                default -> System.out.println("There is no option like this! Please try again.");
            }

            if(isEndOfChat) break;

        }
        System.exit(0);
    }
}
