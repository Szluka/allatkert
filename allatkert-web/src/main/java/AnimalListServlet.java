import hu.alkfejl.dao.AnimalDao;
import hu.alkfejl.dao.AnimalDaoImpl;
import hu.alkfejl.model.AnimalWeb;

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
        List<AnimalWeb> animalList = dao.list();
        request.setAttribute("animalList", animalList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("animallist.jsp");
        dispatcher.forward(request, response);
    }

}
