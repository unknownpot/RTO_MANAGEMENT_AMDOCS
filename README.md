# RTO_management
Software needed :
1. JDK 8
2. Netbeans 18
3. mysql-connector-j-8.1.0.jar
4. jcalendar-1.4.jar
5. MySql Workbench

 

# DATABASE STRUCTURE

 

create database rto;
use rto;

 

create table login(name varchar(20),username varchar(12),
password varchar(20),dob varchar(10),phone varchar(10),user varchar(10));
describe login;
select * from login;
create table Customer(name varchar(20),addr varchar(50), number varchar(10),vehicleno varchar(10),type varchar(10),model varchar(10),chasis varchar(20));
select * from Customer;
create table license(name varchar(20),phone varchar(11),type varchar(10),dob varchar(12),state varchar(20));
select * from license;

 

Launch project from NETBEANS 18 compiler a splash screen will be displayed and application will run.
*** UPDATE YOUR MYSQL PASSWORD IN CONN.JAVA FILE***
Role based login allows login as an admin or a user

 

# User View functionalities
1. Signup and Login
2. Registering new vehicle
3. vehicle lookup
4. Update Info
5. Apply for license

 

# Admin view functionalities
1. Signup and login
2. Approving or deleting registration applications
3. Detailed vehicle lookup
4. License application lookup and printing.
