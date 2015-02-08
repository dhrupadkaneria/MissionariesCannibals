import java.util.LinkedList;
import java.util.Queue;


public class Client 
{
	public static void main(String[] args) 
	{
		Queue<State> myQueue = new LinkedList<State>();
		myList path = new myList();
		State cur_state = null;
		int m_mis = 0;
		int m_can = 0;
		State s = new State(3, 3, 0, null, null);
		myQueue.add(s);
		boolean solved = false;
		//for(int j = 0; j < 5; ++j)
		while(!solved || !myQueue.isEmpty())
		{
			System.out.println("Queue size: " + myQueue.size());
			cur_state = myQueue.poll();
			//cur_state.displayState();
			path.insertNode(cur_state);
			path.display();
			State solution = new State(0, 0, 1, null, null);
			solved = solution.isReached();
			for(int i = 0; i < 5; ++i)
			{
				switch(i)
				{
				case 0:
						m_can = 1;
						m_mis = 0;
						break;
				case 1:
						m_can = 0;
						m_mis = 2;
						break;
				case 2:
						m_can = 1;
						m_mis = 1;
						break;
				case 3:
						m_can = 0;
						m_mis = 1;
						break;
				case 4:
						m_can = 2;
						m_mis = 0;
						break;
				}
				if(cur_state.boat_pos == 0) //Subtract the values and move the boat to des
				{
					State new_state = new State(cur_state.can_count-m_can, cur_state.mis_count-m_mis, 1, null, null);
					if(new_state.isValid())
					{	
						//System.out.println("Valid State");
						myQueue.add(new_state);
						//new_state.displayState();
					}
					//else
						//System.out.println("Invalid State");
				}
				else if(cur_state.boat_pos == 1) //Add the values and move the boat to src
				{
					State new_state = new State(cur_state.can_count+m_can, cur_state.mis_count+m_mis, 0, null, null);
					if(new_state.isValid())
					{	
						//System.out.println("Valid State");
						myQueue.add(new_state);
						//new_state.displayState();
					}
					//else
						//System.out.println("Invalid State");
				}
				System.out.println(myQueue.toString());
				//System.out.println();
			}
		}
	}

}
