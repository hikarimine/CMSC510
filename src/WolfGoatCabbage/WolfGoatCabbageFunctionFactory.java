// WolfGoatCabbageFunctionFactory.java

package WolfGoatCabbage;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.problem.ActionsFunction;
import aima.core.search.framework.problem.ResultFunction;

public class WolfGoatCabbageFunctionFactory {
private static ActionsFunction _actionsFunction = null;
private static ResultFunction _resultFunction = null;


public static ActionsFunction getActionsFunction() {
    if (null == _actionsFunction) {
        _actionsFunction = new WolfGoatCaggabeActionsFunction();
    }
    return _actionsFunction;
}

public static ResultFunction getResultFunction() {
    if (null == _resultFunction) {
        _resultFunction = new WolfGoatCaggabeResultFunction();
    }
    return _resultFunction;
}
// This is called every time a node is expanded to get the relevant actions.
private static class WolfGoatCaggabeActionsFunction implements ActionsFunction {
    
    @Override
    public Set<Action> actions(Object state) {
        WolfGoatCabbageBoard board = (WolfGoatCabbageBoard) state;
        Set<Action> actions = new LinkedHashSet<Action>();
        if (board.isValidMove(WolfGoatCabbageBoard.moveW)){
            actions.add(WolfGoatCabbageBoard.moveW);
        }
        if (board.isValidMove(WolfGoatCabbageBoard.moveG)){
            actions.add(WolfGoatCabbageBoard.moveG);
        }
        if (board.isValidMove(WolfGoatCabbageBoard.moveC)){
            actions.add(WolfGoatCabbageBoard.moveC);
        }
        if (board.isValidMove(WolfGoatCabbageBoard.moveB)){
            actions.add(WolfGoatCabbageBoard.moveB);
        }
        return actions;
        //finish writing this method
    }
}

// Return a single result based on which action a is applied to the state s.
private static class WolfGoatCaggabeResultFunction implements ResultFunction {
    
    @Override
    public Object result(Object s, Action a) {
        WolfGoatCabbageBoard board = (WolfGoatCabbageBoard) s;
        WolfGoatCabbageBoard newBoard = new WolfGoatCabbageBoard(board);
        if (WolfGoatCabbageBoard.moveW.equals(a)){
            newBoard.moveW();
            return newBoard;
        }else if (WolfGoatCabbageBoard.moveG.equals(a)){
            newBoard.moveG();
            return newBoard;
        }else if (WolfGoatCabbageBoard.moveC.equals(a)){
            newBoard.moveC();
            return newBoard;
        }else if (WolfGoatCabbageBoard.moveB.equals(a)){
            newBoard.moveB();
            return newBoard;
        }
        return s; //return current state if unkown action or No Op.
        //finish writing this method
    }
}
}