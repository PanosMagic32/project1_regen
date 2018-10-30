# ReGen_Insurance_
Project #1
[![N|Solid](https://media.licdn.com/dms/image/C4D0BAQEU9pNF3SjSyw/company-logo_200_200/0?e=2159024400&v=beta&t=kHh6r4G3f9fW_BODg5295xJ6A-y8qVffcWeJDROsYi8)](https://nodesource.com/products/nsolid)

# Classes:
### Main:  
Στην κλάση Main θα υλοποιείται η προσομοίωση του UI καθώς και οι βασικές λειτουργίες του προγράμματος.

### Owner: 
H κλάση Owner θα αντιπροσωπεύει τους ιδιοκτήτες των αυτοκινήτων της βάσης μας. Τα αντικείμενα τύπου Owner θα περιλαμβανουν ως πεδία τα χαρακτηριστικά του αντίστοιχου πίνακα της βάσης δεδομένων.

### Vehicle: 
H κλάση Vehicle θα αντιπροσωπεύει τα οχήματα της βάσης και τις ιδιότητες αυτών. Όπως η Owner, έτσι και αυτή θα περιλαμβάνει ως πεδία τα χαρακτηριστικά του αντίστοιχου πίνακα της βάσης.

### Insurance: 
H κλάση  Insurance θα αντιπροσωπεύει τις ασφάλειες των οχημάτων. 

### DButils: 
H κλάση DButils θα περιλαμβάνει όλες τις λειτουργίες που αφορούν την σύνδεση και μεταφορά δεδομένων από και προς την βάση.

### VehicleComparator: 
H κλάση VehicleComparator θα χρησιμοποιηθεί στην ταξινόμηση των οχημάτων (κάνοντας implement το interface Comparator). Με την κλάση αυτή, θα «εξηγήσουμε» στο πρόγραμμά μας τον τρόπο με τον οποίο δύο αντικείμενατύπου Vehicle θα πρέπει να συγκρίνονται μεταξύ τους.




# DataBase ER
![Alt text](/Readme IMG/use.case.diagram.png?raw=true "Optional Title")

### DataBase Schema

```sh
drop table if exists owner;
create table owner (
    owner_id int unsigned not null auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    tel varchar(50) not null,
    mail varchar(50) not null,
    address varchar (50) not null,
    adt_number varchar(10) not null,
    primary key(owner_id)
) engine = InnoDB default charset = utf8mb4;
```


```sh
drop table if exists vehicle;
create table vehicle (
    vehicle_id int unsigned not null auto_increment,
    plate varchar(8) not null,
    cc smallint unsigned not null,
    manufactured_year smallint unsigned not null,
    co2emissions varchar(6) not null, #Euro 1 - Euro 6
    owner_id int unsigned not null,
    primary key(vehicle_id),
    foreign key(owner_id) references owner(owner_id)
) engine = InnoDB default charset = utf8mb4;
```


```sh
drop table if exists insurance;
create table insurance(
    insurance_id int unsigned auto_increment,
    exp_date date not null,
    init_date date not null,
    cost decimal(5, 2) not null,
    owner_id int unsigned not null,
    vehicle_id int unsigned not null,
    primary key(insurance_id),
    foreign key(owner_id) references owner(owner_id),
    foreign key(vehicle_id) references vehicle(vehicle_id)
) engine = InnoDB default charset = utf8mb4;
```


# User Stories
•	As a user I want to insert a plate number so that I can find out the vehicle's insurance status.
•	As a user I want to view forecoming expiries so that I can find out the vehicles that are about to expire within a given time frame.
•	As a user I want to view expiries of all vehicles ordered by plate.
•	As a user I want to calculate the total fine cost per owner.
•	As a user I want to be able to export the data into a file or to view them on the console.

# Use case diagram
![Alt text](/Readme IMG/er.png?raw=true "Optional Title")
