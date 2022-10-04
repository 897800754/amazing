/*
 * Copyright (c) 1995, 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package org.omg.CORBA;

/**
 * This exception indicates a persistent storage failure, for example,
 * failure to establish a database connection or corruption of a
 * database.<P>
 * It contains a minor code, which gives more detailed information about
 * what caused the exception, and a completion status. It may also contain
 * a string describing the exception.
 *
 * @see <A href="../../../../technotes/guides/idl/jidlExceptions.html">documentation on
 * Java&nbsp;IDL exceptions</A>
 */

public final class PERSIST_STORE extends SystemException {
    /**
     * Constructs a <code>PERSIST_STORE</code> exception with a default minor code
     * of 0, a completion state of CompletionStatus.COMPLETED_NO,
     * and a null description.
     */
    public PERSIST_STORE() {
        this("");
    }

    /**
     * Constructs a <code>PERSIST_STORE</code> exception with the specified description message,
     * a minor code of 0, and a completion state of COMPLETED_NO.
     *
     * @param s the String containing a detail message
     */
    public PERSIST_STORE(String s) {
        this(s, 0, CompletionStatus.COMPLETED_NO);
    }

    /**
     * Constructs a <code>PERSIST_STORE</code> exception with the specified
     * minor code and completion status.
     *
     * @param minor     the minor code
     * @param completed the completion status
     */
    public PERSIST_STORE(int minor, CompletionStatus completed) {
        this("", minor, completed);
    }

    /**
     * Constructs a <code>PERSIST_STORE</code> exception with the specified description
     * message, minor code, and completion status.
     *
     * @param s         the String containing a description message
     * @param minor     the minor code
     * @param completed the completion status
     */
    public PERSIST_STORE(String s, int minor, CompletionStatus completed) {
        super(s, minor, completed);
    }
}
