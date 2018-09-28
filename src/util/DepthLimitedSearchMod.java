package util;

import aima.core.search.framework.Node;
import aima.core.search.framework.NodeExpander;
import aima.core.search.framework.SearchUtils;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.QueueSearch;
import aima.core.util.CancelableThread;
import java.util.Queue;

/**
 * This class was made to replace the aima.core DepthLimitedSearch class, which
 * didn't have any way to keep track of queueSize or maxQueueSize.
 *
 * @author Leo
 */
public class DepthLimitedSearchMod extends QueueSearch {

    private int depthLimit;

    public DepthLimitedSearchMod(int depthLimit) {
        this(new NodeExpander(), depthLimit);
    }

    public DepthLimitedSearchMod(NodeExpander nodeExpander, int depthLimit) {
        super(nodeExpander);
        this.depthLimit = depthLimit;
        earlyGoalTest = true;
        clearInstrumentation();
    }

    public void incrementDepthLimit() {
        depthLimit++;
    }

    @Override
    public Node findNode(Problem problem, Queue<Node> frontier) {
        this.frontier = frontier;
        // initialize the frontier using the initial state of the problem
        Node root = nodeExpander.createRootNode(problem.getInitialState());
        addToFrontier(root);
        if (earlyGoalTest && SearchUtils.isGoalState(problem, root)) {
            return getSolution(root);
        }

        while (!isFrontierEmpty() && !CancelableThread.currIsCanceled()) {
            // choose a leaf node and remove it from the frontier
            Node nodeToExpand = removeFromFrontier();
            // Only need to check the nodeToExpand if have not already
            // checked before adding to the frontier
            if (!earlyGoalTest && SearchUtils.isGoalState(problem, nodeToExpand)) // if the node contains a goal state then return the
            // corresponding solution
            {
                return getSolution(nodeToExpand);
            }

            // only expand if the depthLimit hasn't been reached
            if (nodeToExpand.getPathFromRoot().size() <= depthLimit) {
                for (Node successor : nodeExpander.expand(nodeToExpand, problem)) {
                    addToFrontier(successor);
                    if (earlyGoalTest && SearchUtils.isGoalState(problem, successor)) {
                        return getSolution(successor);
                    }
                }
            }
        }
        // if the frontier is empty then return failure
        return null;
    }

    @Override
    protected void addToFrontier(Node node) {
        frontier.add(node);
        updateMetrics(frontier.size());
    }

    @Override
    protected Node removeFromFrontier() {
        Node result = frontier.remove();
        updateMetrics(frontier.size());
        return result;
    }

    @Override
    protected boolean isFrontierEmpty() {
        return frontier.isEmpty();
    }

    private Node getSolution(Node node) {
        metrics.set(METRIC_PATH_COST, node.getPathCost());
        return node;
    }
}
