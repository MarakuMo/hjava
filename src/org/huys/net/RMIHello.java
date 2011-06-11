package org.huys.net;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIHello extends Remote {
    String sayHello() throws RemoteException;
}