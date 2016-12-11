package client;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import introsde.document.ws.PeopleService;
import introsde.document.ws.PersonBean;
import introsde.document.ws.PersonBean2;
import utils.RandomData;
import introsde.document.ws.MeasureBean;
import introsde.document.ws.People;

public class PeopleClient {
	private static FileWriter writer = null;

	private static void write(String line) {
		try {
			System.out.println(line);
			writer.append(line + " \n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		writer = new FileWriter("client-server.log");
		try {
			PeopleService service = new PeopleService();
			People people = service.getPeopleImplPort();

			/*
			 * Create database.
			 */
			write("Method #0: createDatabase()");
			write(people.createDatabase());
			write(" \n -------------");

			/*
			 * Method #1: readPersonList() => List | should list all the people
			 * in the database (see below Person model to know what data to
			 * return here) in your database
			 */
			write("Method #1: readPersonList()");
			List<PersonBean> pbs = people.readPersonList();
			PersonBean testPerson = pbs.get(1);
			for (int i = 0; i < pbs.size(); i++) {
				write(pbs.get(i).toString());
			}
			write(" \n -------------");

			/*
			 * Method #2: readPerson(Long id) => Person | should give all the
			 * Personal information plus current measures of one Person
			 * identified by {id} (e.g., current measures means current
			 * healthProfile)
			 */
			write("Method #2: readPerson(Long id)");
			PersonBean2 pb2 = people.readPerson(1);
			write(pb2.toString());
			write(" \n -------------");

			/*
			 * Method #3: updatePerson(Person p) => Person | should update the
			 * Personal information of the Person identified by {id} (e.g., only
			 * the Person's information, not the measures of the health profile)
			 */
			write("Method #3: updatePerson(Person p)");
			RandomData rd = new RandomData();
			String newFirstname = "Updated at " + rd.getDateTime();
			testPerson.setFirstname(newFirstname);
			write(people.readPerson(people.updatePerson(testPerson)).toString());
			write(" \n -------------");

			/*
			 * Method #4: createPerson(Person p) => Person | should create a new
			 * Person and return the newly created Person with its assigned id
			 * (if a health profile is included, create also those measurements
			 * for the new Person).
			 */
			write("Method #4: createPerson(Person p)");
			PersonBean pb = new PersonBean();
			pb.setBirthday(rd.getRandomBirthdate());
			pb.setFirstname(rd.getRandomFirstName());
			pb.setLastname(rd.getRandomLastName());
			pb.setPersonId(Long.valueOf(0));
			pb = people.createPerson(pb);
			write(pb.toString());
			write(" \n -------------");

			/*
			 * Method #5: deletePerson(Long id) should delete the Person
			 * identified by {id} from the system
			 */
			write("Method #5: deletePerson(Long id)");
			write(String.valueOf(people.deletePerson(pb.getPersonId().intValue())));
			write(" \n -------------");

			/*
			 * Method #6: readPersonHistory(Long id, String measureType) => List
			 * should return the list of values (the history) of {measureType}
			 * (e.g. weight) for Person identified by {id}
			 */
			write("Method #6: readPersonHistory(Long id, String measureType)");
			List<MeasureBean> mbs = people.readPersonHistory(Long.valueOf(testPerson.getPersonId()), "weight");
			Long testMeasureId = mbs.get(0).getMid();
			for (MeasureBean mb : mbs) {
				write(mb.toString());
			}
			write(" \n -------------");

			/*
			 * Method #7: readMeasureTypes() => List should return the list of
			 * measures
			 */
			write("Method #7: readMeasureTypes()");
			List<String> measureTypes = people.readMeasureTypes();
			for (String measureType : measureTypes) {
				write(measureType);
			}
			write(" \n -------------");

			/*
			 * Method #8: readPersonMeasure(Long id, String measureType, Long
			 * mid) => Measure should return the value of {measureType} (e.g.
			 * weight) identified by {mid} for Person identified by {id}
			 */
			write("Method #8: readPersonMeasure(Long id, String measureType, Long mid)");
			MeasureBean mb = people.readPersonMeasure(testPerson.getPersonId(), "weight", testMeasureId);
			write(mb.toString());
			write(" \n -------------");

			/*
			 * Method #9: savePersonMeasure(Long id, Measure m) =>should save a
			 * new measure object {m} (e.g. weight) of Person identified by {id}
			 * and archive the old value in the history
			 */
			write("Method #9: savePersonMeasure(Long id, Measure m)");
			MeasureBean testMeasureBean = new MeasureBean();
			testMeasureBean.setDateRegistered(rd.getDateTime());
			testMeasureBean.setMeasureType("weight");
			testMeasureBean.setMeasureValue(String.valueOf(rd.getRandomWeight()));
			testMeasureBean.setMeasureValueType("double");
			testMeasureBean.setMid(Long.valueOf(0));
			testMeasureBean = people.savePersonMeasure(testPerson.getPersonId(), testMeasureBean);
			write(testMeasureBean.toString());
			write(" \n -------------");

			/*
			 * Method #10: updatePersonMeasure(Long id, Measure m) => Measure |
			 * should update the measure identified with {m.mid}, related to the
			 * Person identified by {id}
			 */
			write("Method #10: updatePersonMeasure(Long id, Measure m)");
			testMeasureBean.setMeasureValue(String.valueOf(rd.getRandomWeight()));
			testMeasureBean = people.updatePersonMeasure(testPerson.getPersonId(), testMeasureBean);
			write(testMeasureBean.toString());
			write(" \n -------------");
		} finally {
			writer.flush();
			writer.close();
		}
	}
}
