package myjob;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Recruiter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String password;
	private String orgnizationName;
	private String orgnizationAbout;
	private String orgnizationWebsite;
	private long orgnizationEmployeeCount;
	@OneToMany(cascade = CascadeType.ALL)
	List<Job> jobs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrgnizationName() {
		return orgnizationName;
	}

	public void setOrgnizationName(String orgnizationName) {
		this.orgnizationName = orgnizationName;
	}

	public String getOrgnizationAbout() {
		return orgnizationAbout;
	}

	public void setOrgnizationAbout(String orgnizationAbout) {
		this.orgnizationAbout = orgnizationAbout;
	}

	public String getOrgnizationWebsite() {
		return orgnizationWebsite;
	}

	public void setOrgnizationWebsite(String orgnizationWebsite) {
		this.orgnizationWebsite = orgnizationWebsite;
	}

	public long getOrgnizationEmployeeCount() {
		return orgnizationEmployeeCount;
	}

	public void setOrgnizationEmployeeCount(long orgnizationEmployeeCount) {
		this.orgnizationEmployeeCount = orgnizationEmployeeCount;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Recruiter(String password, String orgnizationName, String orgnizationAbout, String orgnizationWebsite,
			long orgnizationEmployeeCount, List<Job> jobs) {
		super();
		this.password = password;
		this.orgnizationName = orgnizationName;
		this.orgnizationAbout = orgnizationAbout;
		this.orgnizationWebsite = orgnizationWebsite;
		this.orgnizationEmployeeCount = orgnizationEmployeeCount;
		this.jobs = jobs;
	}

	public Recruiter() {
		super();
		// TODO Auto-generated constructor stub
	}

}
