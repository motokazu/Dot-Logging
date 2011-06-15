/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/motokazu/Development/github/dotlgng-android/couchone-libcouch-android-2ab3a73/src/com/couchone/libcouch/ICouchClient.aidl
 */
package com.couchone.libcouch;
public interface ICouchClient extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.couchone.libcouch.ICouchClient
{
private static final java.lang.String DESCRIPTOR = "com.couchone.libcouch.ICouchClient";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.couchone.libcouch.ICouchClient interface,
 * generating a proxy if needed.
 */
public static com.couchone.libcouch.ICouchClient asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.couchone.libcouch.ICouchClient))) {
return ((com.couchone.libcouch.ICouchClient)iin);
}
return new com.couchone.libcouch.ICouchClient.Stub.Proxy(obj);
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
case TRANSACTION_couchStarted:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.couchStarted(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_databaseCreated:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
this.databaseCreated(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.couchone.libcouch.ICouchClient
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
/* Callback to notify when CouchDB has started */
public void couchStarted(java.lang.String host, int port) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(host);
_data.writeInt(port);
mRemote.transact(Stub.TRANSACTION_couchStarted, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/* Callback notifies when the database requested
	 * has been created
	 */
public void databaseCreated(java.lang.String dbName, java.lang.String user, java.lang.String pass, java.lang.String tag) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(dbName);
_data.writeString(user);
_data.writeString(pass);
_data.writeString(tag);
mRemote.transact(Stub.TRANSACTION_databaseCreated, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_couchStarted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_databaseCreated = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
/* Callback to notify when CouchDB has started */
public void couchStarted(java.lang.String host, int port) throws android.os.RemoteException;
/* Callback notifies when the database requested
	 * has been created
	 */
public void databaseCreated(java.lang.String dbName, java.lang.String user, java.lang.String pass, java.lang.String tag) throws android.os.RemoteException;
}
