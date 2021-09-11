package com.company.hellobanking;

import com.company.hellobanking.controllers.AuthenticationController;
import com.company.hellobanking.controllers.HelloBankingController;
import com.company.hellobanking.models.User;
import com.company.hellobanking.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter implements HandlerInterceptor {

    @Autowired
    AuthenticationController authenticationController;

    private static final List<String> whitelist = Arrays.asList("/login", "/register", "/logout", "/css");

    private static final List<String> blacklist = Arrays.asList("/personal_banking", "/register_success");
    //private static boolean isWhitelisted(String path) {
      //  for (String pathRoot : whitelist) {
        //    if (path.startsWith(pathRoot)) {
          //      return true;
            //}
        //}
        //return false;
    //}

    private static boolean notBlacklisted(String path){
        for(String pathRoot : blacklist) {
            if(!path.startsWith(pathRoot)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {


        //dont require sign-in for blacklisted pages
        if(notBlacklisted(request.getRequestURI())){
            //returning true indicates that the request may proceed
            return true;
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        // The user is logged in
        if (user != null) {
            return true;
        }


        // The user is NOT logged in
        response.sendRedirect("/login");  // this was creating the infinite loop that was
        // redirecting to the /login page several times and
        //stopping the application to run on the localhost
        return false;
    }
}