

package org.huys.algo.gcd;

public class Euclid {
    /**
     * The Euclid method of solving the GCD problem.
     *
     * @param   m   first positive integer
     * @param   n   second postive integer
     * @return      the greatest common denominator of m and n
     */
    public static int solve(int m, int n) {

        if ( m <=0 || n <= 0 )
           return -1;

        int r;

        if (m < n) {
            r = m;
            m = n;
            n = r;
        }

        while ( n != 0 ) {
            r = m%n;
            m = n;
            n = r;
        }
        return m;
    }

    /**
     * The Euclid method of solving the GCD problem.
     *
     * @param   m   first positive integer
     * @param   n   second postive integer
     * @return      the greatest common denominator of m and n
     */
    public static int solve1(int m, int n)
    {
        if ( m <=0 || n <= 0 )
           return -1;

        int r;
        if (m < n) {
            r = m;
        } else {
            r = n;
        }

        while ( (m%r !=0) || (n%r != 0) )
            r--;

        return r;
    }

    public static void main(String[] args) {
        System.out.println("Solve Euclid((31415, 14142) using solve : " + solve(31415,14142));
        System.out.println("Solve Euclid((31415, 14142) using solve1: " + solve1(31415, 14142));
    }
}





