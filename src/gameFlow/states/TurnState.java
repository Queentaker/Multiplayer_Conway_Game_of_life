package gameFlow.states;

import exception.IllegalUserInputException;

public interface TurnState {

    void next() throws IllegalUserInputException;
}
