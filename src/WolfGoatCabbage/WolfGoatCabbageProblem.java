//WolfGoatCabbageBidirectionalProblem.java

package WolfGoatCabbage;

import aima.core.search.framework.problem.DefaultGoalTest;
import aima.core.search.framework.problem.DefaultStepCostFunction;
import aima.core.search.framework.problem.Problem;

public class WolfGoatCabbageProblem extends Problem{
    
    private WolfGoatCabbageBoard goal;
    
    public WolfGoatCabbageProblem(WolfGoatCabbageBoard initialState, WolfGoatCabbageBoard goal) {
        //need to initialize the following fields:
        //goal, initial State, actionsFunction, resultFunction, goalTest and stepCostFunction
        this.initialState = initialState;
        actionsFunction = WolfGoatCabbageFunctionFactory.getActionsFunction();
        resultFunction = WolfGoatCabbageFunctionFactory.getResultFunction();
        goalTest = new DefaultGoalTest(goal);
        stepCostFunction = new DefaultStepCostFunction();
    }
}
