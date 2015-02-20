/**
 *
 * @author CMarcelo
 */

package controller;

import controller.vo.Course;
import javax.servlet.http.HttpServletRequest;
import model.CourseDAO;





public class DeleteCourse {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            String Id = request.getParameter("id");
            Course course = CourseDAO.getById(Id);                           
            boolean delete = CourseDAO.delete(course);
            if(delete != false){
                jsp = ListCourses.execute(request);
            }else{
                String erro = "An error occurred!";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
