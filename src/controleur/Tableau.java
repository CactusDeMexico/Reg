package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel
{
	    private  Object[][] donnees;
	    private final String[] entete ;
	    
	    public Tableau(Object[][] donnees,String[] entete ) {
	        super();
	        this.donnees = donnees; 
	        this.entete = entete;
	    }
	 
	    public int getRowCount() {
	        return donnees.length;
	    }
	 
	    public int getColumnCount() {
	        return entete.length;
	    }
	 
	    public String getColumnName(int columnIndex) {
	        return entete[columnIndex];
	    }
	 
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        return donnees[rowIndex][columnIndex];
	    }
	    public void add(Object [] data) {
	    	Object [][] newDonnees =new Object [this.donnees.length+1][];
	    	int i;
	    	for ( i = 0; i <this.donnees.length; i++)
	    	{
	    			newDonnees[i]=this.donnees[i] ;
	    	}
	    	newDonnees[this.donnees.length] = data;
	    	this.donnees = newDonnees; 
	        
	        this.fireTableDataChanged();
	    }
	 
	    public void remove(int rowIndex) {
	    	Object [][] newDonnees =new Object [this.donnees.length-1][];
	    	int j = 0; 
	    	for (int i = 0; i <this.donnees.length; i++)
	    	{
	    		if (i != rowIndex)
	    			newDonnees[j++]=this.donnees[i] ;
	    		
	    	}
	    	this.donnees = newDonnees;
	        this.fireTableDataChanged();
	    }
	    public Class getColumnClass(int colonne)
        {
            return getValueAt(0, colonne).getClass();
        }
	    
	    public void update (int rowIndex, Object data[])
	    {
	    	Object [][] newDonnees =new Object [this.donnees.length][]; 
	    	for (int i = 0; i <this.donnees.length; i++)
	    	{
	    		if (i != rowIndex)
	    			newDonnees[i]=this.donnees[i] ;
	    		else
	    			newDonnees[i] =data ;
	    		
	    	}
	    	this.donnees = newDonnees;
	        this.fireTableDataChanged();
	    }
	
}
