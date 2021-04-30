import hu.alkfejl.dao.AnimalDao;
import hu.alkfejl.dao.AnimalDaoImpl;
import hu.alkfejl.model.Animal2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/animallist")
public class AnimalListServlet extends HttpServlet {

    private final AnimalDao dao = new AnimalDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Animal2> animalList = dao.list();
        request.setAttribute("animalList", animalList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("animallist.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest requ, HttpServletResponse respo) throws ServletException, IOException {
        respo.setContentType ("text/html; charset=UTF-8");
        requ.setCharacterEncoding ("UTF-8");
        respo.setCharacterEncoding("UTF-8");
            System.out.println(requ.getParameter("tipusok") + " " + requ.getParameter("kereses"));
        List<Animal2> animalList = dao.list2(requ.getParameter("tipusok"), requ.getParameter("kereses"));
        requ.setAttribute("animalList", animalList);
        RequestDispatcher dispatcher = requ.getRequestDispatcher("animallist.jsp");
        dispatcher.forward(requ, respo);
        //respo.sendRedirect("animallist.jsp");
    }

}
