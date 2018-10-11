package WolfGoatCabbage;

import aima.core.search.framework.evalfunc.HeuristicFunction;

public class WolfGoatCabbageHeuristic implements HeuristicFunction {

    @Override
    public double h(Object state) {
        WolfGoatCabbageBoard board = (WolfGoatCabbageBoard) state;
        int[] s = board.getState();
        //compute how many of Wolf, Goat, Cabbage on wrong side of river
        double retVal = 3 - s[0] - s[1] - s[2];         
        return retVal;
    }
}