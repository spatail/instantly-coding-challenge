package com.instantly.challenge.traversal;

import java.io.File;

public class TraversalDriver {

    public static void main(String[] args) {
	    if (args.length == 0 || args.length < 3) {
            System.out.println("Usage: <traversal-type (dfs|bfs)> <print-type (name|more) <path>");
        }

        String strategyType = args[0];
        String visitorType = args[1];
        String rootDir = args[2];

        File root = new File(rootDir);
        if (!root.exists()) {
            throw new RuntimeException("File not found: " + rootDir);
        }

        TraversalStrategy strategy = StrategyType.valueOf(strategyType.toUpperCase()).getStrategy();
        FileVisitor visitor = VisitorType.valueOf(visitorType.toUpperCase()).getVisitor();

        strategy.execute(root, visitor);
    }
}
