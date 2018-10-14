package MissionariesandCannibals;

import aima.core.search.framework.problem.DefaultGoalTest;
import aima.core.search.framework.problem.DefaultStepCostFunction;
import aima.core.search.framework.problem.Problem;

public class MissionariesAndCannibalsProblem extends Problem{
    
    private MissionariesAndCannibalsBoard goal;
    
    public MissionariesAndCannibalsProblem(MissionariesAndCannibalsBoard initialState, MissionariesAndCannibalsBoard goal) {
        //need to initialize the following fields:
        //goal, initial State, actionsFunction, resultFunction, goalTest and stepCostFunction
        this.initialState = initialState;
        actionsFunction = MissionariesAndCannibalsFunctionFactory.getActionsFunction();
        resultFunction = MissionariesAndCannibalsFunctionFactory.getResultFunction();
        goalTest = new DefaultGoalTest(goal);
        stepCostFunction = new MissionariesAndCannibalsStepCostFunction();
    }
}
