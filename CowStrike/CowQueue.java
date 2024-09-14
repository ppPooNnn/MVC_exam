package CowStrike;
import java.util.ArrayList;

public class CowQueue {
    public ArrayList<Cow> cowList;

    public CowQueue()
    {
        cowList = new ArrayList<>();
    }

    public void enqueue(Cow c)
    {
        cowList.add(c);
    }

    public Cow dequeue()
    {
        if (cowList.isEmpty())
            return null;
        return cowList.remove(0);
    }

    public Cow peek()
    {
        if (cowList.isEmpty())
            return null;
        return cowList.get(0);
    }

    public int size()
    {
        return cowList.size();
    }

    public void display()
    {
        for(Cow c : cowList)
            System.out.println(c);
    }
}
