package pl.edu.agh.dp.FSMStates;

import pl.edu.agh.dp.FiniteStateMachine;

public class NodeB implements FSMNodeState {

    private final FiniteStateMachine finiteStateMachine;

    public NodeB(FiniteStateMachine finiteStateMachine){
        this.finiteStateMachine = finiteStateMachine;
    }

    @Override
    public boolean canAcceptALetter(Character c) {
        switch (c){
            case 'b':
                finiteStateMachine.setFsmNodeState(finiteStateMachine.getNodeB());
                return true;
            case 'a':
                finiteStateMachine.setFsmNodeState(null);
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean hasEpsilon() {
        return true;
    }
}
