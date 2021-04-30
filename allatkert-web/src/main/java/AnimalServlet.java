import hu.alkfejl.dao.AnimalDao;
import hu.alkfejl.dao.AnimalDaoImpl;
import hu.alkfejl.model.Animal2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/animal")
public class AnimalServlet extends HttpServlet {

    private final AnimalDao dao = new AnimalDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType ("text/html; charset=UTF-8");
        req.setCharacterEncoding ("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        System.out.println(req.getParameter("specie"));
        Animal2 animal2 = new Animal2( req.getParameter("name"), Integer.parseInt(req.getParameter("year")), req.getParameter("specie"), req.getParameter("intro"), null, 0);
        dao.add(animal2);
        resp.sendRedirect("animal.jsp");
    }
}
