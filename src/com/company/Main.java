package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        int sum = 8;
        ArrayList<Integer> sortedList1 = new ArrayList<>(Arrays.asList(1,2,3,9));
        ArrayList<Integer> unsortedList1 = new ArrayList<>(Arrays.asList(1,9,3,2));
        ArrayList<Integer> sortedList2 = new ArrayList<>(Arrays.asList(1,2,4,4));
        ArrayList<Integer> unsortedList2 = new ArrayList<>(Arrays.asList(4,4,1,2));
        System.out.println("Target sum : 8");
        {
            System.out.println(sortedList1.toString() + solutionInQuadraticTime(sortedList1, sum));
            System.out.println(unsortedList1.toString() + solutionInQuadraticTime(unsortedList1, sum));
            System.out.println(sortedList2.toString() + solutionInQuadraticTime(sortedList2, sum));
            System.out.println(unsortedList2.toString() + solutionInQuadraticTime(unsortedList2, sum));
        }
        {
            System.out.println(sortedList1.toString() + solutionInLogTimesLinear(sortedList1, sum));
            System.out.println(unsortedList1.toString() + solutionInLogTimesLinear(unsortedList1, sum));
            System.out.println(sortedList2.toString() + solutionInLogTimesLinear(sortedList2, sum));
            System.out.println(unsortedList2.toString() + solutionInLogTimesLinear(unsortedList2, sum));
        }
        {
            System.out.println(sortedList1.toString() + solutionInLinearSorted(sortedList1, sum));
            System.out.println(sortedList2.toString() + solutionInLinearSorted(sortedList2, sum));
        }
        {
            System.out.println(sortedList1.toString() + solutionInLinearWithStructure(sortedList1, sum));
            System.out.println(unsortedList1.toString() + solutionInLinearWithStructure(unsortedList1, sum));
            System.out.println(sortedList2.toString() + solutionInLinearWithStructure(sortedList2, sum));
            System.out.println(unsortedList2.toString() + solutionInLinearWithStructure(unsortedList2, sum));
        }
    }

    public static boolean solutionInLinearWithStructure(ArrayList<Integer> a, int sum){
        int n = a.size();
        HashSet<Integer> hashSet = new HashSet<>(a);
        for (Integer integer : a) {
            if (hashSet.contains(sum - integer)) {
                return true;
            } else {
                hashSet.add(sum - integer);
            }
        }
        return false;
    }

    public static boolean solutionInLinearSorted(ArrayList<Integer> a, int sum){
        int n = a.size();
        int up = n-1, low = 0;
        while(low < up){
            if(a.get(low) + a.get(up) == sum){
                return true;
            }
            else if(a.get(low) + a.get(up) < sum){
                ++ low;
            }
            else{
                -- up;
            }
        }
        return false;
    }

    public static boolean solutionInLogTimesLinear(ArrayList<Integer> a, int sum){
        int n = a.size();
        for(int i=0;i<n;++i){
            if(a.contains(sum - a.get(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean solutionInQuadraticTime(ArrayList<Integer> a, int sum){
        int n = a.size();
        for(int i=0;i<n-1;++i){
            for(int j = i+1;j<n;++j){
                if(a.get(i) + a.get(j) == sum){
                    return true;
                }
            }
        }
        return false;
    }
}
