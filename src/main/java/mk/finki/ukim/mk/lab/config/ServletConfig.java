package mk.finki.ukim.mk.lab.config;

import mk.finki.ukim.mk.lab.web.EventListServlet;
import mk.finki.ukim.mk.lab.web.EventBookingServlet;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<EventListServlet> eventListServlet(EventService eventService) {
        return new ServletRegistrationBean<>(new EventListServlet(eventService), "/");
    }

    @Bean
    public ServletRegistrationBean<EventBookingServlet> eventBookingServlet(EventBookingService eventBookingService) {
        return new ServletRegistrationBean<>(new EventBookingServlet(eventBookingService), "/eventBooking");
    }
}