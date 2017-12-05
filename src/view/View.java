package view;
import javax.swing.JOptionPane;
import model.DataManager;
public class View
{
	private DataManager m;
	private String term;
    ///Constructor for the Class
    public View()
    {
    	this.term = JOptionPane.showInputDialog(null,"Text For Search");
	}
	/// Print Function of the wanted string
	public void printTerm()

	{
		JOptionPane.showMessageDialog(null,"Searching in text For :"+term);
	}
	public void makeMsg(){
		m = new DataManager();
		m.getInstance();
		m.readFile();
    	m.searchWord(term);
    	JOptionPane.showMessageDialog(null,
				"Number of Ocurrencies : "+m.occurrences+
						 "\nThe First occurence : "+m.first+
				         "\nThe Last occurence : "+ m.last);
	}
}
