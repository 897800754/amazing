package com.sun.corba.se.PortableActivationIDL;

/**
 * com/sun/corba/se/PortableActivationIDL/ServerAlreadyActiveHolder.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from /jenkins/workspace/8-2-build-macosx-x86_64/jdk8u261/295/corba/src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
 * Thursday, June 18, 2020 6:39:16 AM GMT
 */

public final class ServerAlreadyActiveHolder implements org.omg.CORBA.portable.Streamable {
    public com.sun.corba.se.PortableActivationIDL.ServerAlreadyActive value = null;

    public ServerAlreadyActiveHolder() {
    }

    public ServerAlreadyActiveHolder(com.sun.corba.se.PortableActivationIDL.ServerAlreadyActive initialValue) {
        value = initialValue;
    }

    public void _read(org.omg.CORBA.portable.InputStream i) {
        value = com.sun.corba.se.PortableActivationIDL.ServerAlreadyActiveHelper.read(i);
    }

    public void _write(org.omg.CORBA.portable.OutputStream o) {
        com.sun.corba.se.PortableActivationIDL.ServerAlreadyActiveHelper.write(o, value);
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.sun.corba.se.PortableActivationIDL.ServerAlreadyActiveHelper.type();
    }

}
