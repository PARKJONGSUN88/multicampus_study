package com.workshop6.util;

import java.util.Scanner;

public class CommonUtil {
   public static String getUserInput() {
	   Scanner input = new Scanner(System.in);
	   return input.next();
   }
}
