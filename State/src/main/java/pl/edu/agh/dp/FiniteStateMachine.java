package pl.edu.agh.dp;

import pl.edu.agh.dp.FSMStates.*;

public class FiniteStateMachine {

    private FSMNodeState fsmNodeState;
    private final NodeStart nodeStart;
    private final NodeA nodeA;
    private final NodeB nodeB;
    private final NodeC nodeC;

    public FiniteStateMachine(){
        nodeStart = new NodeStart(this);
        nodeA = new NodeA(this);
        nodeB = new NodeB(this);
        nodeC = new NodeC(this);

        fsmNodeState = nodeStart;
    }

    public boolean isWordAccepted(String word){
        for (int i = 0; i < word.length(); i++){
            if(fsmNodeState == null || !fsmNodeState.canAcceptALetter(word.charAt(i))){
                return false;
            }
        }
        return fsmNodeState == null || fsmNodeState.hasEpsilon();
    }

    public void setFsmNodeState(FSMNodeState fsmNodeState) {
        this.fsmNodeState = fsmNodeState;
    }

    public NodeStart getNodeStart() {
        return nodeStart;
    }

    public NodeA getNodeA() {
        return nodeA;
    }

    public NodeB getNodeB() {
        return nodeB;
    }

    public NodeC getNodeC() {
        return nodeC;
    }
}
