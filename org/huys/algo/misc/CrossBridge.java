package org.huys.algo.misc;

import java.util.Arrays;

class CrossBridge
{
    int[] times = {1, 2, 5, 10};
    int total_time = 0;

    public void moveToThatSide()
    {
        
    }

    public void moveBack()
    {
        
    }

    public void go()
    {
        for (int i=0; i<times.length; i++)
        {
            System.out.print(times[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args)
    {
        new CrossBridge().go();
    }
}

