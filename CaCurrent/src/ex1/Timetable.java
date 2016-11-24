/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import javax.persistence.*;

@Entity
@Table(name = "Timetable")
@SuppressWarnings("SerializableClass")
public class Timetable {
    
    @Id
    private int timetable_id;
    
    private int route;
    private String timetable_type;
    private String first_journey;
    private String last_journey;
    private String frequency;
    
//    @OneToOne
//    @PrimaryKeyJoinColumn(name = "route")

 
    
    
    @ManyToOne()
    @PrimaryKeyJoinColumn(name = "route")
    private Route rroute;
    
    

    public Timetable() {
    }

    public Timetable(int timetable_id, int route_num, String timetable_type, String first_journey, String last_journey, String frequency) {
        this.timetable_id = timetable_id;
        this.route = route_num;
        this.timetable_type = timetable_type;
        this.first_journey = first_journey;
        this.last_journey = last_journey;
        this.frequency = frequency;
    }

    public int getTimetable_id() {
        return timetable_id;
    }

    public int getRoute_num() {
        return route;
    }
    
    public String getTimetable_type() {
        return timetable_type;
    }

    public String getFirst_journey() {
        return first_journey;
    }

    public String getLast_journey() {
        return last_journey;
    }

    public String getFrequency() {
        return frequency;
    }

    public Route getRroute() {
        return rroute;
    }

    public void setTimetable_id(int timetable_id) {
        this.timetable_id = timetable_id;
    }

    public void setRoute_num(int route_num) {
        this.route = route_num;
    }
    
    public void setTimetable_type(String timetable_type) {
        this.timetable_type = timetable_type;
    }

    public void setFirst_journey(String first_journey) {
        this.first_journey = first_journey;
    }

    public void setLast_journey(String last_journey) {
        this.last_journey = last_journey;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public void setRoute(Route route) {
        this.rroute = route;
    }

    @Override
    public String toString() {
        return "\n" + timetable_type +" Timetable for Route number: " + route + "\n"
                +"First bus leaves at: " + first_journey + "\n"
                +"Last bus leaves at: " + last_journey + "\n"
                +"Bus Frequency: " + frequency + "\n";
    }
    
    
}
