package org.omg.IOP;


/**
 * org/omg/IOP/Encoding.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from /jenkins/workspace/8-2-build-macosx-x86_64/jdk8u261/295/corba/src/share/classes/org/omg/PortableInterceptor/IOP.idl
 * Thursday, June 18, 2020 6:39:17 AM GMT
 */

public final class Encoding implements org.omg.CORBA.portable.IDLEntity {

    /**
     * The encoding format.
     */
    public short format = (short) 0;

    /**
     * The major version of this Encoding format.
     */
    public byte major_version = (byte) 0;

    /**
     * The minor version of this Encoding format.
     */
    public byte minor_version = (byte) 0;

    public Encoding() {
    } // ctor

    public Encoding(short _format, byte _major_version, byte _minor_version) {
        format = _format;
        major_version = _major_version;
        minor_version = _minor_version;
    } // ctor

} // class Encoding
