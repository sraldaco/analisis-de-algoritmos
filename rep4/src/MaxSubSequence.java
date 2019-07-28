package com.rep4;

import java.util.Arrays;

public class MaxSubSequence {

    public static void main(String[] args) {
	    int[] s = new int[] {5, 15, -30, 10, -5, 40, 10};
	    int low = 0, high = s.length -1;
	    int[] max = getSubSeq(low, high, s);
	    int i = max[0], j = max[1];
	    int[] sub = Arrays.copyOfRange(s, i, j+1);
	    System.out.println("S = " + Arrays.toString(s) + " tamaño: " + s.length);
	    System.out.println("S' = [" + i + ",...," + j + "] tamaño: " + sub.length);
	    System.out.println("S' = " + Arrays.toString(sub) + " suma: " + max[2]);
    }

    public static int[] getSubSeq (int low, int high, int[] seq) {
        if (low > high) return new int[] {low, high, 0};
        if (low == high) return new int[] {low, high, seq[low] > 0 ? seq[low] : 0};
        int medium = (low + high) / 2;
        int[] partial = max(getSubSeq(low, medium, seq), getSubSeq(medium + 1, high, seq));
        int[] maxLeft = new int[] {medium, medium, seq[medium]};
        int[] maxRight = new int[] {medium + 1, medium + 1, seq[medium + 1]};
        int sum = 0;
        for (int i = medium; i >= low; i--) {
            sum += seq[i];
            if (sum > maxLeft[2]) {
                maxLeft[0] = i; maxLeft[2] = sum;
            }
        }
        sum = 0;
        for (int i = medium + 1; i <= high; i++) {
            sum += seq[i];
            if (sum > maxRight[2]) {
                maxRight[1] = i; maxRight[2] = sum;
            }
        }
        return max(sum(maxLeft,maxRight), partial);
    }

    public static int[] max(int[] left, int[] right) {
        if (left[2] > right[2]) return left;
        else return right;
    }
    public static int[] sum(int[] left, int[] right) {
        return new int[] {left[0], right[1], left[2] + right[2]};
    }
}
