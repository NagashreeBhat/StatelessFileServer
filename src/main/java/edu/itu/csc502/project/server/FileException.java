package edu.itu.csc502.project.server;

/**
 * This class is used to specify a custom exception thrown by File.java and FileSystem.java.
 *
 * @author David Fisher
 */
public class FileException extends Exception {
    private static final long serialVersionUID = 6741683207092121843L;

    public FileException(final String message) {
        super(message);
    }

    public FileException(final Throwable cause) {
        super(cause);
    }

    public FileException(final String message, final Throwable cause) {
        super(message, cause);
    }
}