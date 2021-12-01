package com.sgodabee.bankaccountsdemo.controller;

import com.sgodabee.bankaccountsdemo.model.Account;
import com.sgodabee.bankaccountsdemo.model.TransactionHistory;
import com.sgodabee.bankaccountsdemo.model.User;
import com.sgodabee.bankaccountsdemo.repository.AccountRepository;
import com.sgodabee.bankaccountsdemo.repository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

public class AppController {

    @Autowired
    private AccountRepository accountRepository;



    @Autowired
    private TransactionHistoryRepository transactHistoryRepository;

    User user;

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(HttpSession session){
        ModelAndView getDashboardPage = new ModelAndView("dashboard");

        // Get the details of the logged i user:
        user = (User)session.getAttribute("user");

        // Get The Accounts Of The Logged In User:
        List<Account> getUserAccounts = accountRepository.getUserAccountsById(user.getUser_id());

        // Get Balance:
        BigDecimal totalAccountsBalance = accountRepository.getTotalBalance(user.getUser_id());

        // Set Objects:
        getDashboardPage.addObject("userAccounts", getUserAccounts);
        getDashboardPage.addObject("totalBalance", totalAccountsBalance);

        return getDashboardPage;
    }




    @GetMapping("/transact_history")
    public ModelAndView getTransactHistory(HttpSession session){
        // Set View:
        ModelAndView getTransactHistoryPage = new ModelAndView("transactHistory");

        // Get Logged In User:
        user = (User) session.getAttribute("user");

        // Get Payment History / Records:
        List<TransactionHistory> userTransactHistory = transactHistoryRepository.getTransactionRecordsById(user.getUser_id());

        getTransactHistoryPage.addObject("transact_history", userTransactHistory);

        return getTransactHistoryPage;

    }
}
