package org.leitorlivre.inputvalidator;

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