import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NetworkManager {
    private String nickname;
    private String portNumber;
    private PeerServerThread server;
    private Set<String> namesOfPeers;
    private Thread[] threads;

    private ArrayList<PeerClientThread> peerClientThreads;
    private ArrayList<P2PThread> p2pThreads;
    private ArrayList<PeerServerThread> peerServerThreads;

    private void actualizeThreadsArray(){
        threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
    }
    private void getAllCurrentPeers(){
        actualizeThreadsArray();
        namesOfPeers = new HashSet<>();

        for (Thread thread : threads) {
            if (thread instanceof PeerClientThread) {
                namesOfPeers.add(((PeerClientThread)thread).getLocalPortString());
            }
            else if  (thread instanceof PeerServerThread) {
                namesOfPeers.add(((PeerServerThread)thread).getPortString());
            }
        }
    }

    private boolean isNodeExists(String nodeName) {
        return namesOfPeers.contains(nodeName);
    }

    private void groupThreads() {
        actualizeThreadsArray();
        peerClientThreads = new ArrayList<>();
        p2pThreads = new ArrayList<>();
        peerServerThreads = new ArrayList<>();

        for (Thread thread : threads) {
            if (thread instanceof PeerClientThread) peerClientThreads.add((PeerClientThread) thread);
            else if (thread instanceof P2PThread) p2pThreads.add((P2PThread) thread);
            else if (thread instanceof PeerServerThread) peerServerThreads.add((PeerServerThread) thread);

        }
    }

    public void joinToChat(String nickname, String portNumber) {
        try {
            this.nickname = nickname;
            this.portNumber = portNumber;
            server = new PeerServerThread(portNumber);
            getAllCurrentPeers();
            sendBroadcastMessage("Hi I'm new here - my name is " + nickname + " and I run on port " + portNumber);

        } catch (IOException e) {
            System.out.println("Cannot join to chat");
        }
        server.start();
    }

    public void showAllConnectedNodes(){
        groupThreads();

        System.out.println("You're connected with nodes: \n");

        for (PeerClientThread peerClientThread : peerClientThreads){
            System.out.println("PeerClientThread:\t " + peerClientThread + "\n");
        }
        for (P2PThread p2pThread : p2pThreads){
            System.out.println("P2PThread:\t " + p2pThread + "\n");

        }
        for (PeerServerThread serverThread : peerServerThreads){
            System.out.println("PeerServerThread:\t " + serverThread + "\n");
        }
    }

    public void addPeerPort(String node) throws IOException {
        Socket socket = null;
        try {
            if (!isNodeExists(node)) {
                socket = new Socket(InetAddress.getByName("localhost"), Integer.parseInt(node));
                PeerClientThread peerClientThread = new PeerClientThread(socket);
                peerClientThread.start();
            }
        } catch (Exception e) {
            if (socket != null) socket.close();
            else System.out.println("Provided node port number does not exist");
        }
    }

    public void deletePeerPort(String node) throws IOException {
        Socket socket = null;
        if (isNodeExists(node)){
            socket = new Socket(InetAddress.getByName("localhost"), Integer.parseInt(node));
            PeerClientThread peerClientThreadToRemove = new PeerClientThread(socket);

            for (PeerClientThread peerClientThread : peerClientThreads){
                if (peerClientThreadToRemove.equals(peerClientThread)){
                    peerClientThreads.remove(peerClientThread);
                }
            }
        }
    }

    public void sendBroadcastMessageToAllConnected(String message){
        server.sendMsg("Message from " + nickname + ": " + message);
    }

    public void sendBroadcastMessage(String message){
        groupThreads();

        for (PeerServerThread peerServerThread : peerServerThreads){
            peerServerThread.sendMsg(message);
        }
    }

}
