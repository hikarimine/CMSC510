package util;

import aima.core.agent.Action;
import aima.core.search.framework.Metrics;
import aima.core.search.framework.Node;
import aima.core.search.framework.NodeExpander;
import aima.core.search.framework.QueueFactory;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.SearchUtils;
import aima.core.search.framework.problem.Problem;
import aima.core.util.CancelableThread;
import java.util.List;

/**
 * This class was made to replace the aima.core IterativeDeepeningSearch class,
 * which didn't have any way to keep track of queueSize of maxQueueSize.
 * @author Leo, based on IterativeDeepeningSearch.java by Ravi Mohan, Ciaran O'Reilly,
 * and Ruediger Lunde
 */
public class IterativeDeepeningSearchMod implements SearchForActions{
    private final NodeExpander nodeExpander;
    
    private DepthLimitedSearchMod dls;
    
    public IterativeDeepeningSearchMod() {
        this(new NodeExpander());
    }
    
    public IterativeDeepeningSearchMod(NodeExpander nodeExpander) {
        this.nodeExpander = nodeExpander;
    }
    
    @Override
    public List<Action> findActions(Problem p) {
        nodeExpander.useParentLinks(true);
        Node node = findNode(p);
        return node == null ? SearchUtils.failure() : SearchUtils.getSequenceOfActions(node);
    }
    
    public Node findNode(Problem p) {
        dls = new DepthLimitedSearchMod(0);
        while(!CancelableThread.currIsCanceled()) {
            Node result = dls.findNode(p, QueueFactory.<Node>createLifoQueue());
            if(result != null)
                return result;
            dls.incrementDepthLimit();
        }
        return null;
    }
    
    @Override public NodeExpander getNodeExpander() {
        return nodeExpander;
    }
    
    @Override
    public Metrics getMetrics() {
        return dls.getMetrics();
    }
}
