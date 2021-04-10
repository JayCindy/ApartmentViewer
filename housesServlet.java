package edu.tarleton.apartmentviewer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "housesServlet", urlPatterns = {"/housesServlet"})
public class housesServlet extends HttpServlet {

    ArrayList<Property> prop = new ArrayList<>();
        
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Property p1 = new Property("791 W Long St", "Stephenville, TX", 2500, true, true, 7832, "House", 4, 4, "https://www.apartmentviewer.com/whatever");
            Property p2 = new Property("345 W Short St", "Stephenville, TX", 2500, false, false, 5678, "House", 5, 3, "https://whatever");
            prop.add(p1);
            prop.add(p2);
            
            String home = request.getParameter("home");
            String bed = request.getParameter("bed"); // convert to int
            String bath = request.getParameter("bath"); // convert to double
            //String pet = request.getParameter("pet");
            String rent = request.getParameter("rent");
            String location = request.getParameter("location");
            double bath1 = 0;
            bath1 = Double.parseDouble(bath);
            int bed1 = 0;
            bed1 = Integer.parseInt(bed);
            
            Search s1 = new Search(home, bed1, bath1, rent, location, prop);
            
            //ArrayList<Property> ans = s1.search();

            RequestDispatcher rd =
                    request.getRequestDispatcher("WEB-INF/houses.jsp");
                    rd.forward(request, response);
                    
            searchWithin(s1);
            out.println("search results: ");
            s1.print();
        }
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
    
    public ArrayList<Property> searchWithin(Search s) {
        Property p1 = new Property("791 W Long St", "Stephenville, TX", 2500, true, true, 7832, "House", 4, 4, "https://www.apartmentviewer.com/whatever");
        Property p2 = new Property("345 W Short St", "Stephenville, TX", 2500, false, false, 5678, "House", 5, 3, "https://whatever");
        prop.add(p1);
        prop.add(p2);
        
        ArrayList<Property> ans = s.search();
        
        return ans;
         
    }

}
