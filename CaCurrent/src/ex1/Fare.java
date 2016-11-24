/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import javax.persistence.*;


/**
 *
 * @author x00130277
 */
@Entity
@Table(name = "Fare")
@SuppressWarnings("SerializableClass")
public class Fare {


    @Id
    private int fare_id;
    private int route;
    private double child_Fare;
    private double student_Fare;

    public int getFareID() {
        return fare_id;
    }

    public void setFareID(int fareID) {
        this.fare_id = fareID;
    }
    private double adult_Fare;
    private double oap_Fare;


    @OneToOne
    @PrimaryKeyJoinColumn(name = "route")
    private Route route2;


    public Fare() {
    }


    public Fare(int route_num,double childFare, double studentFare, double adultFare, double oapFare) {
        this.route = route_num;
        this.child_Fare = childFare;
        this.student_Fare = studentFare;
        this.adult_Fare = adultFare;
        this.oap_Fare = oapFare;


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
        return "\n Ticket prices for route: " + route + "\n"
                +"Child ticket : €" + child_Fare + "\n"
                +"Student ticket: €" + student_Fare + "\n"
                +"Adult ticket: €" + adult_Fare + "\n"
                +"OAP Ticket: €" + oap_Fare;
}
}
