package com.instantly.challenge.traversal;

/**
 * @author saad.patail
 */
public enum VisitorType {
    NAME(new FileVisitor.PrintName()),
    MORE(new FileVisitor.PrintNameAndMore());

    private final FileVisitor visitor;

    private VisitorType(FileVisitor visitor) {
        this.visitor = visitor;
    }

    public FileVisitor getVisitor() {
        return visitor;
    }
}
