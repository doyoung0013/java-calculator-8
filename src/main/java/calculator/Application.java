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
    		throw e;
    	} finally {
    		sc.close();
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
    		if (index == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
    		delimiter = input.substring(2, index);
    		numbers = input.substring(index + 1);
    	}
    	
    	String[] partitions = numbers.split(delimiter);
    	
    	int sum = 0;
    	for (String part : partitions) {
    		if (part.isEmpty()) continue;
    		if (!part.matches("\\d+")) {
                throw new IllegalArgumentException("양수가 아닌 값이 포함되어 있습니다: " + part);
            }
    		
    		int num = Integer.parseInt(part);
    		sum += num;
    	}
     	
    	return sum;
    }
}
