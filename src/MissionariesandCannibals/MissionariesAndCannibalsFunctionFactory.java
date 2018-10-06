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
        _actionsFunction = new MissionariesAndCannibalsActionsFunction();
    }
    return _actionsFunction;
}

public static ResultFunction getResultFunction() {
    if (null == _resultFunction) {
        _resultFunction = new MissionariesAndCannibalsResultFunction();
    }
    return _resultFunction;
}
// This is called every time a node is expanded to get the relevant actions.
private static class MissionariesAndCannibalsActionsFunction implements ActionsFunction {
    
    @Override
    public Set<Action> actions(Object state) {
        MissionariesAndCannibalsBoard board = (MissionariesAndCannibalsBoard) state;
        Set<Action> actions = new LinkedHashSet<Action>();
        if (board.isValidMove(MissionariesAndCannibalsBoard.moveMM)){
            actions.add(MissionariesAndCannibalsBoard.moveMM);
        }
        if (board.isValidMove(MissionariesAndCannibalsBoard.moveCC)){
            actions.add(MissionariesAndCannibalsBoard.moveCC);
        }
        if (board.isValidMove(MissionariesAndCannibalsBoard.moveM)){
            actions.add(MissionariesAndCannibalsBoard.moveM);
        }
        if (board.isValidMove(MissionariesAndCannibalsBoard.moveC)){
            actions.add(MissionariesAndCannibalsBoard.moveC);
        }
        if (board.isValidMove(MissionariesAndCannibalsBoard.moveMC)){
            actions.add(MissionariesAndCannibalsBoard.moveMC);
        }
        return actions;
    }
}

// Return a single result based on which action a is applied to the state s.
private static class MissionariesAndCannibalsResultFunction implements ResultFunction {
    
    @Override
    public Object result(Object s, Action a) {
        MissionariesAndCannibalsBoard board = (MissionariesAndCannibalsBoard) s;
        MissionariesAndCannibalsBoard newBoard = new MissionariesAndCannibalsBoard(board);
        if (MissionariesAndCannibalsBoard.moveM.equals(a)){
            newBoard.moveM();
            return newBoard;
        }else if (MissionariesAndCannibalsBoard.moveC.equals(a)){
            newBoard.moveC();
            return newBoard;
        }else if (MissionariesAndCannibalsBoard.moveMM.equals(a)){
            newBoard.moveMM();
            return newBoard;
        }else if (MissionariesAndCannibalsBoard.moveCC.equals(a)){
            newBoard.moveCC();
            return newBoard;
        }else if (MissionariesAndCannibalsBoard.moveMC.equals(a)){
            newBoard.moveMC();
            return newBoard;
        }
        return s; //return current state if unkown action or No Op.
    }
}
}
