package org.example.InputValidator;

import java.util.Scanner;

public class InputValidator {

	public static boolean intValidator(Scanner scanner){
		while(!scanner.hasNextInt()){
			System.out.println("Input invalido");
			scanner.next();
		}
		return true;
	}

}