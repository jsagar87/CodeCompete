package gfg.Basic.problem1;

import java.util.Scanner;
import java.util.Arrays;

public class MissingNumber {

    int[] numbers = null;

    public MissingNumber(int []numbers){
        this.numbers = numbers;
        Arrays.sort(this.numbers);
    }

    public int find(){
        int missing = -1;
        for (int id = 0 ; id < numbers.length ; id ++) {
            if ((id + 1) != numbers[id] ){
                missing = (id+1) ;
                break;
            }
        }
        return missing;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int testCases = scan.nextInt();

        for( int tc = 0 ; tc < testCases ; tc ++ ) {
            int numberOfElem = scan.nextInt();
            int elements[] = new int[numberOfElem];
            for ( int idx = 0 ; idx < numberOfElem - 1 ; idx ++ ) { // -1 iterations as one missing number
                elements[idx] = scan.nextInt();
            }
            elements[numberOfElem - 1] = Integer.MAX_VALUE ;
            MissingNumber missingNumber = new MissingNumber(elements);
            System.out.println(missingNumber.find());
        }

//        // Code for debugging
//        int[] five = new int[5];
//        five[0] = 4 ;
//        five[1] = 5 ;
//        five[2] = 1 ;
//        five[3] = 2 ;
//        five[4] = Integer.MAX_VALUE ;  // stuffing
//        MissingNumber missingNumber = new MissingNumber(five);
//        System.out.println(missingNumber.find());
    }
}
