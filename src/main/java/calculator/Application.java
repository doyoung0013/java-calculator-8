package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("덧셈할 문자열을 입력해주세요.");
    	String input = sc.nextLine();
    	
    	try {
    		int result = calculator(input);
    		System.out.println("결과 : " + result);
    	} catch(IllegalArgumentException e) {
    		System.out.println("잘못된 입력입니다.");
    	}
    	
    	
    }
    
    public static int calculator(String input) {
    	if (input == null|| input.isEmpty()) { 
    		return 0; 
    	}
    	
    	String delimiter = ",|:";
    	String numbers = input;
    	
    	if (input.startsWith("//")) {
    		int index = input.indexOf("\n");
    		delimiter = input.substring(2, index);
    		numbers = input.substring(index + 1);
    	}
    	
    	String[] partitions = numbers.split(delimiter);
    	
    	int sum = 0;
    	for (String part : partitions) {
    		if(part.isEmpty()) continue;
    			int num = Integer.parseInt(part);
    			
    		if (num < 0) {
    			throw new IllegalArgumentException();
    		}
    		sum += num;
    	}
     	
    	return sum;
    }
}
