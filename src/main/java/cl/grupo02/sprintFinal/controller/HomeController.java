package cl.grupo02.sprintFinal.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {


    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @GetMapping(path = {"/"})
    public String paginaInicio(HttpServletRequest request) {
        // Depuración
        logger.info("Solicitud GET: {}", request.getRequestURI());

        // Mostrar página
        return "home";
    }

}
    
