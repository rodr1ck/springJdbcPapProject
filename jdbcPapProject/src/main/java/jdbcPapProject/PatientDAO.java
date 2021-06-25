package jdbcPapProject;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbcPapProject.Patient;

public interface PatientDAO {

		public void setJdbcTemp(JdbcTemplate jdbcTemplate);
		public int create(int idpatient, String rutpatient, String patientName, String patientSurname, String patientAddress, String patientMobile, String prevision, String birthDate);
		public int delete(int id);
		public int update(int patientid, String patientName);
		public Patient getPatient(int id);
		public List<Patient> listPatients();

}
