package myjob;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Applicant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String city;
	private long Contact;
	private String email;
	private String password;
	private String primarySkill;

	@OneToMany(cascade = CascadeType.ALL)
	List<Application> applications;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getContact() {
		return Contact;
	}

	public void setContact(long contact) {
		Contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Applicant(String name, String city, long contact, String email, String password, String primarySkill,
			List<Application> applications) {
		super();
		this.name = name;
		this.city = city;
		Contact = contact;
		this.email = email;
		this.password = password;
		this.primarySkill = primarySkill;
		this.applications = applications;
	}

	public Applicant() {
		super();
		// TODO Auto-generated constructor stub
	}

}
