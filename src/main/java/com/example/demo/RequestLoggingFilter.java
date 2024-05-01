
package com.example.demo;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class RequestLoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Puedes realizar alguna inicialización aquí si es necesario.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logger.info("Time: {} | Request {}: {}", currentTime, httpRequest.getMethod(), httpRequest.getRequestURI());
        chain.doFilter(request, response);
        logger.info("Time: {} | Response status: {}", currentTime, httpResponse.getStatus());
    }

    @Override
    public void destroy() {
        // Puedes realizar alguna limpieza aquí si es necesario.
    }
}
