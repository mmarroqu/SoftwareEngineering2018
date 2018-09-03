package edu.nd.se2018.homework.hwk1;
public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	// Get the number of elements in the array
    	int length = numbers.length;
    	
    	int max=1;
    	// If no numbers given return 0
    	if (length==0)
    		return 0;
    	
    	// Start at left
		for(int i=0; i<length; i++) {
			int counter=0;
			// Start at right
			for(int k=(length-1); k>=i; k--) {
					if(numbers[i+counter]!=numbers[k]) {
						break;
					}
					// Keep track of how many mirrored numbers there has been
					counter++;
			}
			// If the mirrored numbers are higher than observed max then it becomes the new max
			if(counter>max)
				max=counter;
		}
		
		return max;
		
	}
}
