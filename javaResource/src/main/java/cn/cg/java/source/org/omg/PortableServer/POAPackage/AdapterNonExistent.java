package org.omg.PortableServer.POAPackage;


/**
 * org/omg/PortableServer/POAPackage/AdapterNonExistent.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from /jenkins/workspace/8-2-build-macosx-x86_64/jdk8u261/295/corba/src/share/classes/org/omg/PortableServer/poa.idl
 * Thursday, June 18, 2020 6:39:17 AM GMT
 */

public final class AdapterNonExistent extends org.omg.CORBA.UserException {

    public AdapterNonExistent() {
        super(AdapterNonExistentHelper.id());
    } // ctor


    public AdapterNonExistent(String $reason) {
        super(AdapterNonExistentHelper.id() + "  " + $reason);
    } // ctor

} // class AdapterNonExistent
