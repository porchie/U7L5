import java.util.ArrayList;
public class Search
{
    public static int linearSearchArrayList(ArrayList<Integer> elements, int target)
    {
        for(int i = 0;i<elements.size();i++)
        {
            if(elements.get(i)==target) return i;
        }
        return -1;
    }

    public static int linearSearch(String[] elements, String target)
    {
        for(int i = 0;i<elements.length;i++)
        {
            if(elements[i].equals(target)) return i;
        }
        return -1;
    }
}
