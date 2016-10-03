package com.instantly.challenge.traversal;

/**
 * @author saad.patail
 */
public enum StrategyType {
    DFS(new TraversalStrategy.DFS()),
    BFS(new TraversalStrategy.BFS());

    private final TraversalStrategy strategy;

    private StrategyType(TraversalStrategy strategy) {
        this.strategy = strategy;
    }

    public TraversalStrategy getStrategy() {
        return strategy;
    }
}
