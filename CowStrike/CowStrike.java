package CowStrike;
import java.util.*;

public class CowStrike 
{
    int milk;
    public void working(CowQueue cowList, ArrayList<Machine> machines)
    {
        int count = 0;
        CowQueue workingCows = new CowQueue();
        while(count < 10)
        {
            if (machines.get(cowList.peek().like - 1).machineStatus == Status.AVALIABLE)
            {
                workingCows.enqueue(cowList.peek());
                machines.get(cowList.peek().like - 1).putCowInMachine(cowList.dequeue());
            }
            else
            {
                int check1 = 0;
                for(Machine m : machines)
                {
                    if (m.machineStatus == Status.AVALIABLE)
                    check1 = 1;
                }
                if (check1 == 0)
                {
                    collect(machines);
                    break;
                }
                boolean found = false;
                int i = cowList.peek().like;
                while (!found)
                {
                    if (i > 9)
                        i = 0;
                    if (machines.get(i).machineStatus != Status.AVALIABLE)
                    {    
                        i++;
                    }
                    else
                    {
                        workingCows.enqueue(cowList.peek());
                        machines.get(i).putCowInMachine(cowList.dequeue());
                        found = true;
                    }
                }
            }
            if (isStop(machines))
            {
                cowList = reQueue(workingCows, cowList);
            }
            count++;

        }
        collect(machines);
    }

    public void collect(ArrayList<Machine> machines)
    {
        milk = 0;
        for (Machine m : machines)
        {
            if (m.checkStatus() == Status.DONE)
            {
                milk += m.yeild();
                m.machineStatus = Status.AVALIABLE;
            }
        }
    }

    public void stop(ArrayList<Machine> machines)
    {
        for (Machine m : machines)
            m.machineStatus = Status.STOP;
    }

    public boolean isStop(ArrayList<Machine> machines)
    {
        for (Machine m : machines)
            if (m.machineStatus != Status.STOP)
                return false;
        return true;
    }

    public CowQueue reQueue(CowQueue workingcows, CowQueue cowList)
    {
        for (Cow c : cowList.cowList)
            workingcows.enqueue(c);
        return workingcows;
    }

    public int getMilk()
    {
        return milk;
    }
}
