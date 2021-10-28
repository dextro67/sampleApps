/*
Given two integer arrays A and B of size N.
There are N gas stations along a circular route, where the amount of gas at station i is A[i].
You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i 
to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.
You can only travel in one direction. i to i+1, i+2, … n-1, 0, 1, 2.. Completing the circuit means starting at i and ending up at i again.

Input Format

The first argument given is the integer array A.
The second argument given is the integer array B.
Output Format

Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.
For Example

Input 1:
    A =  [1, 2]
    B =  [2, 1]
Output 1:
    1
    Explanation 1:
        If you start from index 0, you can fill in A[0] = 1 amount of gas. Now your tank has 1 unit of gas. But you need B[0] = 2 gas to travel to station 1. 
        If you start from index 1, you can fill in A[1] = 2 amount of gas. Now your tank has 2 units of gas. You need B[1] = 1 gas to get to station 0. So, you travel to station 0 and still have 1 unit of gas left over. You fill in A[0] = 1 unit of additional gas, making your current gas = 2. It costs you B[0] = 2 to get to station 1, which you do and complete the circuit. 
*/
import java.util.stream.IntStream;
public class GasStation {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int canCompleteCircuit(final int[] A, final int[] B) {
      // If total available gas is less than required it's not possible.
        if(IntStream.of(A).sum()<IntStream.of(B).sum()){
            System.out.println("Sum of gas seems less than requirement");
            return -1;
        }
          //Approch with the highest difference of gas available vs gas consumed. 
        int largestDiff=0;
        int gasintank=0;
        int count=0;
        for(int x=0;x<A.length;x++){
            count=0;
            if(A[x]<B[x]){
                continue;
            }
            gasintank=0;
            for(int p=x;p<A.length;){
                gasintank+=A[p];
                System.out.println("X="+x+"|  Pointer P= "+p+" gas in tank "+gasintank+" Required gas= "+B[p]);
                count++;
                if(count>A.length){
                    return x;
                }
                if(gasintank>=B[p]){
                    gasintank=gasintank-B[p];
                    p=++p%A.length;
                    continue;
                }
                else{
                    break;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int A [] = {237, 573, 278, 782, 819, 548, 14, 670, 81, 178, 448, 889, 200, 541, 582, 111, 718, 236, 292, 850, 536, 654, 230, 551, 917, 788, 531, 26, 206, 960, 381, 183, 207, 44, 141, 252, 74, 890, 857, 834, 396, 569, 597, 538, 370, 876, 481, 307, 643, 138, 652, 676, 340, 590, 565, 857, 584, 275, 703, 508, 388, 454, 944, 670 };
        int B [] = { 316, 803, 374, 899, 361, 548, 430, 366, 137, 993, 751, 9, 52, 774, 449, 533, 870, 271, 829, 232, 529, 9, 167, 738, 779, 89, 515, 67, 649, 831, 508, 397, 914, 236, 134, 914, 129, 77, 372, 921, 527, 588, 249, 275, 23, 793, 321, 264, 30, 360, 29, 27, 96, 150, 746, 338, 921, 846, 719, 193, 565, 236, 92, 453 } ;

        GasStation s1 = new GasStation();
        System.out.println("Index "+s1.canCompleteCircuit(A,B));
    }
}
