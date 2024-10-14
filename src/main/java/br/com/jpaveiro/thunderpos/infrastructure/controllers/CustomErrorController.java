package br.com.jpaveiro.thunderpos.infrastructure.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {
    private final ErrorAttributes errorAttributes;

    public CustomErrorController(final ErrorAttributes errorAttributes, WebRequest webRequest)
    {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(WebRequest request)
    {
        Map<String, Object> details = errorAttributes.getErrorAttributes(
                request, ErrorAttributeOptions.defaults()
        );

        HttpStatus status = HttpStatus.valueOf((int) details.getOrDefault("status", 500));
        return new ResponseEntity<>(details, status);
    }
}
