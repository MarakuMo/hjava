package org.huys.dp.behavioral.interpreter;

import java.util.Stack;
import java.util.HashMap;

public class InterpreterDemo
{
    public static void main(String[] args)
    {
        Before_DP.test();
        After_DP.test();
        Using_DP.test();
    }
}

class Before_DP {

    public static boolean precedence(char a, char b)
    {
        String high = "*/", low = "+-";
        if (a == '(')
        return false;
        if (a == ')' && b == '(')
        {
            System.out.println(")-(");
            return false;
        }
        if (b == '(')
        return false;
        if (b == ')')
        return true;
        if (high.indexOf(a) >  - 1 && low.indexOf(b) >  - 1)
        return true;
        if (high.indexOf(a) >  - 1 && high.indexOf(b) >  - 1)
        return true;
        if (low.indexOf(a) >  - 1 && low.indexOf(b) >  - 1)
        return true;
        return false;
    }
    public static String convert_to_postfix(String expr)
    {
        Stack < Character > op_stack = new Stack < Character > ();
        StringBuffer out = new StringBuffer();
        String opers = "+-*/()";
        char top_sym = '+';
        boolean empty;
        String[] tokens = expr.split(" ");

        for (int i = 0; i < tokens.length; i++)
        if (opers.indexOf(tokens[i].charAt(0)) ==  - 1)
        {
            out.append(tokens[i]);
            out.append(' ');
        }
        else
        {
            while (!(empty = op_stack.isEmpty()) && precedence(top_sym =
            op_stack.pop(), tokens[i].charAt(0)))
            {
                out.append(top_sym);
                out.append(' ');
            }
            if (!empty)
            op_stack.push(top_sym);
            if (empty || tokens[i].charAt(0) != ')')
            op_stack.push(tokens[i].charAt(0));
            else
            top_sym = op_stack.pop();
        }
        while (!op_stack.isEmpty())
        {
            out.append(op_stack.pop());
            out.append(' ');
        }
        return out.toString();
    }

    public static double process_postfix(String postfix, HashMap < String, Integer > map)
    {
        Stack < Double > stack = new Stack < Double > ();
        String opers = "+-*/";
        String[] tokens = postfix.split(" ");
        for (int i = 0; i < tokens.length; i++)
        // If token is a number or variable
        if (opers.indexOf(tokens[i].charAt(0)) ==  - 1)
        {
            double term = 0.;
            try
            {
                term = Double.parseDouble(tokens[i]);
            }
            catch (NumberFormatException ex)
            {
                term = map.get(tokens[i]);
            }
            stack.push(term);

            // If token is an operator
        }
        else
        {
            double b = stack.pop(), a = stack.pop();
            if (tokens[i].charAt(0) == '+')
            a = a + b;
            else if (tokens[i].charAt(0) == '-')
            a = a - b;
            else if (tokens[i].charAt(0) == '*')
            a = a * b;
            else if (tokens[i].charAt(0) == '/')
            a = a / b;
            stack.push(a);
        }
        return stack.pop();
    }

    public static void test()
    {
        String infix = "C * 9 / 5 + 32";
        String postfix = convert_to_postfix(infix);
        System.out.println("Infix:   " + infix);
        System.out.println("Postfix: " + postfix);
        HashMap < String, Integer > map = new HashMap < String, Integer > ();
        for (int i = 0; i <= 100; i += 10)
        {
            map.put("C", i);
            System.out.println("C is " + i + ",  F is " + process_postfix
            (postfix, map));
        }
    }
}


interface Operand
{
    double evaluate(HashMap < String, Integer > context);
    void traverse(int level);
}

class Expression implements Operand
{
    private char m_operator;
    public Operand left, rite;
    public Expression(char op)
    {
        m_operator = op;
    }
    public void traverse(int level)
    {
        left.traverse(level + 1);
        System.out.print("" + level + m_operator + level + " ");
        rite.traverse(level + 1);
    }
    public double evaluate(HashMap < String, Integer > context)
    {
        double result = 0.;
        double a = left.evaluate(context);
        double b = rite.evaluate(context);
        if (m_operator == '+')
        result = a + b;
        else if (m_operator == '-')
        result = a - b;
        else if (m_operator == '*')
        result = a * b;
        else if (m_operator == '/')
        result = a / b;
        return result;
    }
}

class Variable implements Operand
{
    private String m_name;
    public Variable(String name)
    {
        m_name = name;
    }
    public void traverse(int level)
    {
        System.out.print(m_name + " ");
    }
    public double evaluate(HashMap < String, Integer > context)
    {
        return context.get(m_name);
    }
}

class Number implements Operand
{
    private double m_value;
    public Number(double value)
    {
        m_value = value;
    }
    public void traverse(int level)
    {
        System.out.print(m_value + " ");
    }
    public double evaluate(HashMap context)
    {
        return m_value;
    }
}

