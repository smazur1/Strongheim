package customcode;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.DBUtil;
import model.Studentgrade;

public class ProcessStudentGrades {

	public static List<Studentgrade> getStudentGradeByID(int _studentid) {
		//
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select s from Studentgrade s where s.studentid = :studentid";
		TypedQuery<Studentgrade> q = em.createQuery(qString, model.Studentgrade.class);
		q.setParameter("studentid", _studentid);
		Studentgrade st = null;
		List<Studentgrade> students = null;

		try {

			students = q.getResultList();
			if (students == null || students.isEmpty())
				students = null;

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			em.close();
			System.out.println("Finished");
			return students;
		}

	}

	public static List<Studentgrade> getStudentGradeByType(String _type) {
		//
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select s from Studentgrade s where s.type = :type";
		TypedQuery<Studentgrade> q = em.createQuery(qString, model.Studentgrade.class);
		q.setParameter("type", _type);
		// Studentgrade st = null;
		List<Studentgrade> students = null;

		try {

			students = q.getResultList();
			if (students == null || students.isEmpty())
				students = null;

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			em.close();
			System.out.println("Finished");
			return students;
		}

	}

	public static List<Studentgrade> getStudentGradeByIDAndType(int _studentid, String _type) {
		//
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		String qString = "Select s from Studentgrade s where" + " s.studentid = :studentid and s.type = :type";
		TypedQuery<Studentgrade> q = em.createQuery(qString, model.Studentgrade.class);
		q.setParameter("studentid", _studentid);
		q.setParameter("type", _type);
		Studentgrade st = null;
		List<Studentgrade> students = null;

		try {

			students = q.getResultList();
			if (students == null || students.isEmpty())
				students = null;

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			em.close();
			System.out.println("Finished");
			return students;
		}

	}

	public static String getAverageByID(int _studentid) {
		//
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select AVG(s.grade) from Studentgrade s  where s.studentid = :studentid";
		TypedQuery q = em.createQuery(qString, model.Studentgrade.class);
		q.setParameter("studentid", _studentid);
		Studentgrade st = null;
		String average = "";

		try {

			average = q.getSingleResult().toString();

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			em.close();
			System.out.println("Finished");
			return average;
		}
	}

	public static String getAverageByIDAndType(int _studentid, String _type) {
		//
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select AVG(s.grade) from Studentgrade s  where"
				+ " s.studentid = :studentid and s.type = :type";
		TypedQuery q = em.createQuery(qString, model.Studentgrade.class);
		q.setParameter("studentid", _studentid);
		q.setParameter("type", _type);

		String average = "";

		try {

			average = q.getSingleResult().toString();

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			em.close();
			System.out.println("Finished");
			return average;
		}
	}

	public static String getMaxMinByType(String _type) {
		//
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select MAX(s.grade) from Studentgrade s  where s.type = :type";
		TypedQuery q = em.createQuery(qString, model.Studentgrade.class);

		q.setParameter("type", _type);

		String maxmin = "";
		String max = "";
		String min = "";

		try {

			max = q.getSingleResult().toString();

			qString = "Select MIN(s.grade) from Studentgrade s  where s.type = :type";
			TypedQuery nq = em.createQuery(qString, model.Studentgrade.class);

			nq.setParameter("type", _type);
			
			min = nq.getSingleResult().toString();
			maxmin = max + "," + min;
		} catch (Exception e) {
			System.out.println(e);
		} finally {

			em.close();
			System.out.println("maxmin " + maxmin);
			return maxmin;
		}
	}

}
