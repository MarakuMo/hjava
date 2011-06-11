package org.huys.dll;

public class HelloJNI
{
    static
    {
        // load Glue.dll containing Glue.nativeWidthInBits
        System.loadLibrary( "glue" );
    }
    public static native int widthInBits( int n );

    public static void main(String[] args)
    {
        System.out.println("Load DLL ...");
        System.out.println(widthInBits(2));
    }
}

