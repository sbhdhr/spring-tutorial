package demo.spring.annotations.pkg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService, InitializingBean {

	private String fileName = "src\\fortune-data.txt";
	private ArrayList<String> fortunes;
	private Random random;

	// Adding init code in no-arg constructor

	/*
	 * public FileFortuneService() {
	 * 
	 * File file = new File(fileName);
	 * 
	 * System.out.println("Reading fortunes from file: " + file.getAbsolutePath());
	 * System.out.println("File exists: " + file.exists());
	 * 
	 * 
	 * //Initialize arraylist fortunes = new ArrayList<String>();
	 * 
	 * //initialize random random = new Random();
	 * 
	 * //Read fortunes from file //Try with resources try(BufferedReader br = new
	 * BufferedReader(new FileReader(file))){
	 * 
	 * String temp;
	 * 
	 * while((temp=br.readLine()) != null) { fortunes.add(temp); }
	 * 
	 * 
	 * }catch (IOException e) {
	 * 
	 * e.printStackTrace(); } }
	 */

	@Override
	public String getFortune() {

		// pick a random string from the array
		/*
		 * System.out.println("Fortunes list size: "+fortunes.size()); for (String
		 * s:fortunes){ System.out.println(s); }
		 */

		int index = random.nextInt(fortunes.size());

		return fortunes.get(index);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
		File file = new File(fileName);
		
		System.out.println("Reading fortunes from file: " + file.getAbsolutePath());
		System.out.println("File exists: " + file.exists());
		
		//Initialize arraylist 
		fortunes = new ArrayList<String>();
		
		//initialize random 
		random = new Random();
		
		//Read fortunes from file 
		//Try with resources 
		try(BufferedReader br = new	BufferedReader(new FileReader(file))){
		
			String temp;
			 
			while((temp=br.readLine()) != null){ 
				fortunes.add(temp); 
			}
		}catch (IOException e) {
		  
		  e.printStackTrace(); 
		}
	}

}
