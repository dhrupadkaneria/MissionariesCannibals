import java.util.LinkedList;
import java.util.Queue;
public class MissCann 
{
	static Queue<state> myqueue = new LinkedList<state>();
	public static void main(String[] args) 
	{
        state root = new state(3, 3, 1, 1);    // root node or the first node
        myqueue.add(root);  // this has to be added 
        while(!myqueue.isEmpty()) // if the value is empty
        {  
            state current = myqueue.remove();  // value is removed 
            if(current.checkFinal()) // checking if its the last state
            {  
            	current.display();  
                System.out.println();
                break; 
            } 
            else 
            {  
            	int m_can = 0;
            	int m_mis = 0;
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
        			if(current.boat == 1) //boat moves from src to dest
        			{
        				state new_state = new state(current.miss-m_mis, current.cann-m_can, 0, current, current.depth + 1);
        				if(current.isValid())
        				{
        					myqueue.add(new_state);
        				}
        			}
        			else // boat moves from dest to src
        			{
        				state new_state = new state(current.miss+m_mis, current.cann+m_can, 1, current, current.depth + 1);
        				if(current.isValid())
        				{
        					myqueue.add(new_state);
        				}
        			}
        		}
            }  
        }
	}	
}
