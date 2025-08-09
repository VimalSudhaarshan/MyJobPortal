package myjob;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

//import com.mysql.cj.Query;

public class MyDAO {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("abc");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public static void recuiterSignup(Recruiter recruiter) {
		et.begin();
		em.persist(recruiter);
		et.commit();
	}

	public static Recruiter Recruiterlogin(String email, String password) {
		Query query = em.createQuery("Select re from Recruiter re where re.email=?");
		query.setParameter(1, email);
		Recruiter recruiter = (Recruiter) query.getSingleResult();
		if (recruiter != null && recruiter.getPassword().equals(password)) {
			return recruiter;
		}
		return null;
	}

	public static void createJob(int recruiterId, Job job) {
		Recruiter recruiter = em.find(Recruiter.class, recruiterId);
		if (recruiter.getJobs() == null) {
			List<Job> jobs = new ArrayList<Job>();
			jobs.add(job);
		} else {
			recruiter.getJobs().add(job);
		}
		et.begin();
		em.merge(recruiter);
		et.commit();
	}

	public List<Job> findJobByJobId(int recuiterId) {
		List<Job> jobs = em.find(Recruiter.class, recuiterId).getJobs();
		return jobs;
	}

	public static void updateJob(Job job) {
		et.begin();
		em.merge(job);
		et.commit();
	}

	public static void ApplicantSignup(Applicant applicant) {
		et.begin();
		em.persist(applicant);
		et.commit();
	}

	public static Applicant Applicantlogin(String email, String password) {
		Query query = (Query) em.createQuery("Select ap from Application ap where ap.email=?");
		query.setParameter(1, email);
		Applicant applicant = (Applicant) query.getSingleResult();
		if (applicant != null && applicant.getPassword().equals(password)) {
			return applicant;
		}
		return null;
	}

	public static void applicationJobApply(int applicantId, int jobId) {
		Applicant ap = em.find(Applicant.class, applicantId);
		Job job = em.find(Job.class, jobId);
		LocalDate date = LocalDate.now();
		String stringdate = String.valueOf(date);
		Application application = new Application(applicantId, "pending", stringdate, job.getDesignation(),
				job.getSalary(), job.getExperience(), job.getLocation(), job.getSkill());
		ap.getApplications().add(application);
		job.getApplications().add(application);

		et.begin();
		em.merge(ap);
		em.merge(job);
		et.commit();
	}
	
	public static List<Application> viewApplicationByApplicantId(int applicationId){
		return em.find(Applicant.class,applicationId).getApplications();
	}
	
	public static List<Application> viewApplicationByJobId(int jobId){
		return em.find(Job.class, jobId).getApplications();
	}

}
