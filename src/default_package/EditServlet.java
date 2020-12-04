package default_package;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.business.Book;
import mysql.business.BookDB;


@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Book product = BookDB.selectOne(id);
            if(product!=null) {
                request.setAttribute("product", product);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int year = Integer.parseInt(request.getParameter("year"));
            String text = request.getParameter("text");

            Book product = new Book(id, name, year, text);
            BookDB.update(product);
            response.sendRedirect(request.getContextPath() + "/index");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}