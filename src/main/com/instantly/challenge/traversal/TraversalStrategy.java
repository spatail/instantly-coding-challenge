package com.instantly.challenge.traversal;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Provides different traversal implementations, namely
 * depth-first search (DFS) and breadth-first seach (BFS).
 * Uses an ArrayDeque internally as the collection since it can
 * be used either as a Stack or a Queue. Additionally, ArrayDeque
 * allows both strategies to reuse the same iterative expansion.
 *
 * This class also handles circular symlinks by ignoring
 * followed links which have already been seen.
 *
 * @author saad.patail
 */
public abstract class TraversalStrategy {

    protected Deque<File> deque = new ArrayDeque<>();
    private Set<String> seen = new HashSet<>();

    public void execute(File root, FileVisitor visitor) {
        add(root);

        File curr = null;
        try {
            while (!deque.isEmpty()) {
                curr = get();

                visitor.visit(curr);

                if (seen.contains(curr.getCanonicalPath())) continue;
                seen.add(curr.getCanonicalPath());

                if (curr.isDirectory()) {
                    for (File child : curr.listFiles()) {
                        add(child);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to traverse file: " + curr);
            throw new RuntimeException(e);
        }
    }

    protected abstract File get();

    protected abstract void add(File f);

    /**
     * Uses Deque as a Stack
     */
    public static class DFS extends TraversalStrategy {

        @Override
        protected File get() {
            return deque.pop();
        }

        @Override
        protected void add(File f) {
            deque.push(f);
        }
    }

    /**
     * Used Deque as a Queue
     */
    public static class BFS extends TraversalStrategy {

        @Override
        protected File get() {
            return deque.poll();
        }

        @Override
        protected void add(File f) {
            deque.offer(f);
        }
    }
}
