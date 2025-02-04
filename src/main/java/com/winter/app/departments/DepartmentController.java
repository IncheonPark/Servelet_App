package com.winter.app.departments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DepartmentDAO departmentDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentController() {
        super();
        departmentDAO = new DepartmentDAO();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    /*
     * 서버 요청 시 방법
     * 1. URL(IP:port/경로)
     * 2. 메서드 형식
     * - GET
     * 	* 단순 요청 시
     *  * 파라미터가 주소창에 노출 (파라미터가 Header에 담김)
     *  * 작은 용량을 보낼 때 사용
     * 
     * - POST
     * 	* 보안이 요구되는 요청 시
     *  * 파라미터가 주소창에 노출되지 않음 (파라미터가 Body에 담김)
     *  * 큰 용량을 보낼 때 사용
     *
     * 
     * 3. 메서드 결정
     * - 주소창에 URL을 직접 입력 > GET 방식으로 결정된다.
     * - <a>태그 사용 > GET 방식으로 결정된다.
     * 
     * 
     * */
    
    // request 안에는 url정보, 메서드 형식, 메서드 정보 등이 들어있다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		try {			
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			String method = request.getMethod();
			StringBuffer url =  request.getRequestURL();
			String uri = request.getRequestURI(); // 자기 내부에서 쓰는 식별자, IP 및 port 필요 없음
			String result = useSubString(uri);
			
//		System.out.println(method);
//		System.out.println(url.toString());
//		System.out.println(uri);
			System.out.println(result);
			
			//
			if (result.equals("list.do")) {
				List<DepartmentDTO> list = departmentDAO.getList();
				
				PrintWriter writer = response.getWriter();
				writer.println("<h1>Department List</h1>");
				
				writer.println("<table border = 1px solid; >");
				
				writer.println("<thead>");
				writer.println("<tr>");
				writer.println("<th>Dept ID</th> <th>Dept Name</th>");
				writer.println("</tr>");
				writer.println("</thead>");
				
				writer.println("<tbody>");
				
				for (int i = 0; i < list.size(); i++) {
					writer.println("<tr>");
					writer.println("<td>" + list.get(i).getDepartment_id() + "</td>");
					writer.println("<td>" + list.get(i).getDepartment_name() + "</td>");
					writer.println("</tr>");
					
				}
				
				writer.println("</tbody>");
				
				writer.println("</table>");
				
				writer.close();
				
			} else if (result.equals("detail.do")) {
				departmentDAO.getDetail();
				
			} else {
				System.out.println("Sorry URL's not correct");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	
	
	// URI 파싱 방법 1.
	private String useSubString(String data) {
		String result = data.substring(data.lastIndexOf("/")+1);
		System.out.println(result+" useSubString 메서드");
		
		return result;
	}

	// URI 파싱 방법 2.
	private void useSplit(String data) {
		String [] datas = data.split("/");
		System.out.println(datas[datas.length-1]);
	}

	
	// URI 파싱 방법 3.
	private void useToken(String data) {
		StringTokenizer st = new StringTokenizer(data, "/");
		String result = "";
		while(st.hasMoreTokens()) {
			result = st.nextToken();
		}
		
		System.out.println(result);
	}
	
	
	
	
	
}
