//Printer.java
package util;

import aima.core.agent.Action;
import aima.core.search.framework.Node;
import aima.core.search.framework.NodeExpander.NodeListener;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.problem.ResultFunction;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * The printer class is a utility class that is used to print out lots of useful
 * information about a search that was run.
 *
 * @author Leo
 */
public class Printer implements NodeListener {

    private Problem problem;
    private boolean printExpandedNodes = true;
    private boolean printMetrics = true;
    private boolean printSolution = true;
    protected PrintStream ps;

    public Printer(Problem problem, boolean printExpandedNodes) {
        this.problem = problem;
        this.printExpandedNodes = printExpandedNodes;
        this.ps = System.out;
    }

    public Printer(PrintStream ps) {
        this.ps = ps;
    }

    //giving the Printer a printstream allows the search methods (currently just
    //in WolfGoatCabbage) to print to wherever, not just the console.
    public Printer(PrintStream ps, boolean printExpandedNodes, boolean printMetrics,
            boolean printSolution) {
        this.ps = ps;
        this.printExpandedNodes = printExpandedNodes;
        this.printMetrics = printMetrics;
        this.printSolution = printSolution;
    }

    public Printer(PrintStream ps, Problem problem, boolean printExpandedNodes) {
        this.problem = problem;
        this.printExpandedNodes = printExpandedNodes;
        this.ps = ps;
    }
    
    public void setProblem(Problem problem) {
        this.problem = problem;
    }
    
    public void setPrintExpandedNodes(boolean printExpandedNodes) {
        this.printExpandedNodes = printExpandedNodes;
    }
    
    public void setPrintMetrics(boolean printMetrics) {
        this.printMetrics = printMetrics;
    }
    
    public void setPrintSolution(boolean printSolution) {
        this.printSolution = printSolution;
    }
     
    /**
     * formats and prints properties, most commonly from search Metrics object
     * this format is intended to be readable from the console.
     *
     * @param properties
     */
    public void printInstrumentation(Properties properties) {
        if (printMetrics) {
            ps.println("\n");
            Iterator<Object> keys = properties.keySet().iterator();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                String property = properties.getProperty(key);
                ps.println(key + " : " + property);
            }
            ps.println();
        }
    }

    public void executeActions(List<Action> actions, Problem problem) {
        if (printSolution) {
            this.problem = problem;
            executeActions(actions);
        }
    }

    /**
     * given a problem and a list of actions, simulates those actions being
     * executed in order and prints each state
     *
     * @param actions
     */
    public void executeActions(List<Action> actions) {
        Object state = problem.getInitialState();
        ResultFunction resultFunction = problem.getResultFunction();

        //System.out.print(String.format("%23s   ", "GOAL STATE"));
        //System.out.println(goal + "\n");
        // Print each action and result on a separate line
        if (actions.isEmpty()) {
            ps.println(String.format("%23s   ", "START STATE"));
            ps.println(state);
            ps.println("NO SOLUTION FOUND");
        } else // Print the solution path
        {
            ps.println("SOLUTION PATH FOUND");

            // Reiterate the start state outside the loop
            ps.println(String.format("%23s   ", "START STATE") + state);
            for (Action action : actions) {
                ps.print(String.format("%23s   ", action.toString()));
                state = resultFunction.result(state, action);
                ps.println(state);
            }
        }
    }

    public void print(Object o) {
        ps.print(o);
    }

    /**
     * This method is called by the node expander each time it expands a node.
     * Here it's implemented to print the state of the node and how many
     * children the node has.
     *
     * @param node
     */
    //might need additional work to support bidirectional search
    @Override
    public void onNodeExpanded(Node node) {
        if (printExpandedNodes) {
            int children = problem.getActionsFunction().actions(node.getState()).size();
            ps.print("\nExpanding Node: " + node.getState() + "(kids: " + children + ")");
        }
    }
}
