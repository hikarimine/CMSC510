package MissionariesandCannibals;

import aima.core.agent.Action;
import aima.core.search.framework.problem.StepCostFunction;

public class MissionariesAndCannibalsStepCostFunction implements StepCostFunction {

    public double c(Object stateFrom, Action action, Object stateTo) {
        if (MissionariesAndCannibalsBoard.moveM.equals(action) || MissionariesAndCannibalsBoard.moveC.equals(action)){
            return 1;
        }else{
            return 2;
        }
    }
}