package MissionariesandCannibals;

import aima.core.search.framework.evalfunc.HeuristicFunction;

public class MissionariesAndCannibalsHeuristic implements HeuristicFunction {
    
    @Override
    public double h(Object state){
        MissionariesAndCannibalsBoard board = (MissionariesAndCannibalsBoard) state;
        int[] s = board.getState();
        //copmute how many Missionaries and Cannibals are on the wrong side of the river
        double retVal = s[0] + s[1];
        return retVal;
    }
}


//add another slot in the array, 1 or 0, put and if above to decide on which h function to use based on the extra space?
//another function that only cares about the Missionaires?
