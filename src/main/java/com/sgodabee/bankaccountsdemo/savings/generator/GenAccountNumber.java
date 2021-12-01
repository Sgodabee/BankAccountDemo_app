package com.sgodabee.bankaccountsdemo.savings.generator;

import java.util.Random;

public class GenAccountNumber {



        public static int generateAccountNumber(){
            int accountNumber;
            Random random = new Random();
            int bound = 1020;
            accountNumber = bound * random.nextInt(bound);
            return accountNumber;
        }

}
