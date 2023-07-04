package com.github.foodmagnet.Models;

import com.github.foodmagnet.Controllers.AuthenticationController;
import com.github.foodmagnet.Models.data.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AuthenticationFilter implements HandlerInterceptor {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;
    private static final List<String> whitelist = Arrays.asList("/css", "/css/bootstrap.css", "/css/restaurant.css", "/", "/city","/register","/login"
    );

    private static boolean isWhitelisted(String path) {
        for (String pathRoot : whitelist) {
            if (path.equals(pathRoot)) {

                return true;
            }

        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        // Don't require sign-in for whitelisted pages
        if (isWhitelisted(request.getRequestURI())) {
            // returning true indicates that the request may proceed
            return true;
        }

        String path = request.getRequestURI();
        String[] pathSegments = path.split("/"); // Split the path into segments

        // Assuming the path format is "/view/{restaurantId}"
        if (pathSegments.length > 2 && pathSegments[1].equals("view")) {
            String restaurantId = pathSegments[2]; // Extract the restaurantId from the path
            if (!authenticate(restaurantId)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }
        }

        // Perform your authentication logic using the restaurantId

        // If authentication fails, you can return an appropriate response or throw an exception



        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        // The user is logged in
        if (user != null) {
            return true;
        }

        // The user is NOT logged in
        response.sendRedirect("/login");
        return false;
    }


    private boolean authenticate(String restaurantId) {
        // Implement your authentication logic here
        // Return true if authentication is successful, false otherwise
        return true;
    }
}
