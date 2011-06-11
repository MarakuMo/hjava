package org.huys.net;

import java.net.*;

public class LocalHost
{
    public static void main(String args[])
    {
        System.out.println("Looking up local host");

        try
        {
            //
            InetAddress localAddress = InetAddress.getLocalHost();

            System.out.println("IP address : " + localAddress.getHostAddress());
        }
        catch (UnknownHostException uhe)
        {
            System.out.println("Error - unable to resolve localhost");
        }
    }
}

