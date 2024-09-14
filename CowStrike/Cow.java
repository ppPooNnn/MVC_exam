package CowStrike;
import java.util.*;

public class Cow
{
    public int udder;
    public int sex; // 0 for male, 1 for female
    public int like;

    public Cow()
    {
        Random r = new Random();
        int percen = r.nextInt(1, 101);
        like = r.nextInt(1, 11);
        if (percen <= 95)
        {
            udder = 4;
            sex = 1;
        }
        else
        {
            percen = r.nextInt(100);
            if (percen > 50)
            {
                sex = 0;
                udder = 0;
            }
            else 
            {
                sex = 1;
                percen = r.nextInt(100);
                if(percen > 50)
                    udder = r.nextInt(0, 3);
                else
                    udder = r.nextInt(5, 20);
            }
        }
    }

    @Override
    public String toString() {
        return "Cow [udder=" + udder + ", sex=" + ((sex == 0) ? " m " : " f ") + ", like= " + like + "]";
    }
}
