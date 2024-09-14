package CowStrike;
import java.util.ArrayList;

public class Machine 
{
    public ArrayList<Head> heads = new ArrayList<>();
    public Status machineStatus;
    public Cow cowInMachine;
    public int machineNum;

    public Machine(int num)
    {
        machineStatus = Status.AVALIABLE;
        for(int i = 0; i < 4; i++)
            heads.add(new Head(i));
        machineNum = num;
    }

    public void putCowInMachine(Cow c)
    {
        cowInMachine = c;
        machineStatus = Status.NOTAVALIABLE;
    }

    public void changeToCleaning()
    {
        for (Head h : heads)
            h.changeToCleaning();
    }

    public void changeToReady()
    {
        for (Head h : heads)
            h.changeToReady();
    }

    public void changeToWorking()
    {
        int count = 0;
        for (Head h : heads)
        {
            if (h.headStatus == Status.READY)
                count++;
        }
        if (count == 4)
        {
            for (Head h : heads)
                h.changeToReady();
        }
    }

    public Status checkStatus()
    {
        for (Head h : heads)
        {
            if (h.headStatus != Status.WORKING)
                return Status.NOTDONE;
        }
        return Status.DONE;
    }

    public double yeild()
    {
        if (cowInMachine.like == machineNum)
            return 1.0;
        return 0.5;
    }
}
