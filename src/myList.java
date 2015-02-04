
public class myList 
{
	State start;
	State end;
	int size;
	
	myList()
	{
		this.start = null;
		this.end = null;
		size = 0;
	}
	void insertNode(State s)
	{
		if(start == null)
		{
			start = s;
			end = start;
		}
		else
		{
			s.prev = end;
			end.next = s;
			end = s;
		}
	}
	void deleteNode()
	{
		end = end.prev;
		end.next.prev = null;
		end.next = null;
	}
	void display()
	{
		System.out.println("Path size: " + size);
		if(size == 0)
		{
			System.out.println("No Solution");
			return;
		}
		if(start.next == null)
		{
			System.out.println("Can: " + start.can_count);
			System.out.println("Mis: " + start.mis_count);
			if(start.boat_pos == 0)
				System.out.println("Boat: Src");
			else
				System.out.println("Boat: Dest");
		}
		State p = start;
		System.out.println("Can: " + p.can_count);
		System.out.println("Mis: " + p.mis_count);
		if(p.boat_pos == 0)
			System.out.println("Boat: Src");
		else
			System.out.println("Boat: Dest");
		p = p.next;
		while(p.next != null)
		{
			System.out.println("Can: " + start.can_count);
			System.out.println("Mis: " + start.mis_count);
			if(start.boat_pos == 0)
				System.out.println("Boat: Src");
			else
				System.out.println("Boat: Dest");
			p = p.next;
		}
	}
}
