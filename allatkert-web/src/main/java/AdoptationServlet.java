import hu.alkfejl.dao.*;
import hu.alkfejl.model.Adoptation2;
import hu.alkfejl.model.Adoptive2;
import hu.alkfejl.model.Animal2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adoptation")
public class AdoptationServlet extends HttpServlet {

    private final AdoptationDao dao = new AdoptationDaoImpl();
    private final AnimalDao daoAnimal = new AnimalDaoImpl();
    private final AdoptiveDao daoAdoptive = new AdoptiveDaoImpl();
    private int id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = Integer.parseInt(request.getParameter("id"));
        Animal2 animal2 = daoAnimal.getAnimalById(id);
        List<Adoptive2> adoptiveList = daoAdoptive.list();
        request.setAttribute("animalWeb", animal2);
        request.setAttribute("adoptiveList", adoptiveList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("adoptation.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest requ, HttpServletResponse respo) throws ServletException, IOException {
        respo.setContentType ("text/html; charset=UTF-8");
        requ.setCharacterEncoding ("UTF-8");
        respo.setCharacterEncoding("UTF-8");
        System.out.println("adoptiveID: " + requ.getParameter("adoptiveId"));
        System.out.println(" id: " + id);
        System.out.println(" date: "+ requ.getParameter("date"));
        System.out.println(" donT: "+ requ.getParameter("donationType"));
        System.out.println(" donV: "+ requ.getParameter("donationValue"));
        System.out.println(" donfreq "+ requ.getParameter("donationFreq"));

        Adoptation2 adoptation2 = new Adoptation2(Integer.parseInt(requ.getParameter("adoptiveId")), id, requ.getParameter("date"), requ.getParameter("donationType"), Integer.parseInt(requ.getParameter("donationValue")), requ.getParameter("donationFreq"));
        dao.add(adoptation2);
        daoAnimal.update2(id);
        respo.sendRedirect("animallist");
    }

}