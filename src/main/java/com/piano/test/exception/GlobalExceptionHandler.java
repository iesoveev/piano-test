package com.piano.test.exception;

import com.piano.test.dto.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    private static final Logger log = LogManager.getLogger(GlobalExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object o, Exception e) {

        var result = new Response(e.getLocalizedMessage());
        log.error(e.getLocalizedMessage());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        if (e instanceof UnsupportedUserOperationException)
            response.setStatus(HttpStatus.FORBIDDEN.value());
        else
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        try {
            response.getWriter().print(result);
        } catch (IOException ex) {
            return null;
        }

        return new ModelAndView();
    }
}
