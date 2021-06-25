package jdbcPapProject;

public class Patient {
	
	private int idpatient;
	private String rutpatient;
	private String patientName;
	private String patientSurname;
	private String patientAddress;
	private String patientMobile;
	private String prevision;
	private String birthDate;
	
	public int getIdpatient() {
		return idpatient;
	}
	public void setIdpatient(int idpatient) {
		this.idpatient = idpatient;
	}
	public String getRutpatient() {
		return rutpatient;
	}
	public void setRutpatient(String rutpatient) {
		this.rutpatient = rutpatient;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientSurname() {
		return patientSurname;
	}
	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientMobile() {
		return patientMobile;
	}
	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}
	public String getPrevision() {
		return prevision;
	}
	public void setPrevision(String prevision) {
		this.prevision = prevision;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "Patient [idpatient=" + idpatient + ", rutpatient=" + rutpatient + ", patientName=" + patientName
				+ ", patientSurname=" + patientSurname + ", patientAddress=" + patientAddress + ", patientMobile="
				+ patientMobile + ", prevision=" + prevision + ", birthDate=" + birthDate + "]";
	}
	
	
}
