package controller;

import Middleware.AllXML;
import MiddlewareService.AllXMLService;
import XMLBean.All;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //use AllXMLService in MiddlewareService
        String movieName = request.getParameter("movieName");
        movieName = new String(movieName.getBytes("ISO8859-1"),"UTF-8");
        String theater = request.getParameter("theater");
        theater = new String(theater.getBytes("ISO8859-1"),"UTF-8");
        String date = request.getParameter("date");

        AllXMLService allXMLService = new AllXML();
        ArrayList<All> all = allXMLService.getAllData(movieName, theater, date);

        request.getSession().setAttribute("all", all);

        ServletContext application = this.getServletContext();
        RequestDispatcher rd = application.getRequestDispatcher("/html/Detail.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
