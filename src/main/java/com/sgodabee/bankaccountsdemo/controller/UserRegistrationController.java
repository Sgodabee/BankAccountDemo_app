package com.sgodabee.bankaccountsdemo.controller;

import com.sgodabee.bankaccountsdemo.model.User;
import com.sgodabee.bankaccountsdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Random;

public class UserRegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public ModelAndView getRegister(){
        ModelAndView getRegisterPage = new ModelAndView("register.jsp");
        System.out.println("In Register Page Controller");
        getRegisterPage.addObject("PageTitle", "Register");
        return getRegisterPage;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("registerUser") User user,
                                 BindingResult result,
                                 @RequestParam("first_name") String first_name,
                                 @RequestParam("last_name") String last_name,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirm_password") String confirm_password) throws Exception {

        ModelAndView registrationPage = new ModelAndView("register.jsp");

        // Check For Errors:
        if(result.hasErrors() && confirm_password.isEmpty()){
            registrationPage.addObject("confirm_pass", "The confirm Field is required");
            return registrationPage;
        }

        // TODO: GENERATE RANDOM CODE:
        Random rand = new Random();
        int bound = 123;
        int code = bound * rand.nextInt(bound);

        // TODO: GET TOKEN STRING:
        String token = "Awaiting";





        // TODO: REGISTER USER:
        userRepository.registerUser(first_name, last_name, email, password, token, code);



        // TODO: RETURN TO REGISTER PAGE:
        String successMessage = "Account Registered Successfully, Please Check your Email and Verify Account!";
        registrationPage.addObject("success", successMessage);
        return registrationPage;
    }
}
