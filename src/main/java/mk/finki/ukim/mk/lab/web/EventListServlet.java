package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EventListServlet",urlPatterns = "/")
public class EventListServlet extends HttpServlet {
    private final EventService eventService;
    private SpringTemplateEngine springTemplateEngine;

    public EventListServlet(EventService eventService) {
        this.eventService = eventService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Event> eventList;
       if(req.getParameter("searchText")!=null && (req.getParameter("searchScore")!= null&& req.getParameter("searchScore")!="")) {
           eventList = eventService.searchByNameAndScore(req.getParameter("searchText"), Double.parseDouble(req.getParameter("searchScore")));
       }
       else if(req.getParameter("searchScore")!=null && req.getParameter("searchScore")!=""){
           eventList=eventService.searchByScore(Double.parseDouble(req.getParameter("searchScore")));
       }
       else{
           eventList=eventService.listAll();
       }
        IWebExchange iWebExchange= JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req,resp);
        WebContext context=new WebContext(iWebExchange);
        context.setVariable("events",eventList);
        springTemplateEngine.process("listEvents.html",context,resp.getWriter());
    }
}