class After_DP
{
    public static boolean precedence(char a, char b)
    {
        String high = "*/", low = "+-";
        if (a == '(')
        return false;
        if (a == ')' && b == '(')
        {
            System.out.println(")-(");
            return false;
        }
        if (b == '(')
        return false;
        if (b == ')')
        return true;
        if (high.indexOf(a) >  - 1 && low.indexOf(b) >  - 1)
        return true;
        if (high.indexOf(a) >  - 1 && high.indexOf(b) >  - 1)
        return true;
        if (low.indexOf(a) >  - 1 && low.indexOf(b) >  - 1)
        return true;
        return false;
    }
    public static String convert_to_postfix(String expr)
    {
        Stack < Character > op_stack = new Stack < Character > ();
        StringBuffer out = new StringBuffer();
        String opers = "+-*/()";
        char top_sym = '+';
        boolean empty;
        String[] tokens = expr.split(" ");

        for (int i = 0; i < tokens.length; i++)
        if (opers.indexOf(tokens[i].charAt(0)) ==  - 1)
        {
            out.append(tokens[i]);
            out.append(' ');
        }
        else
        {
            while (!(empty = op_stack.isEmpty()) && precedence(top_sym =
            op_stack.pop(), tokens[i].charAt(0)))
            {
                out.append(top_sym);
                out.append(' ');
            }
            if (!empty)
            op_stack.push(top_sym);
            if (empty || tokens[i].charAt(0) != ')')
            op_stack.push(tokens[i].charAt(0));
            else
            top_sym = op_stack.pop();
        }
        while (!op_stack.isEmpty())
        {
            out.append(op_stack.pop());
            out.append(' ');
        }
        return out.toString();
    }
    public static Operand build_syntax_tree(String tree)
    {
        Stack < Operand > stack = new Stack < Operand > ();
        String opers = "+-*/";
        String[] tokens = tree.split(" ");
        for (int i = 0; i < tokens.length; i++)
        // If token is a number or variable
        if (opers.indexOf(tokens[i].charAt(0)) ==  - 1)
        {
            Operand term = null;
            try
            {
                term = new Number(Double.parseDouble(tokens[i]));
            }
            catch (NumberFormatException ex)
            {
                term = new Variable(tokens[i]);
            }
            stack.push(term);

            // If token is an operator
        }
        else
        {
            Expression expr = new Expression(tokens[i].charAt(0));
            expr.rite = stack.pop();
            expr.left = stack.pop();
            stack.push(expr);
        }
        return stack.pop();
    }

    public static void test()
    {
        System.out.println("celsi * 9 / 5 + thirty");
        String postfix = convert_to_postfix("celsi * 9 / 5 + thirty");
        System.out.println(postfix);
        Operand expr = build_syntax_tree(postfix);
        expr.traverse(1);
        System.out.println();
        HashMap < String, Integer > map = new HashMap < String, Integer > ();
        map.put("thirty", 30);
        for (int i = 0; i <= 100; i += 10)
        {
            map.put("celsi", i);
            System.out.println("C is " + i + ",  F is " + expr.evaluate(map));
        }
    }
}

class StkChar {
    private char[] arr = new char[9];
    private int    sp  = -1;
    void    push( char ch ) { if ( ! isFull()) arr[++sp] = ch; }
    char    pop()           { if (isEmpty()) return '\0';  return arr[sp--]; }
    boolean isFull()        { return sp == arr.length-1; }
    boolean isEmpty()       { return sp == -1; }
}

class StkInt {
    private int[] arr = new int[9];
    private int   sp  = -1;
    void    push( int ch ) { if ( ! isFull()) arr[++sp] = ch; }
    int     pop()          { if (isEmpty()) return 0;  return arr[sp--]; }
    boolean isFull()       { return sp == arr.length-1; }
    boolean isEmpty()      { return sp == -1; }
}

class Using_DP {

    public static boolean precedence( char a, char b ) {
        String high = "*/", low = "+-";
        if (a == '(') return false;     // if (a == '(' && b == ')') return false;
        if (a == ')'  &&  b == '(') { System.out.println( ")-(" ); return false; }
        if (b == '(') return false;
        if (b == ')') return true;
        if (high.indexOf( a ) > -1  &&  low.indexOf( b )  > -1) return true;
        if (high.indexOf( a ) > -1  &&  high.indexOf( b ) > -1) return true;
        if (low.indexOf( a ) > -1   &&  low.indexOf( b )  > -1) return true;
        return false;
    }
    public static String convertToPostfix( String in ) {
        StkChar      opstk  = new StkChar();
        StringBuffer out    = new StringBuffer();
        String       opers  = "+-*/()";
        char         topsym = '+';
        boolean      empty;

        for (int i = 0; i < in.length(); i++)
        if (opers.indexOf( in.charAt(i) ) == -1)
        out.append( in.charAt(i) );
        else {
            while ( ! (empty = opstk.isEmpty())
            &&  precedence( topsym = opstk.pop(), in.charAt(i) ))
            out.append( topsym );
            if ( ! empty)                     opstk.push( topsym );
            if (empty || in.charAt(i) != ')') opstk.push( in.charAt(i) );
            else                              topsym = opstk.pop();
        }
        while ( ! opstk.isEmpty()) out.append( opstk.pop() );
        return out.toString();
    }
    public static int evaluate( String in ) {
        StkInt stack = new StkInt();
        String opers = "+-*/";
        for (int a, b, i=0; i < in.length(); i++)
        if (opers.indexOf( in.charAt(i) ) == -1)
        stack.push( in.charAt(i)-48 );
        else {
            b = stack.pop();  a = stack.pop();
            if      (in.charAt(i) == '+') a = a + b;
            else if (in.charAt(i) == '-') a = a - b;
            else if (in.charAt(i) == '*') a = a * b;
            else if (in.charAt(i) == '/') a = a / b;
            stack.push( a );
        }
        return stack.pop();
    }
    public static void test() {
        //System.out.print( args[0] );
        System.out.print("2+3*4-5+6");
        String postfix = convertToPostfix( "2+3*4-5+6" );
        System.out.print( " -- " + postfix );
        System.out.println( " -- " + evaluate( postfix ) );
    } 
}
