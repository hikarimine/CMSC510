//WolfGoatCabbageDemo.java

package WolfGoatCabbage;

import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.GreedyBestFirstSearch;

import util.Printer;

public class WolfGoatCabbageDemo {

// Construct a board for the starting state
    static WolfGoatCabbageBoard board = new WolfGoatCabbageBoard(new int[]{0, 0, 0, 0});
// Construct board representing goal state
    static WolfGoatCabbageBoard goal = new WolfGoatCabbageBoard(new int[]{1, 1, 1, 1});
    
    public static void main(String[] args) throws Exception {
        Problem problem = new WolfGoatCabbageProblem(board, goal);
        Printer p = new Printer(problem, true);
        
        WolfGoatCabbageHeuristic hf = new WolfGoatCabbageHeuristic();
        //SearchForActions search = new AStarSearch(new GraphSearch(), hf);
        SearchForActions search = new GreedyBestFirstSearch(new GraphSearch(), hf);
        
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