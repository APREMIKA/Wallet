package controller;

import dto.Wallet;
import exception.WalletException;
import service.WalletService;
import service.WalletServiceImpl;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        WalletService walletService = new WalletServiceImpl();
        try {
            //registerWallet
            Wallet w1 = walletService.registerWallet(new Wallet(1,"priya",45000.0,"1234"));
            Wallet w2 = walletService.registerWallet(new Wallet(2,"seetha",35000.0,"AbCd"));
            Wallet w3 = walletService.registerWallet(new Wallet(3,"lakshmi",54000.0,"zAyB"));
            walletService.registerWallet(new Wallet(4,"ramu",25000.0,"bBaA"));
            System.out.println(w1);
            System.out.println(w2);
            System.out.println(w3);

            //addFundsToWallet
            walletService.addFundsToWallet(1,20000.0);

            //showWalletBalance
            double w4 = walletService.showWalletBalance(1);
            System.out.println(w4);

            //fundTransfer
            walletService.fundTransfer(2,3,20000.0);
            double w5 = walletService.showWalletBalance(3);
            System.out.println("After transfer new balance " + w5);
            double w6 = walletService.showWalletBalance(2);
            System.out.println(w6);

            //unregister wallet
            walletService.unRegisterWallet(4,"bBaA");
            System.out.println(walletService.showWalletBalance(4));

        } catch (WalletException e) {
            System.out.println(e.getMessage());
        }
    }
}
