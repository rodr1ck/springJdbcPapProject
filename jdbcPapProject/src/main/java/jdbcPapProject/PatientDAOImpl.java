package jdbcPapProject;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import jdbcPapProject.Patient;
import jdbcPapProject.PatientMapper;

public class PatientDAOImpl implements PatientDAO {

	private JdbcTemplate jdbcTemp;
	private SimpleJdbcCall jdbcCall;
	private PlatformTransactionManager platformTransactionManager;
	
	public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
		this.platformTransactionManager = platformTransactionManager;
	}

	public void setJdbcTemp(JdbcTemplate jdbcTemplate) {
		this.jdbcTemp = jdbcTemplate;
		this.jdbcCall = new SimpleJdbcCall(jdbcTemp.getDataSource()).withProcedureName("getRecord1");
	}

	public int create(int idpatient, String rutpatient, String patientName, String patientSurname,
			String patientAddress, String patientMobile, String prevision, String birthDate) {
	
		String query = "insert into patient (idpatient, rutpatient, patientName, patientSurname, patientAddress, patientMobile, prevision, birthDate) values(?,?,?,?,?,?,?,?)";
		return jdbcTemp.update(query, idpatient, rutpatient, patientName, patientSurname, patientAddress, patientMobile, prevision, birthDate); 
	}

	public int update(int idpatient, String patientName) {
		String query = "update patient set patientName=? where idpatient=?";
		return jdbcTemp.update(query, patientName, idpatient);
	}
	
	public int delete(int id) {
		String query = "delete from patient where idpatient=?";
		return jdbcTemp.update(query, id);
	}
	
	public Patient getPatient(int id) {
		String query = "select * from patient where idpatient=?";
		List<Patient> patients = jdbcTemp.query(query, new Object[] {id}, new PatientMapper());
		return patients.get(0);
	}
	
	public List<Patient> listPatients() {
		String query = "select * from patient";
		List<Patient> patients = jdbcTemp.query(query, new PatientMapper());
		return patients;
	}
	
	public Patient getPatientByProcedure(int id) {
		SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
		Map<String, Object> out = jdbcCall.execute(in);
		Patient p = new Patient();
		
		p.setIdpatient(id);
		p.setRutpatient((String)out.get("out_rutpatient"));
		p.setPatientName((String)out.get("out_patientName"));
		p.setPatientSurname((String)out.get("out_patientSurname"));
		p.setPatientAddress((String)out.get("out_patientAddress"));
		p.setPatientMobile((String)out.get("out_patientMobile"));
		p.setPrevision((String)out.get("out_prevision"));
		p.setBirthDate((String)out.get("out_birthDate"));
		
		return p;
	}
	
	public void performMultipleActions(String rutpatient, String patientName, String patientSurname, String patientAddress, String patientMobile, String prevision, String birthDate) {
		System.out.println("Multiple Actions");
		TransactionDefinition td = new DefaultTransactionDefinition();
		TransactionStatus ts = platformTransactionManager.getTransaction(td);
		try {
			String query = "insert into patient (rutpatient, patientName, patientSurname, patientAddress, patientMobile, prevision, birthDate) values(?,?,?,?,?,?,?)";
			int count = jdbcTemp.update(query, rutpatient, patientName, patientSurname, patientAddress, patientMobile, prevision, birthDate);
			System.out.println(count + " records are inserted");
			
			String query2 = "select *from patient where idpatient=(select max(idpatient) from patient)";
			List<Patient> pati = jdbcTemp.query(query2, new PatientMapper());
			System.out.println("New patient is " + pati);
			platformTransactionManager.commit(ts);
			System.out.println("Transaction completed");
			
		} catch(Exception ex) {
			System.out.println("Transaction failed: " + ex);
			platformTransactionManager.rollback(ts);
			System.out.println("Transaction rolledback");
		}
	}
	
}
