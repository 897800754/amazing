package com.sun.corba.se.spi.activation.RepositoryPackage;

/**
 * com/sun/corba/se/spi/activation/RepositoryPackage/ServerDefHolder.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from /jenkins/workspace/8-2-build-macosx-x86_64/jdk8u261/295/corba/src/share/classes/com/sun/corba/se/spi/activation/activation.idl
 * Thursday, June 18, 2020 6:39:16 AM GMT
 */

public final class ServerDefHolder implements org.omg.CORBA.portable.Streamable {
    public com.sun.corba.se.spi.activation.RepositoryPackage.ServerDef value = null;

    public ServerDefHolder() {
    }

    public ServerDefHolder(com.sun.corba.se.spi.activation.RepositoryPackage.ServerDef initialValue) {
        value = initialValue;
    }

    public void _read(org.omg.CORBA.portable.InputStream i) {
        value = com.sun.corba.se.spi.activation.RepositoryPackage.ServerDefHelper.read(i);
    }

    public void _write(org.omg.CORBA.portable.OutputStream o) {
        com.sun.corba.se.spi.activation.RepositoryPackage.ServerDefHelper.write(o, value);
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.sun.corba.se.spi.activation.RepositoryPackage.ServerDefHelper.type();
    }

}
