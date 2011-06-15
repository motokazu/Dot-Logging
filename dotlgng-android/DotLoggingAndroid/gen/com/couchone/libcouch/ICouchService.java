/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/motokazu/Development/github/dotlgng-android/couchone-libcouch-android-2ab3a73/src/com/couchone/libcouch/ICouchService.aidl
 */
package com.couchone.libcouch;
public interface ICouchService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.couchone.libcouch.ICouchService
{
private static final java.lang.String DESCRIPTOR = "com.couchone.libcouch.ICouchService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.couchone.libcouch.ICouchService interface,
 * generating a proxy if needed.
 */
public static com.couchone.libcouch.ICouchService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.couchone.libcouch.ICouchService))) {
return ((com.couchone.libcouch.ICouchService)iin);
}
return new com.couchone.libcouch.ICouchService.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_initCouchDB:
{
data.enforceInterface(DESCRIPTOR);
com.couchone.libcouch.ICouchClient _arg0;
_arg0 = com.couchone.libcouch.ICouchClient.Stub.asInterface(data.readStrongBinder());
this.initCouchDB(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_initDatabase:
{
data.enforceInterface(DESCRIPTOR);
com.couchone.libcouch.ICouchClient _arg0;
_arg0 = com.couchone.libcouch.ICouchClient.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
boolean _arg3;
_arg3 = (0!=data.readInt());
this.initDatabase(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_quitCouchDB:
{
data.enforceInterface(DESCRIPTOR);
this.quitCouchDB();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.couchone.libcouch.ICouchService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/* Starts couchDB, calls "couchStarted" callback when 
     * complete 
     */
public void initCouchDB(com.couchone.libcouch.ICouchClient callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_initCouchDB, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/* The database may not be named as hinted here, this is to
     * prevent conflicts, cmdDb is not currently used
     */
public void initDatabase(com.couchone.libcouch.ICouchClient callback, java.lang.String name, java.lang.String pass, boolean cmdDb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeString(name);
_data.writeString(pass);
_data.writeInt(((cmdDb)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_initDatabase, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*
     * 
     */
public void quitCouchDB() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_quitCouchDB, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_initCouchDB = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_initDatabase = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_quitCouchDB = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
/* Starts couchDB, calls "couchStarted" callback when 
     * complete 
     */
public void initCouchDB(com.couchone.libcouch.ICouchClient callback) throws android.os.RemoteException;
/* The database may not be named as hinted here, this is to
     * prevent conflicts, cmdDb is not currently used
     */
public void initDatabase(com.couchone.libcouch.ICouchClient callback, java.lang.String name, java.lang.String pass, boolean cmdDb) throws android.os.RemoteException;
/*
     * 
     */
public void quitCouchDB() throws android.os.RemoteException;
}
