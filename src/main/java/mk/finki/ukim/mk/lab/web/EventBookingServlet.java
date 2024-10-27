package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingService;

import java.io.IOException;

@WebServlet(name = "EventBookingServlet",urlPatterns = "/eventBooking")
public class EventBookingServlet extends HttpServlet {
    private EventBookingService eventBookingService;

    public EventBookingServlet(EventBookingService eventBookingService) {
        this.eventBookingService = eventBookingService;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eventName = req.getParameter("eventName");
        String attendeeName = req.getParameter("attendeeName"); // Внесете го ова поле во формата
        String attendeeAddress = req.getParameter("attendeeAddress"); // Внесете го ова поле во формата
        int numberOfTickets = Integer.parseInt(req.getParameter("numTickets"));

        // Создавање резервација
        EventBooking booking = eventBookingService.placeBooking(eventName, attendeeName, attendeeAddress, numberOfTickets);

        // Поставување на атрибути за JSP
        req.setAttribute("booking", booking);
        req.getRequestDispatcher("/templates/bookingConfirmation.html").forward(req, resp);
    }
}
