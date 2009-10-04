package org.huys.algo.misc;

public class CrossRiver {

    private int moveCount = 0;

    private int leftSide[] = new int[3];
    private int rightSide[] = new int[3];

    private int onBoat = 0;

    private int WOLF = 1;
    private int SHEEP = 2;
    private int CABAGE = 3;

    private boolean isLeftToRight = true;

    public CrossRiver() {
        for (int i = 0; i < 3; i++) {
            leftSide[i] = i + 1;
            rightSide[i] = 0;
        }
    }

    public String int2str(int animals) {
        String tmp;

        switch (animals) {
        case 1:
            tmp = "Wolf";
            break;
        case 2:
            tmp = "Sheep";
            break;
        case 3:
            tmp = "Cabage";
            break;
        default:
            tmp = "None";
        }
        return tmp;
    }

    public void moveLeftToBoat() {
        for (int i = 0; i < 3; i++) {
            if (leftSide[i] != 0) {
                onBoat = leftSide[i];
                leftSide[i] = 0;

                if (isValid()) {
                    return;
                } else {
                    leftSide[i] = onBoat;
                    onBoat = 0;
                }

            }
        }
    }

    public void moveBoatTo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = onBoat;
                onBoat = 0;
            }
        }
    }

    
    public void moveRightToBoat()
    {
        //if ( count(rightSide)==1 )
        //  return;
        
        for (int i = 0; i < 3; i++) {
            if (rightSide[i] != 0) {
                onBoat = rightSide[i];
                rightSide[i] = 0;

                if (isValid()) {
                    return;
                } else {
                    rightSide[i] = onBoat;
                    onBoat = 0;
                }

            }
        }
        
    }
    
    public void move() {
        
        if (count(leftSide)==1 && count(rightSide)==2  && isValid() &&
!isLeftToRight )
        {
            isLeftToRight = true;
            moveCount++;
            return;
        }
        
        if (isLeftToRight) {
            if (onBoat == 0) {
                moveLeftToBoat();
            } else {
                moveBoatTo(rightSide);
                isLeftToRight = false;
            }
        } else {
            if (onBoat == 0) {
                if (count(rightSide)==1)
                    isLeftToRight = true;
                else
                    moveRightToBoat();
            } else {
                moveBoatTo(leftSide);
                isLeftToRight = true;
            }
        }

        moveCount++;

    }

    public boolean search(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key)
                return true;
        }
        return false;
    }

    public int count(int[] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0)
                count++;
        }

        return count;
    }

    public boolean isValid() {

        if (search(leftSide, WOLF) && search(leftSide, SHEEP))
            return false;

        if (search(leftSide, SHEEP) && search(leftSide, CABAGE))
            return false;

        if (search(rightSide, WOLF) && search(rightSide, SHEEP))
            return false;

        if (search(rightSide, SHEEP) && search(rightSide, CABAGE))
            return false;
        
        if (count(leftSide)==1 && count(rightSide)==1 && onBoat==SHEEP ) {
            if (isLeftToRight && search(rightSide, WOLF) ) {
                return false;
            }
        }

        return true;
    }
    
    public boolean isfinished()
    {
        return !((count(leftSide)==0)&&(onBoat==0));
    }

    public String toString() {
        String tmp;
        tmp = "=======Move===" + moveCount + "===================\n";
        tmp += "=left==";
        for (int i = 0; i < 3; i++) {
            if (leftSide[i] != 0) {
                tmp += int2str(leftSide[i]) + "=";
            }
        }
        tmp += "=========\n~~~~~~~~~~~\n";
        tmp += "==Onboat=";
        if (onBoat != 0) {
            tmp += int2str(onBoat);
        }
        tmp += "=========\n~~~~~~~~~~~\n";

        tmp += "=right==";
        for (int i = 0; i < 3; i++) {
            if (rightSide[i] != 0) {
                tmp += int2str(rightSide[i]) + "=";
            }
        }
        tmp += "=========\n";

        return tmp;
    }

    public static void main(String[] args) {
        CrossRiver cr = new CrossRiver();

        System.out.println(cr);

        while (cr.isfinished()) {
            cr.move();

            System.out.println(cr);
        }
    }

}


