package org.huys.dp.structural.flyweight;

class Gazillion {
    private static int num = 0;
    private int row, col;

    public Gazillion(int maxPerRow) {
        row = num / maxPerRow;
        col = num % maxPerRow;
        num++;
    }

    void report() {
        System.out.print( " " + row + col );
    }

    public static final int ROWS = 6, COLS = 10;
    public static void test() {
        Gazillion[][] matrix = new Gazillion[ROWS][COLS];
        for (int i=0; i < ROWS; i++)
            for (int j=0; j < COLS; j++)
                matrix[i][j] = new Gazillion( COLS );
        for (int i=0; i < ROWS; i++) {
            for (int j=0; j < COLS; j++)
                matrix[i][j].report();
            System.out.println();
        }
    }
}

class GazillionF {
    private int row;
    public GazillionF( int theRow ) {
        row = theRow;
        System.out.println( "ctor: " + row );
    }
    void report( int theCol ) {
        System.out.print( " " + row + theCol );
    }
}

class Factory {
    private GazillionF[] pool;
    public Factory( int maxRows ) {
        pool = new GazillionF[maxRows];
    }
    public GazillionF getFlyweight( int theRow ) {
        if (pool[theRow] == null)
            pool[theRow] = new GazillionF( theRow );
        return pool[theRow];
    }

    public static final int ROWS = 6, COLS = 10;
    public static void test()
    {
        Factory theFactory = new Factory( ROWS );
        for (int i=0; i < ROWS; i++) {
            for (int j=0; j < COLS; j++)
                theFactory.getFlyweight( i ).report( j );
            System.out.println();
        }
    }
}
public class FlyweightDemo {


    public static void main( String[] args ) {
        Gazillion.test();
        Factory.test();
    }
}
