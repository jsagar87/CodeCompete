package gfg.Hard.problem1;

import java.util.*;

public class LargestNumber {

    ArrayList<String>[] table = new ArrayList[10];

    public LargestNumber(String []listOfNumber) {
        for (int i = 0 ; i <= 9 ; i ++) {
            table[i] = new ArrayList<>();
        }
        for (String s : listOfNumber) {
            table[Integer.parseInt(""+s.charAt(0))].add(s);
        }
        for (ArrayList<String> ls: table) {
            modifyList(ls);
        }
    }

    private String getNumber() {
        StringBuilder largestNumber = new StringBuilder("");
        for (int i = table.length - 1 ; i >=0 ; i -- ){
            table[i].stream().forEach(x -> largestNumber.append(x));
        }
        return largestNumber.toString();
    }

    private void modifyList(ArrayList<String> ls) {
        ArrayList<String> newLst = new ArrayList<>();
        // 90 99 98  92 929 900 903 91 9911
        Collections.sort(ls, new Comparator<String>() {  // Sspecial comparator for internal ordering
            @Override
            public int compare(String o1, String o2) {
                return ((Integer)Integer.parseInt((o2 + o1))).compareTo(Integer.parseInt((o1+o2))) ;
//                // Alternate approach
//                int o1Pointer = 0,
//                        o2Pointer = 0;
//                int returnVal = 0 ;
//                while(true) {
//                    if (o1Pointer < o1.length()) o1Pointer ++;
//                    if (o2Pointer < o2.length()) o2Pointer ++;
//                    if (o1.charAt(o1Pointer) > o2.charAt(o2Pointer) ) {
//                        returnVal = 1;
//                    } else if (o1.charAt(o1Pointer) < o2.charAt(o2Pointer)) {
//                        returnVal = -1;
//                    } else {
//                        returnVal = 0;
//                    }
//                    if (o1Pointer < o1.length() && o2Pointer < o2.length() ) {
//                        break;
//                    }
//                }
//                return 0;
            }
        });
    }

    public static void main(String []args) {
        /*
         * Reading input
         */
        Scanner scan = new Scanner(System.in);
        List<Integer> flatArrayList = new ArrayList<>();

        while(scan.hasNext())
            flatArrayList.add(scan.nextInt());

        System.out.println(flatArrayList);

        /*
         * Sampling input creating objects
         *
         */
        int _flatCursor = 0;
        // Number of test case on 0
        int test_cases = flatArrayList.get(_flatCursor); // _flatCursor = 0

        // start 0 to test_case
        for (int i = 0 ; i < test_cases; i++) {

            _flatCursor ++ ; // post number of test cases 1
            int numberOFArrayInput = flatArrayList.get(_flatCursor) ;

            _flatCursor ++ ; // post capturing number of following items 2 ->numberOfASrra
            String []tcItems = new String[numberOFArrayInput];

            int idx;
            int _cur = 0;
            for (idx = 0 ; idx < numberOFArrayInput ; idx ++) {
                _cur = _flatCursor + idx ;
                tcItems[idx] = String.valueOf(flatArrayList.get(_cur));
            }
            _flatCursor = _cur;
            LargestNumber ln = new LargestNumber(tcItems);

            System.out.println(ln.getNumber());

        }
    }
}
