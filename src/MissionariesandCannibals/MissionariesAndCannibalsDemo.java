package MissionariesandCannibals;

import WolfGoatCabbage.WolfGoatCabbageHeuristic;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.evalfunc.HeuristicFunction;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.framework.qsearch.TreeSearch;
import aima.core.search.informed.GreedyBestFirstSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;

import util.Printer;
import util.DepthLimitedSearchMod;
import util.IterativeDeepeningSearchMod;

public class MissionariesAndCannibalsDemo {

// Construct a board for the starting state
    static MissionariesAndCannibalsBoard board = new MissionariesAndCannibalsBoard(new int[]{3, 3, 0, 0, 0});
// Construct board representing goal state
    static MissionariesAndCannibalsBoard goal = new MissionariesAndCannibalsBoard(new int[]{0, 0, 3, 3, 1});
    
    public static void main(String[] args) throws Exception {
        Problem problem = new MissionariesAndCannibalsProblem(board, goal);
        Printer p = new Printer(problem, true);
        
        MissionariesAndCannibalsHeuristic hf = new MissionariesAndCannibalsHeuristic();
        //SearchForActions search = new AStarSearch(new GraphSearch(), hf);
       // SearchForActions search = new AStarSearch(new TreeSearch(), hf);
        //SearchForActions search = new GreedyBestFirstSearch(new GraphSearch(), hf);
        SearchForActions search = new GreedyBestFirstSearch(new TreeSearch(), hf);
        
        //SearchForActions search = new BreadthFirstSearch(new GraphSearch());
        //SearchForActions search = new BreadthFirstSearch(new TreeSearch());
        //SearchForActions search = new DepthFirstSearch(new GraphSearch());
        //SearchForActions search = new DepthFirstSearch(new TreeSearch());
        //SearchForActions search = new DepthFirstSearch(new DepthLimitedSearchMod(20));
        //SearchForActions search = new IterativeDeepeningSearchMod();
        
        //necessary to print node expansions
        search.getNodeExpander().addNodeListener(p);
        
        //Search Agent runs search in its constructor
        //has public methods to access results
        SearchAgent agent = new SearchAgent(problem, search);
        
        //necessary to print nodes expanded, queue size, etc
        p.printInstrumentation(agent.getInstrumentation());
        
        //necessary to print the found solution
        p.executeActions(agent.getActions());
    }
}