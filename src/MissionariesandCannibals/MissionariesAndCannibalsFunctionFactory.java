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
        
        //finish writing this method
    }
}

// Return a single result based on which action a is applied to the state s.
private static class WolfGoatCaggabeResultFunction implements ResultFunction {
    
    @Override
    public Object result(Object s, Action a) {
        
        //finish writing this method
    }
}
}