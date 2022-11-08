package service;

import dto.Wallet;
import exception.WalletException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletServiceTest {
    WalletService ws = new WalletServiceImpl();


    @BeforeEach
    void setUp() {
        System.out.println("Create all test data:");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Create all test data:");
    }

    @Test
    void registerWallet() {

        Wallet a = new Wallet(110, "Premika", 1000.0, "098");
        Wallet b = new Wallet(109, "Akalya", 100.0, "678");

        try {
            assertEquals(a,ws.registerWallet(a));
            assertEquals(b,ws.registerWallet(b));
        } catch (WalletException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void login() {
        try {
            Wallet wallet = ws.registerWallet(new Wallet(10,"abcd",2000.0,"2345"));

            Boolean wallet1 = ws.login(10,"2345");
            assertTrue(wallet1);
        } catch (WalletException e) {
            e.printStackTrace();
        }
    }

    @Test
    void addFundsToWallet() {
        try {
            Wallet wallet = ws.registerWallet(new Wallet(10,"xyz",10000.0,"4545"));
            assertEquals(11000.0,ws.addFundsToWallet(10,1000.0));
        } catch (WalletException e) {
            e.printStackTrace();
        }
    }


    @Test
    void showWalletBalance() {
        try {
            Wallet wallet = ws.registerWallet(new Wallet(10,"xyz",10000.0,"1234"));
            assertEquals(wallet.getBalance(),ws.showWalletBalance(10));
        } catch (WalletException e) {
            e.printStackTrace();
        }
    }


    @Test
    void fundTransfer() {
        try {
            Wallet wallet = ws.registerWallet(new Wallet(10,"abc",20000.0,"1234"));
            Wallet wallet1 = ws.registerWallet(new Wallet(11,"xyz",35000.0,"9876"));
            Boolean wallet2 = ws.fundTransfer(10,11,10000.0);
            assertTrue(wallet2);
            assertEquals(45000.0,wallet1.getBalance());
        } catch (WalletException e) {
            e.printStackTrace();
        }
    }


    @Test
    void unRegisterWallet() {
        try {
            Wallet wallet = ws.registerWallet(new Wallet(10,"abc",10000.0,"1234"));
            ws.unRegisterWallet(10,"1234");
        } catch (WalletException e) {
            e.printStackTrace();
        }
    }
}