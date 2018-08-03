package gfg.Hard.problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SubProblem {
    public static void main(String[] args) {
        ArrayList<String> newLst = new ArrayList<>();
        // 90 99 98  92 929 900 903 91 9911
        newLst.add("3");
        newLst.add("30");
        newLst.add("34");

//        newLst.add("9");
//        newLst.add("99");
//        newLst.add("98");
//        newLst.add("92");
//        newLst.add("929");
//        newLst.add("900");
//        newLst.add("9900");
//        newLst.add("9090");
//        newLst.add("903");
//        newLst.add("91");
//        newLst.add("9911");
        System.out.println(newLst);

        Collections.sort(newLst, new Comparator<String>() {  // Sspecial comparator for internal ordering
            @Override
            public int compare(String o1, String o2) {
                return ((Integer)Integer.parseInt((o2 + o1))).compareTo(Integer.parseInt((o1+o2))) ;
            }
        });

        System.out.println(newLst);

    }
    public static int lenOfTraiZeros(String s) {
         char[] c = s.toCharArray();
         int len = 0;
         for (int i = c.length - 1 ; i >= 0 ; i -- ) {
             if(c[i]=='0')
             {
                 len ++;
             }
             else {
                 break;
             }
         }
        System.out.println(len);
         return len;
    }

}
