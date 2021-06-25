package jdbcPapProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml"); 
	PatientDAOImpl impl = ctx.getBean("patientDao", PatientDAOImpl.class);
	//System.out.println(impl.create(2, "14053369-3", "Slodan", "Mitrovic", "Inca 389", "989824516", "FONASA", "1981-12-06")+ " row");
	//System.out.println(impl.create(3, "19053369-6", "Carlos", "Rodriguez", "Av. Libertador 101", "989856451", "FONASA", "1991-07-06")+ " row");
	//System.out.println(impl.update(1, "George")+ "rows updated");
	 //System.out.println(impl.delete(2)+ "rows deleted");
	//System.out.println(impl.getPatient(3));
	System.out.println(impl.listPatients());
	//System.out.println(impl.getPatientByProcedure(3));
	//impl.performMultipleActions("160565922","Daniel", "Gonzalez", "Las Rejas 21", "999456987", "ISAPRE", "1995-09-09");
	
	}
	
}
