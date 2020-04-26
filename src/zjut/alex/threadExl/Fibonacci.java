/*

TODO: print the Fibnacci number as soon as it's computed by child thread

*/


package zjut.alex.threadExl;
public  class Fibonacci implements Runnable{
    //shared resources are static variables
    public static int num=2;
    public int numRe;//index of Fib num
    //f[n-2]
    public static int a=0;
    //f[n-1]
    public static int b=1;
    public int c;//f[n]


    public  Fibonacci(){
        c=a+b;
        a=b;
        b=c;
        numRe=num++;
    }
    public synchronized void run(){
        System.out.println("F["+numRe+"]="+c);
        Thread.yield();
    }
}
