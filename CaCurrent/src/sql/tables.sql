DROP TABLE BusRoute;
DROP TABLE Fare;
DROP TABLE Timetable;
DROP TABLE Route;
DROP TABLE Bus;

Create Table Bus (
Bus_id number not null,
capacity number,
bus_type varchar2(255),
Primary Key (bus_id)
);

Create Table Route (
Route_Num number not null,
First_Stop varchar2(255),
Last_Stop varchar2(255),
Journey_Time varchar2(255),
Num_Stops number,
Primary Key (Route_Num)
);

Create Table Timetable (
timetable_id number not null,
Route number not null, 
Timetable_type varchar2(255),
First_Journey varchar2(255),
Last_Journey varchar2(255),
Frequency varchar2(255),
Primary Key (timetable_id),
Foreign Key (Route) References Route(route_num) On Delete Cascade
);

CREATE TABLE Fare(
fare_id NUMBER NOT NULL,
route NUMBER NOT NULL,
Child_Fare NUMBER,
Student_Fare NUMBER,
Adult_Fare NUMBER,
OAP_Fare NUMBER,
Primary Key(fare_id),
FOREIGN KEY(route) REFERENCES Route(Route_num) ON DELETE CASCADE
);

CREATE TABLE BusRoute(
BID NUMBER NOT NULL,
RID NUMBER NOT NULL,
PRIMARY KEY (BID,RID),
FOREIGN KEY (RID) REFERENCES Route(Route_num) ON DELETE SET NULL,
FOREIGN KEY (BID) REFERENCES Bus(Bus_id) ON DELETE SET NULL
);

DROP SEQUENCE fare_seq;

create sequence fare_seq increment by 50 start with 50;

