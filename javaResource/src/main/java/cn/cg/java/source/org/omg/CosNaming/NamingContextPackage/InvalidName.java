package org.omg.CosNaming.NamingContextPackage;


/**
 * org/omg/CosNaming/NamingContextPackage/InvalidName.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from /jenkins/workspace/8-2-build-macosx-x86_64/jdk8u261/295/corba/src/share/classes/org/omg/CosNaming/nameservice.idl
 * Thursday, June 18, 2020 6:39:16 AM GMT
 */

public final class InvalidName extends org.omg.CORBA.UserException {

    public InvalidName() {
        super(InvalidNameHelper.id());
    } // ctor


    public InvalidName(String $reason) {
        super(InvalidNameHelper.id() + "  " + $reason);
    } // ctor

} // class InvalidName
