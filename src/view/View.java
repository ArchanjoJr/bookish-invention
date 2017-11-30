package view;
import javax.swing.JOptionPane;

public class View
{
	private String term;
    ///Constructor for the Class
    public View()
    {
    	this.term = JOptionPane.showInputDialog(null,"Text For Search");
	}
	/// Print Function of the wanted string
	public void PrintTerm()

	{
		JOptionPane.showMessageDialog(null,"Searching in text For :"+term);
	}
}
