package org.huys.algo.gcd;

public class EuclidEx {

    public static int xr = 0;
    public static int yr = 0;

    public static int solve(int m, int n) {
        if(n == 0)
        {
            xr = 1;
            yr = 0;
            return m;
        }

        int r = solve(n, m%n);
        int t = xr;
        xr = yr;
        yr = t - m / n * yr;
        return r;

    }

    public static void main(String[] args) {
        System.out.println("Solve Euclid((31415, 14142) using solve : " + solve(31415, 14142));
        System.out.println(xr + " * 31415 + (" + yr + " ) * 14142 = " + (xr * 31415 + yr * 14142));
    }
}





