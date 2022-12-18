package pl.edu.agh.dp.FSMStates;

public interface FSMNodeState {
    boolean canAcceptALetter(Character c);
    boolean hasEpsilon();
}
