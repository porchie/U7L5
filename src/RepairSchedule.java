import java.util.ArrayList;

public class RepairSchedule
{
    /** Each element represents a repair by an individual mechanic in a bay. */
    private ArrayList<CarRepair> schedule;

    /** Number of mechanics available in this schedule. */
    private int numberOfMechanics;

    /** Constructs a RepairSchedule object.
     * Precondition: n >= 0
     */
    public RepairSchedule(int n)
    {
        schedule = new ArrayList<CarRepair>();
        numberOfMechanics = n;
    }

    public ArrayList<CarRepair> getSchedule()
    {
        return schedule;
    }

    /** Attempts to schedule a repair by a given mechanic in a given bay as described in part (a).
     * Precondition: 0 <= m < numberOfMechanics and b >= 0
     */
    public boolean addRepair(int m, int b)
    {
        for(CarRepair s:schedule)
        {
            if(s.getMechanicNum()==m) return false;
            if(s.getBayNum()==b) return false;
        }
        schedule.add(new CarRepair(m,b));
        return true;
    }

    /** Returns an ArrayList containing the mechanic identifiers of all available mechanics,
     * as described in part (b).
     */
    public ArrayList<Integer> availableMechanics()
    {
        ArrayList<Integer> mechs = new ArrayList<>();
        for(int i=0;i<numberOfMechanics;i++)
        {
            mechs.add(i);
        }
        for(int i=0;i<mechs.size();i++)
        {
            if(!isAvaliable(mechs.get(i)))
            {
                mechs.remove(i);
                i--;
            }
        }
        return mechs;
    }

    private boolean isAvaliable(int m)
    {
        for(CarRepair s:schedule)
        {
            if(s.getMechanicNum()==m) return false;
        }
        return true;
    }


    /** Removes an element from schedule when a repair is complete. */
    public void carOut(int b)
    {
        for (int i = 0; i < schedule.size(); i++)
        {
            CarRepair carAtIdx = schedule.get(i);
            if (carAtIdx.getBayNum() == b)
            {
                schedule.remove(i);
            }
        }
    }
}