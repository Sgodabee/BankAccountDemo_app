package com.sgodabee.bankaccountsdemo.savings.controller;


import com.sgodabee.bankaccountsdemo.savings.generator.GenAccountNumber;
import com.sgodabee.bankaccountsdemo.savings.model.User;
import com.sgodabee.bankaccountsdemo.savings.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/create_account")
    public String createAccount(@RequestParam("account_name") String accountName,
                                @RequestParam("account_type") String accountType,
                                RedirectAttributes redirectAttributes,
                                HttpSession session) {

        // TODO: CHECK FOR EMPTY STRINGS:
        if (accountName.isEmpty() || accountType.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Account Name and Type Cannot be Empty!");
            return "redirect:/bank_app/dashboard";
        }

        // TODO: GET LOGGED IN USER:
        User user = (User) session.getAttribute("user");

        // TODO: GET / GENERATE ACCOUNT NUMBER:
        int setAccountNumber = GenAccountNumber.generateAccountNumber();
        String bankAccountNumber = Integer.toString(setAccountNumber);

        //
        double dep_amount = 0;

        // SET ACCOUNT BALANCE
        if (dep_amount >= 1000.00) {

            // TODO: CREATE ACCOUNT:
            accountRepository.createBankAccount(user.getUser_id(), bankAccountNumber, accountName, accountType);
            accountRepository.changeAccountBalanceById(dep_amount, setAccountNumber);

            // Set Success message:
            redirectAttributes.addFlashAttribute("success", "Account Created Successfully!");
            return "redirect:/bank_app/dashboard";
        } else {
            redirectAttributes.addFlashAttribute("error", "No Enough Amount to Open Savings Account");
            return "redirect:/bank_app/dashboard";
        }


    }
}