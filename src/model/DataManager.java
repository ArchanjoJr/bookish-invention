package model;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataManager {
	
	private static DataManager instance;
	// This is the file directory name
	private String directoryName = ".data/";
	// This is the file name
	private String fileName = "text.txt";
	// This is the path
	private String pathName = directoryName + fileName;
	// This will reference one line at a time
    String line = null;
    // List to hold the words in for each line
    public List words = new List();
	
	public DataManager() {
	}
	
	// This function read's the file data
	public void readFile(){
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(pathName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                // Temporary array to hold the words
                String[] wordsArray = line.split(" ");
                // Add the words to words list
                for (int index = 0; index < wordsArray.length; index ++){
        			words.add(wordsArray[index]);
        		}
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + pathName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" + pathName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
	
	public static DataManager getInstance() {
		if (instance == null) {
			instance = new DataManager();
		}
		return instance;
	}



}
