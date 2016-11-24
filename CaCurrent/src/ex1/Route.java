package ex1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Route")
@SuppressWarnings("SerializableClass")
public class Route {

    @Id
    private int route_num;
    private String first_stop;
    private String last_stop;
    private String journey_time;
    private int num_stops;

//    @OneToOne(mappedBy="rroute")
//    private Timetable timetable;
    @OneToMany(mappedBy = "rroute", cascade = CascadeType.PERSIST)
    private List<Timetable> tlist = new ArrayList<>();

    @OneToOne(mappedBy = "route2")
    private Fare fare;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BusRoute",
            joinColumns = @JoinColumn(name = "RID"),
            inverseJoinColumns = @JoinColumn(name = "BID"))

    private List<Bus> blist = new ArrayList<>();

    public Route() {
    }

    public Route(int route_num, String first_stop, String last_stop, String journey_time, int numStops) {
        this.route_num = route_num;
        this.first_stop = first_stop;
        this.last_stop = last_stop;
        this.journey_time = journey_time;
        this.num_stops = numStops;
    }

    public int getRoute_num() {
        return route_num;
    }

    public String getFirst_stop() {
        return first_stop;
    }

    public String getLast_stop() {
        return last_stop;
    }

    public String getJourney_time() {
        return journey_time;
    }

    public int getNumStops() {
        return num_stops;
    }

    public List<Bus> getBlist() {
        return blist;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public void setJourney_time(String newJtime) {
        this.journey_time = newJtime;
    }

    public void setBlist(List<Bus> blist) {
        this.blist = blist;
    }

    public List<Timetable> getTlist() {
        return tlist;
    }

    public void setTlist(List<Timetable> tlist) {
        this.tlist = tlist;
    }

    public void addTimetable(Timetable t) {
        tlist.add(t);
        t.setRoute(this);
    }

//        public Timetable getTimetable() {
//        return timetable;
//    }
//
//    public void setTimetable(Timetable timetable) 
//    {
//        this.timetable = timetable;
//    }
    public void printBuses() {
        String r = "";
        for (int i = 0; i < blist.size(); i++) {

            System.out.println(blist.get(i).toString());

        }

    }

    @Override
    public String toString() {
        String r = "";
        r += "Route details for Route " + "Number: " + route_num + "\n"
                + "First stop: " + first_stop + "\n"
                + "Last stop : " + last_stop + "\n"
                + "Journey time: " + journey_time + "\n"
                + "Number of stops: " + num_stops + "\n";

        return r;
    }

}
