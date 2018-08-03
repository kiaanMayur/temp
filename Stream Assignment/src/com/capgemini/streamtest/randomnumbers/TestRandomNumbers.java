package com.capgemini.streamtest.randomnumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.function.Consumer;

public class TestRandomNumbers {

	public static void main(String[] args) throws IOException {
		
		// instantiating the object of GenerateRandomNumber
		GenerateRandomNumbers random = new GenerateRandomNumbers();
		
		// this will recieve the 100 random numbers from 1 to 49
		int[] randomNumbers = random.genrateNumbers();
		
		for(int i : randomNumbers)
			System.out.println(i + " ");
		
		//now to write this in a file
		BufferedWriter writeFile = null;
		File file = new File("boy.txt");
		
		writeFile = new BufferedWriter(new FileWriter(file));
		for(int i =0; i < randomNumbers.length; i++) {
			writeFile.write(randomNumbers[i] + "\r\n");
		}
		
		writeFile.close();
		
		
		//now we will read this file adn perform some operation
		File file2 = new File("boy.txt");
		BufferedReader readFile = new BufferedReader(new FileReader(file2));
		Set<Integer> noRepeatSet = new HashSet<>();
		String checkNull = null;
		while(checkNull != readFile.readLine()) {
			int temp = Integer.parseInt(readFile.readLine());
			noRepeatSet.add(temp);
		}
		System.out.println("-----------------------");
		Consumer<Integer> disp = System.out :: println;
		noRepeatSet.stream().forEach(disp);
		
		//now writing this to another file
		BufferedWriter writeAnotherFile = new BufferedWriter(new FileWriter(file2));
		
		for(int i = 0; i < noRepeatSet.size(); i++) {
			writeAnotherFile.write(noRepeatSet.);
		}
		
	}

}
