# ReGen_Insurance_
Project #1
![regeneration.gr](https://image.ibb.co/ftrsSf/logo-1.png)
![code.hub](https://www.codehub.gr/wp-content/uploads/2018/01/cropped-CodeHub-logo_320x132.png)

# Classes:
### Main:  
Στην κλάση Main θα υλοποιείται η προσομοίωση του UI καθώς και οι βασικές λειτουργίες του προγράμματος.

### Owner: 
H κλάση Owner θα αντιπροσωπεύει τους ιδιοκτήτες των αυτοκινήτων της βάσης μας. Τα αντικείμενα τύπου Owner θα περιλαμβανουν ως πεδία τα χαρακτηριστικά του αντίστοιχου πίνακα της βάσης δεδομένων.

### Vehicle: 
H κλάση Vehicle θα αντιπροσωπεύει τα οχήματα της βάσης και τις ιδιότητες αυτών. Όπως η Owner, έτσι και αυτή θα περιλαμβάνει ως πεδία τα χαρακτηριστικά του αντίστοιχου πίνακα της βάσης.

### DButils: 
H κλάση DButils θα περιλαμβάνει όλες τις λειτουργίες που αφορούν την σύνδεση και την αποσύνδεση της βάσης.

### VehicleComparator: 
H κλάση VehicleComparator θα χρησιμοποιηθεί στην ταξινόμηση των οχημάτων (κάνοντας implement το interface Comparator). Με την κλάση αυτή, θα «εξηγήσουμε» στο πρόγραμμά μας τον τρόπο με τον οποίο δύο αντικείμενατύπου Vehicle θα πρέπει να συγκρίνονται μεταξύ τους.

### PropertiesReader: 
H κλάση PropertiesReader θα χρησιμοποιηθεί για την ανάγνωση των στοιχείων σύνδεσης στην βάση δεδομένων της εφαρμογής, τα οποία για λόγους ασφαλείας θα βρίσκονται τοπικά, και όχι στο παρόν repository του github.

### UserInputReader
Η κλάση UserInputReader θα χρησιμοποιηθεί για την ανάγνωση των επιλογών που εισάγει ο χρήστης για τις λειτουργίες του προγράμματος.

### Printer
Η κλάση Printer θα εκτυπώνει τις ανάλογες εξόδους του προγράμματος (σε κονσόλα ή σε αρχείο).

### Menu
Η κλάση Menu θα τυπώνει στην κονσόλα το αρχικό μενού επιλογών και το μενού επιλογής της εμφάνισης των αποτελεσμάτων (κοσνόλα ή αρχείο).

### DBtableGetter
Η κλάση DBtableGetter θα συνδέεται στη βάση (μέσω της DButils) όπου θα καταχωρεί τα στοιχεία των πινάκων Owner και Vehicle σε δύο λίστες, αντίστοιχα και στην συνέχεια θα επιστρέφει μία λίστα που θα έχει συγχωνευμένα τα Vehicles ανά Owner.

###Team4Exception
Η κλάση Team4Exception, σε περίπτωση σφάλματος, εμφανίζει μήνυμα σφάλματος στην κονσόλα και καταγράφει το σφάλμα σε ένα αρχείο log.

# DataBase ER
![ER](https://image.ibb.co/eijwnf/er.png)

### DataBase Schema

```sh
create database regen_ins char set utf8mb4 collate utf8mb4_unicode_ci;
use regen_ins;
```


```sh
drop table if exists owner;
create table owner(
	oid int unsigned not null auto_increment,
	fname varchar(50) not null,
	lname varchar(50) not null,
	primary key (oid)
) engine=InnoDB default charset=utf8mb4;
```


```sh
drop table if exists vehicle;
create table vehicle(
	vid int unsigned not null auto_increment,
	plate varchar(8) not null,
	ins_exp_date date not null,
	oid int unsigned not null,
        primary key(vid),
	foreign key(oid) references owner(oid)
) engine=InnoDB default charset=utf8mb4;
```


# User Stories
•	As a user I want to insert a plate number so that I can find out the vehicle's insurance status.
•	As a user I want to view forecoming expiries so that I can find out the vehicles that are about to expire within a given time frame.
•	As a user I want to view expiries of all vehicles ordered by plate.
•	As a user I want to calculate the total fine cost per owner.
•	As a user I want to be able to export the data into a file or to view them on the console.

# Use case diagram
![ER](https://image.ibb.co/jKJNSf/use-case-diagram.png)
