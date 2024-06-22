package com.interview.codes;

import java.util.Scanner;

public class SubArraySum {

	 
	    public static void main(String[] args) {
	 
	        Scanner scn = new Scanner(System.in);
	        int[] arr = new int[scn.nextInt()];
	        int target = scn.nextInt();
	 
	        for (int i = 0; i < arr.length; i++) {
	            arr[i] = scn.nextInt();                   //prepare
	        }
	 
	        System.out.print("arr[]: {");
	        for (int i = 0; i < arr.length; i++) {
	            System.out.print(" "+arr[i]);
	        }
	 
	        System.out.println(" }");
	        solveEfficient(arr, target);
	 
	    }
	 
	    public static void solveEfficient(int[] arr, int target) {
	        int start = 0, end = 0;
	 
	        int currSum = 0;
	 
	        while (start < arr.length && end <= arr.length) {
	            if (currSum == target) {
	                System.out.println("starting index : " + start + ", " +
	                        "Ending index : " + (int) (end - 1));
	 
	                if (end <= arr.length - 1) {
	                    currSum += arr[end];
	                }
	                end++;
	 
	            }
	 
	            else {
	                if (currSum > target) {
	                    currSum -= arr[start];
	                    start++;
	                } else {
	                    if (end <= arr.length - 1) {
	                        currSum += arr[end];
	                    }
	                    end++;
	                }
	            }
	        }
	    }
	}


