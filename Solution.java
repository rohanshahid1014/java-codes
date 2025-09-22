package main.Solution;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Double a,b,c,x,y,ya,yb,yc,te;
        System.out.println("Give value of a");
        a=inp.nextDouble();
        System.out.println("Give value of b");
        b=inp.nextDouble();
        x=a;
        ya=Math.pow(x,3)-(Math.pow(x,2)*3)-(3*x)+3;
        x=b;
        yb=Math.pow(x,3)-(Math.pow(x,2)*3)-(3*x)+3;
        te = 0.000001;
        if (Math.abs(ya)==0 || Math.abs(yb)==0) {
            if (Math.abs(ya)==0) System.out.println(a+"  is solution");
            else System.out.println(b+"  is solution");
        }
        y=ya*yb;
        if (y>0) {
    System.out.println("No solution between two values");
    return;
}

        c=(a+b)/2;
        x=c;
        yc=Math.pow(x,3)-(Math.pow(x,2)*3)-(3*x)+3;
        if (Math.abs(yc)==0)     System.out.print("Solution is "+c);
        while (Math.abs(yc)>te) 
        {
        if (ya * yc < 0) b = c;
        if (yb * yc < 0) a = c;
            c = (a+b)/2;
            x = c;     
            yc=Math.pow(x,3)-(Math.pow(x,2)*3)-(3*x)+3;
        }
          if(Math.abs(yc)<te)System.out.println("The solution is"+ c);   
    }
}


