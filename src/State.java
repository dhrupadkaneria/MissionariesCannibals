
public class State 
{
	int can_count;
	int mis_count;
	int boat_pos;
	State next;
	State prev;
	State(int can_count, int mis_count, int boat_pos, State next, State prev) 
	{
		this.can_count = can_count;
		this.mis_count = mis_count;
		this.boat_pos = boat_pos;
		this.next = next;
		this.prev = prev;
	}
	boolean isReached()
	{
		if(this.can_count == 0 && this.mis_count == 0 && this.boat_pos == 1)
			return true;
		return false;
	}
	boolean isValid() 
	{
		if(this.can_count > 3 || this.can_count < 0 || this.mis_count > 3 || this.mis_count < 0)
			return false;
		if(this.mis_count < this.can_count)
			return false;
		if((this.mis_count == 3 && this.can_count == 0) || (this.mis_count == 0 && this.can_count == 3))
			return false;
		//displayState();
		return true;
	}
	void displayState()
	{
		System.out.println("Can: " + this.can_count);
		System.out.println("Mis: " + this.mis_count);
		if(this.boat_pos == 0)
			System.out.println("Boat: Src");
		else
			System.out.println("Boat: Dest");
	}
}
