package test;

import model.DataManager;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataManager mDataManager = new DataManager();
		mDataManager.getInstance();
		
		mDataManager.readFile();
		
		System.out.println(mDataManager.words.getItemCount());
		
	}

}
