
public class state 
{
	int miss;
	int cann;
	int boat;
	state prev;
	int depth;
	
	public state(int miss, int cann, int boat, int d)
    {  
        this(miss, cann, boat, null, d);
    }  
      
    public state(int miss, int cann, int boat, state prv, int d)
    {
        this.miss = miss;  
        this.cann = cann;  
        this.boat = boat;  
        this.prev = prv;  
        this.depth = d;
    }
    boolean isValid() 
	{
		if(this.cann > 3 || this.cann < 0 || this.miss > 3 || this.miss < 0) // Src
			return false;
		if((3 - this.cann) > 3 || (3 - this.cann) < 0 || (3 - this.miss) > 3 || (3 - this.miss) < 0) //Dest
			return false;
		if(this.miss > 0 && this.miss < this.cann)
			return false;
		if((3 - this.miss) > 0 && (3 - this.miss) < (3 - this.cann))
			return false;
		return true;
	}
	
    public void display() // this function is used to display the path
    {  
	    if(this.prev != null) 
	    {  
	        this.prev.display();
	        if(this.boat == 0)
		    {
		    	System.out.println("Boat moves from src -> dest");
		    }
		    else if(this.boat == 1)
		    {
		    	System.out.println("Boat moves from dest -> src");
		    }
	    }
	    
	    System.out.println("Src:  M :"+ this.miss + "  C :" + this.cann);
	    System.out.println("Dest: M :"+ (3 - this.miss) + "  C :" + (3 - this.cann));
	}
    
    public boolean checkFinal()
    {  
        if(this.miss == 0 && this.cann == 0 && this.boat == 0)
        	return true;
        return false;
    }
    
}
