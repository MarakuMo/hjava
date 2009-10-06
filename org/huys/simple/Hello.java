package org.huys.simple;

/**
 *
 *  @author
 *
 */

/**
 * The HelloWorldApp class implements an application that
 * simply prints "Hello World!" to standard output.
 */

class Hello
{
    public static void sayHello()
    {
//        System.out.println("Hello World!");
        byte a = -1;
        int b = a;
        System.out.println(b);
        a = 1;
        System.out.println((int)a);
    }

    public static void main(String[] args)
    {
        sayHello();
        if (args.length > 0)
            System.out.println(args[0]);
    }
}

