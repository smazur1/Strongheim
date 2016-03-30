package customcode;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DBUtil;
import model.Studentgrade;

/**
 * Servlet implementation class StudentGradeName
 */
@WebServlet("/StudentGradeName")
public class StudentGradeName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentGradeName() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		if (request.getParameter("option").equals("1")) {
			int studentid = Integer.parseInt(request.getParameter("studentid"));
			List<Studentgrade> students = null;

			students = ProcessStudentGrades.getStudentGradeByID(studentid);
				
			session.setAttribute("assignments", students);
			request.getRequestDispatcher("/output.jsp").forward(request, response);
	

		} else if (request.getParameter("option").equals("2")) {
			
			String type = request.getParameter("type");

			//		Studentgrade st = null;
					List<Studentgrade> students = null;

					students = ProcessStudentGrades.getStudentGradeByType(type);
					//
					
					session.setAttribute("assignments", students);
					request.getRequestDispatcher("/output.jsp").forward(request, response);
					
		} else if (request.getParameter("option").equals("3")) {
			
			int studentid = Integer.parseInt(request.getParameter("studentid"));
			String type = request.getParameter("type");
			List<Studentgrade> students = null;

			students = ProcessStudentGrades.getStudentGradeByIDAndType(studentid, type);
				
			session.setAttribute("assignments", students);
			request.getRequestDispatcher("/output.jsp").forward(request, response);
			
		} else if (request.getParameter("option").equals("4")) {
			
			int studentid = Integer.parseInt(request.getParameter("studentid"));
			List<Studentgrade> students = null;
			

			String avg = ProcessStudentGrades.getAverageByID(studentid);
				
			session.setAttribute("studentid",studentid);
			session.setAttribute("average", avg);
			session.setAttribute("version", "1");
			request.getRequestDispatcher("/outputaverage.jsp").forward(request, response);
			
		} else if (request.getParameter("option").equals("5")) {
			
			int studentid = Integer.parseInt(request.getParameter("studentid"));
			String type = request.getParameter("type");
			

			String avg = ProcessStudentGrades.getAverageByIDAndType(studentid, type);
				
			session.setAttribute("studentid",studentid);
			session.setAttribute("average", avg);
			session.setAttribute("type", type);
			session.setAttribute("version", "2");
			request.getRequestDispatcher("/outputaverage.jsp").forward(request, response);
			
		} else if (request.getParameter("option").equals("6")) {
			
			
			String type = request.getParameter("type");
			

			String maxMin = ProcessStudentGrades.getMaxMinByType(type);
			String[] parts = maxMin.split(",");
			String max = parts[0];
			String min = parts[1];
				
			session.setAttribute("max", max);
			session.setAttribute("min", min);
			session.setAttribute("type", type);
			session.setAttribute("version", "3");
			request.getRequestDispatcher("/outputaverage.jsp").forward(request, response);
			
		}
	}
}
