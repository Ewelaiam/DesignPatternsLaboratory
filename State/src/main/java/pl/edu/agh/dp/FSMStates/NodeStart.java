package pl.edu.agh.dp.FSMStates;

import pl.edu.agh.dp.FiniteStateMachine;

public class NodeStart implements FSMNodeState {

    private final FiniteStateMachine finiteStateMachine;

    public NodeStart(FiniteStateMachine finiteStateMachine){
        this.finiteStateMachine = finiteStateMachine;
    }

    @Override
    public boolean canAcceptALetter(Character c) {
        switch (c){
            case 'a':
                finiteStateMachine.setFsmNodeState(finiteStateMachine.getNodeA());
                return true;
            case 'b':
                finiteStateMachine.setFsmNodeState(finiteStateMachine.getNodeC());
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean hasEpsilon() {
        return false;
    }
}
