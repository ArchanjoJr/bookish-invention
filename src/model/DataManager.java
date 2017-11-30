package model;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

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
    public static LinkedList words = new LinkedList();
    // List to save matched words
    public LinkedList matchWords = new LinkedList();
    // Flag to know when is the first occurrence 
    private boolean isFirstOcorr = false; 
    // Index of the first occurrence
    public int first = 0;
    // Index of the last occurrence
	public int last = 0;
	// Occurrences of the word
	public int occurrences = 0;
	
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
        			words.add(wordsArray[index].toLowerCase());
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
	
	public boolean searchWord(String word) {
		boolean match = false;
		int index = 0;
		for (Iterator i = words.iterator(); i.hasNext();) {
			String nextWord = (String) i.next();
			if (nextWord.matches(word)) {
				if (!isFirstOcorr) {
					first = index;
					isFirstOcorr = true;
				}
				match = true;
				last = index;
				System.out.println(last);
				occurrences ++;
				matchWords.add(word);
			}
			index++;
		}
		return match;
	}
	
	public static DataManager getInstance() {
		if (instance == null) {
			instance = new DataManager();
		}
		return instance;
	}


}
