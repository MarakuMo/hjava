package org.huys.net;

import java.net.NetworkInterface;
import java.util.Enumeration;

public class InterfaceList {

  public static void main(String[] args) throws Exception {

    Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
    while (interfaces.hasMoreElements()) {
      NetworkInterface ni = (NetworkInterface) interfaces.nextElement();
      System.out.println(ni);
    }

  }

}