package ex1;

/**
 *
 * @author Shane Cotter X00131736 & Matthew Cleary X00130277
 */
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Bus")
@SuppressWarnings("SerializableClass")
//@SequenceGenerator(name="seq", initialValue=1, allocationSize=50)
public class Bus {

    @Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private int bus_id;
    private int capacity;
    private String bus_type;
    @ManyToMany(mappedBy = "blist")

    private List<Route> rlist = new ArrayList<>();

    public Bus(int bus_id, int capacity, String bus_type) {
        this.bus_id = bus_id;
        this.capacity = capacity;
        this.bus_type = bus_type;
    }

    public Bus() {

    }

    public int getId() {
        return bus_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getBus_type() {
        return bus_type;
    }

    public List<Route> getRlist() {
        return rlist;
    }

    public void setId(int id) {
        this.bus_id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setBus_type(String bus_type) {
        this.bus_type = bus_type;
    }

    public void setRlist(List<Route> rlist) {
        this.rlist = rlist;
    }

    public void addRoute(Route r2) {
        rlist.add(r2);
        r2.getBlist().add(this);
    }

    public void removeRoute(Route r) {
        rlist.remove(r);
        r.getBlist().remove(this);
    }

    public void remove() {
        ArrayList<Route> temp = new ArrayList<>(rlist);
        for (int i = 0; i < temp.size(); i++) {
            removeRoute(temp.get(i));
        }
    }

    @Override
    public String toString() {
        String s = "";
        s += "Bus " + "Id: " + bus_id + ", capactiy: " + capacity + ", Bus Type: " + bus_type;

        return s;
    }
}
