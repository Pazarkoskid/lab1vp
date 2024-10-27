package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.service.EventService;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EventListServlet",urlPatterns = "/")
public class EventListServlet extends HttpServlet {
    private final EventService eventService;

    public EventListServlet(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("events", eventService.listAll());
            req.getRequestDispatcher("/templates/listEvents.html").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }
}
