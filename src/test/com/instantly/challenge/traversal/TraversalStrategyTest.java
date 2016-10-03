package com.instantly.challenge.traversal;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 *
 * @author saad.patail
 */
public class TraversalStrategyTest {

    static String rootDir = "src/test/resources/root";

    @Test
    public void testDFS() {
        List<String> expected = Arrays.asList(
                "root",
                "folder3",
                "sub-folder3",
                "sub-sub-folder3",
                "file3",
                "folder2",
                "sub-folder2",
                "folder1",
                "file3",
                "file2",
                "file1"
        );

        List<String> result = runTest(new TraversalStrategy.DFS());

        assertThat(result, is(expected));
    }

    @Test
    public void testBFS() {
        List<String> expected = Arrays.asList(
                "root",
                "file1",
                "file2",
                "file3",
                "folder1",
                "folder2",
                "folder3",
                "sub-folder2",
                "sub-folder3",
                "sub-sub-folder3",
                "file3"
        );

        List<String> result = runTest(new TraversalStrategy.BFS());

        assertThat(result, is(expected));
    }

    public List<String> runTest(TraversalStrategy strategy) {
        final List<String> visitedFiles = new ArrayList<>();
        strategy.execute(new File(rootDir), new FileVisitor() {
            @Override
            public void visit(File f) {
                visitedFiles.add(f.getName());
            }
        });
        return visitedFiles;
    }
}
