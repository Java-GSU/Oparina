package default_package;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.business.Book;
import mysql.business.BookDB;


@WebServlet("/")
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


//        ArrayList<Book> products = BookDB.select();
//        request.setAttribute("products", products);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String nameAuthor = request.getParameter("nameAuthor");
            ArrayList<Book> search = BookDB.selectAuthor(nameAuthor);
            request.setAttribute("search", search);

            String nameAutho = request.getParameter("nameAuthor");
            ArrayList<Book> searc = BookDB.selectPoint(nameAutho);
            request.setAttribute("searc", searc);

            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}