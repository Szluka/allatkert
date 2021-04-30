import hu.alkfejl.dao.AdoptiveDao;
import hu.alkfejl.dao.AdoptiveDaoImpl;
import hu.alkfejl.model.Adoptive2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adoptive")
public class AdoptiveServlet extends HttpServlet {

    private final AdoptiveDao dao = new AdoptiveDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType ("text/html; charset=UTF-8");
        req.setCharacterEncoding ("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Adoptive2 adoptive2 = new Adoptive2( req.getParameter("username"), req.getParameter("email"));
        System.out.println("req: "+req.getParameter("username"));
        System.out.println(adoptive2.getName());
        System.out.println(adoptive2.getEmail());

        dao.add(adoptive2);
        resp.sendRedirect("adoptive.jsp");
    }
}
