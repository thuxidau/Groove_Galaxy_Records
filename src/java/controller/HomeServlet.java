package controller;

import dal.ProductDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Product;

@WebServlet(name="HomeServlet", urlPatterns={"/home"})
public class HomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProductDAO pd = new ProductDAO();
        
        List<Product> p = pd.getAll();
        request.setAttribute("product", p);
        
        List<Product> bestselling = pd.getBestSellingProduct();
        request.setAttribute("bestsell", bestselling);
        
        List<Product> list = pd.getLimitedEditionProduct();
        request.setAttribute("trend", list);
        
        List<Product> na = pd.getNewArrivalProduct();
        request.setAttribute("newa", na);
        
        List<Product> usuk = pd.getTop5US_UK();
        request.setAttribute("usuk", usuk);
        
        List<Product> kpop = pd.getTop5K_POP();
        request.setAttribute("kpop", kpop);
        
        List<Product> vpop = pd.getTop5V_POP();
        request.setAttribute("vpop", vpop);
        
        request.getRequestDispatcher("home.jsp").forward(request, response);
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}