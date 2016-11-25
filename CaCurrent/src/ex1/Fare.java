package ex1;

/**
 *
 * @author Shane Cotter X00131736 & Matthew Cleary X00130277
 */
import javax.persistence.*;

@Entity
@Table(name = "Fare")
@SuppressWarnings("SerializableClass")
@SequenceGenerator(name = "fare_seq", initialValue = 50, allocationSize = 50)
public class Fare {

    @SequenceGenerator(name = "Fare_Gen", sequenceName = "Fare_Seq")
    @Id
    @GeneratedValue(generator = "Fare_Gen")
    private int fare_id;
    private int route;
    private double child_Fare;
    private double student_Fare;
    private double adult_Fare;
    private double oap_Fare;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "route")
    private Route route2;

    public Fare() {
    }

    public Fare(int route_num, double childFare, double studentFare, double adultFare, double oapFare) {
        this.route = route_num;
        this.child_Fare = childFare;
        this.student_Fare = studentFare;
        this.adult_Fare = adultFare;
        this.oap_Fare = oapFare;

    }

    public int getFareID() {
        return fare_id;
    }

    public void setFareID(int fareID) {
        this.fare_id = fareID;
    }

    public int getRouteNum() {
        return route;
    }

    public void setRouteNum(int route_Num) {
        this.route = route_Num;
    }

    public double getChildFare() {
        return child_Fare;
    }

    public void setChildFare(double childFare) {
        this.child_Fare = childFare;
    }

    public double getStudentFare() {
        return student_Fare;
    }

    public void setStudentFare(double studentFare) {
        this.student_Fare = studentFare;
    }

    public double getAdultFare() {
        return adult_Fare;
    }

    public void setAdultFare(double adultFare) {
        this.adult_Fare = adultFare;
    }

    public double getOapFare() {
        return oap_Fare;
    }

    public void setOapFare(double oapFare) {
        this.oap_Fare = oapFare;
    }

    public Route getRoute() {
        return route2;
    }

    public void setRoute(Route route) {
        this.route2 = route;
    }

    @Override
    public String toString() {
        return "\n" + "Fare id:" + fare_id + "\n" + "Ticket prices for route: " + route + "\n"
                + "Child ticket : €" + child_Fare + "\n"
                + "Student ticket: €" + student_Fare + "\n"
                + "Adult ticket: €" + adult_Fare + "\n"
                + "OAP Ticket: €" + oap_Fare;
    }
}
