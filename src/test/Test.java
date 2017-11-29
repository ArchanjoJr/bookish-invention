package test;

import model.DataManager;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataManager mDataManager = new DataManager();
		mDataManager.getInstance();
		
		mDataManager.readFile();
		
		System.out.println(mDataManager.words.size());
		
		mDataManager.searchWord("to");
		
		System.out.println("Number of occurrences: " + mDataManager.occurrences);
		
		System.out.println("The first occurence:" + mDataManager.first);
		
		System.out.println("The last occurence: " + mDataManager.last);
	
	}

}
