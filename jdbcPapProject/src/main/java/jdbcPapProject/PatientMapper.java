package jdbcPapProject;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbcPapProject.Patient;

public class PatientMapper implements RowMapper<Patient> {

	public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
		Patient p = new Patient();
		p.setIdpatient(rs.getInt("idpatient"));
		p.setRutpatient(rs.getString("rutpatient"));
		p.setPatientName(rs.getString("patientName"));
		p.setPatientSurname(rs.getString("patientSurname"));
		p.setPatientAddress(rs.getString("patientAddress"));
		p.setPatientMobile(rs.getString("patientMobile"));
		p.setPrevision(rs.getString("prevision"));
		p.setBirthDate(rs.getString("birthDate"));
		return p;
		
	}

}
