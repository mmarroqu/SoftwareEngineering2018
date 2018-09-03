package edu.nd.se2018.homework.hwk1;
import java.util.*;
public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		HashSet<String> nums = new HashSet<String>();
		int sum=0;
		
		for(int i=0; i< numbers.length; i++) {
			// Only add the number if it hasnt appeared yet
			if(!nums.contains(String.valueOf(numbers[i]))) {
				nums.add(String.valueOf(numbers[i]));
				sum = sum + numbers[i];
			}
		
		}
		
		return sum;	
	}
}
