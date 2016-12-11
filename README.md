Assignment 03: SOAP Web Services

**Introduction to Service Design and Engineering | University of Trento |** 

**Name:** DUC MANH HOANG (worked alone)
**ID No.:** MAT.180387

**Description:**

In this assignment is implemented a server and a client calling this server. 
The server was deployed on Heroku **https://assignment03.herokuapp.com/ws/people?wsdl**.
Instead the client was implemented to call Heroku server. 




**Code:**


* **client** Contain the main class that is SOAP XML Client.
* **introsde.document.ws** Generated stub file supported for calling SOAP Server by doing command **wsimport**.
* **utils** Contains the supporting functionalities to generate data.






**Tasks Client:**


* **Request of Method#1:** readPersonList() => List | should list all the people in the database (see below Person model to know what data to return here) in your database
* **Request of Method#2:** readPerson(Long id) => Person | should give all the Personal information plus current measures of one Person identified by {id} (e.g., current measures means current healthProfile)
* **Request of Method#3:** updatePerson(Person p) => Person | should update the Personal information of the Person identified by {id} (e.g., only the Person's information, not the measures of the health profile)
* **Request of Method#4:** createPerson(Person p) => Person | should create a new Person and return the newly created Person with its assigned id (if a health profile is included, create also those measurements for the new Person).
* **Request of Method#5:** deletePerson(Long id) should delete the Person identified by {id} from the system
* **Request of Method#6:** readPersonHistory(Long id, String measureType) => List should return the list of values (the history) of {measureType} (e.g. weight) for Person identified by {id}
* **Request of Method#7:** readMeasureTypes() => List should return the list of measures
* **Request of Method#8:** readPersonMeasure(Long id, String measureType, Long mid) => Measure should return the value of {measureType} (e.g. weight) identified by {mid} for Person identified by {id}
* **Request of Method#9:** savePersonMeasure(Long id, Measure m) =>should save a new measure object {m} (e.g. weight) of Person identified by {id} and archive the old value in the history
* **Request of Method#10:** updatePersonMeasure(Long id, Measure m) => Measure | should update the measure identified with {m.mid}, related to the Person identified by {id}




**How to run:**

Running the project requires java and ant.

Ant source file build.xml is annotated. 
* Main target is: 
* **execute.client:** To start task valuation.





**References:**

https://sites.google.com/a/unitn.it/introsde_2016-17/lab-sessions/assignments/assignment-3

