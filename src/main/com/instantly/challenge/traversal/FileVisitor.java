package com.instantly.challenge.traversal;

import java.io.File;
import java.util.Date;

/**
 * @author saad.patail
 */
public interface FileVisitor {

    public void visit(File f);

    public static class PrintName implements FileVisitor {

        @Override
        public void visit(File f) {
            System.out.println(f.getName());
        }
    }

    public static class PrintNameAndMore implements FileVisitor {

        @Override
        public void visit(File f) {
            System.out.printf("%-20s\t%-15d\t%s\n", f.getName(), f.length(), new Date(f.lastModified()));
        }
    }
}
