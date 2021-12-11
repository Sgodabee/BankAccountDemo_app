package com.sgodabee.bankaccountsdemo.controller;

import com.sgodabee.bankaccountsdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView getIndexPage = new ModelAndView("index");
        getIndexPage.addObject("PageTittle","Home");
        System.out.println("in index Controller");
        return getIndexPage;
    }

    @GetMapping("/login")
   public ModelAndView getLogin() {
        ModelAndView getLoginPage = new ModelAndView("login");
        getLoginPage.addObject("PageTittle","login");
        System.out.println("in login Controller");
        return getLoginPage;
    }

    @GetMapping("/error")
    public ModelAndView getError() {
        ModelAndView getErrorPage = new ModelAndView("error");
        getErrorPage.addObject("PageTitle","Errors");
        System.out.println("In Error page Controller");
        return getErrorPage;
    }


    @GetMapping("/verify")
    public ModelAndView getVerify(@RequestParam("token") String token,@RequestParam("code") String code) {

        ModelAndView getVerifyPage ;


        String dbToken = userRepository.checkToken(token);

        //Check if Token Is Valid
        if(dbToken ==null)
        {
            getVerifyPage = new ModelAndView("error");
            getVerifyPage.addObject("error","This Session Has Expired");
            return  getVerifyPage;
        }
        //End Of Check If token is Valid

        userRepository.verifyAccount(token, code);
        getVerifyPage = new ModelAndView("login");


        getVerifyPage.addObject("Success","Account Verified Successfully, Please proceed to login");
        System.out.println("in Verify Account page Controller");
        return getVerifyPage;
    }
}
