package pl.edu.agh.dp.FSMStates;

import pl.edu.agh.dp.FiniteStateMachine;

public class NodeA implements FSMNodeState {

    private final FiniteStateMachine finiteStateMachine;

    public NodeA(FiniteStateMachine finiteStateMachine){
        this.finiteStateMachine = finiteStateMachine;
    }

    @Override
    public boolean canAcceptALetter(Character c) {
        switch (c){
            case 'a':
                finiteStateMachine.setFsmNodeState(finiteStateMachine.getNodeA());
                return true;
            case 'b':
                finiteStateMachine.setFsmNodeState(finiteStateMachine.getNodeB());
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
