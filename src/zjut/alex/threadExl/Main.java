
package zjut.alex.threadExl;

import zjut.alex.threadExl.Fibonacci;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //@arg[0]=10
        //n: the number of child threads the parent thread created
        int n=Integer.parseInt(args[0]);
        for(int i=0;i< n;i++){
            new Thread(new Fibonacci()).start();
        }
    }
}
