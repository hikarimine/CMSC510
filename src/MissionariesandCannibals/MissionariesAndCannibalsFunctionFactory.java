// MissionariesAndCannibalsFunctionFactory.java

package MissionariesandCannibals;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.problem.ActionsFunction;
import aima.core.search.framework.problem.ResultFunction;

public class MissionariesAndCannibalsFunctionFactory {
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
         MissionariesAndCannibalsBoard board = (MissionariesAndCannibalsBoard) state;
        Set<Action> actions = new LinkedHashSet<Action>();
        if (board.isValidMove(MissionariesAndCannibalsBoard.cBoard)){
            actions.add(MissionariesAndCannibalsBoard.cBoard);
        }
        if (board.isValidMove(MissionariesAndCannibalsBoard.cDebark)){
            actions.add(MissionariesAndCannibalsBoard.cDebark);
        }
        if (board.isValidMove(MissionariesAndCannibalsBoard.mBoard)){
            actions.add(MissionariesAndCannibalsBoard.mBoard);
        }
        if (board.isValidMove(MissionariesAndCannibalsBoard.mDebark)){
            actions.add(MissionariesAndCannibalsBoard.mDebark);
        }
        if(board.isValidMove(MissionariesAndCannibalsBoard.moveB)){
            actions.add(MissionariesAndCannibalsBoard.moveB);
        }
        return actions;
        //finish writing this method
    }
}

// Return a single result based on which action a is applied to the state s.
private static class WolfGoatCaggabeResultFunction implements ResultFunction {
    
    @Override
    public Object result(Object s, Action a) {
        MissionariesAndCannibalsBoard board = (MissionariesAndCannibalsBoard) s;
        MissionariesAndCannibalsBoard newBoard = new MissionariesAndCannibalsBoard(board);
        if (MissionariesAndCannibalsBoard.cBoard.equals(a)){
            newBoard.cBoard();
            return newBoard;
        }else if (MissionariesAndCannibalsBoard.cDebark.equals(a)){
            newBoard.cDebark();
            return newBoard;
        }else if (MissionariesAndCannibalsBoard.mBoard.equals(a)){
            newBoard.mBoard();
            return newBoard;
        }else if (MissionariesAndCannibalsBoard.mDebark.equals(a)){
            newBoard.mDebark();
            return newBoard;
        }else if(MissionariesAndCannibalsBoard.moveB.equals(a)){
            newBoard.moveB();
            return newBoard;
        }
        return s; //return current state if unkown action or No Op.
    }
}
}