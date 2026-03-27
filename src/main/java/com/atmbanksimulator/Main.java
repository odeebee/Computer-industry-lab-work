package com.atmbanksimulator;

import javafx.application.Application;
import javafx.stage.Stage;

// 🧍Think of MVC like a human body:
// - View is the face and senses: it shows things and receives input.
// - Controller is the nerves: it carries signals to the brain and triggers actions.
// - UIModel is the brain: it holds state and logic, and queries domain services.
// - Bank / BankAccount are the real "money world" rules.
// Together, they simulate how an ATM thinks, reacts, and handles money.

public class Main extends Application {
    public static void main( String args[] ) {launch(args);}

    public void start(Stage window) {

        // Create a Bank object add two bank accounts for test
        Bank bank = new Bank();
        bank.addBankAccount("10001", "11111", 100);
        bank.addBankAccount("10002", "22222", 50);
        bank.addStudentBankAccount("20002","11111",300,200);
        bank.addPrimeBankAccount("90009","12345",1000,20000,500);
        bank.addSavingsBankAccount("12345","12345",500,4);

        bank.showAccounts();

        //UIModel-View-Controller structure setup
        // Create the UIModel, View and Controller objects and link them together
        UIModel UIModel = new UIModel(bank);   // the UIModel needs the Bank object to 'talk to' the bank
        View  view  = new View();
        Controller controller  = new Controller();

        // Link them together so they can talk to each other
        view.controller = controller;
        controller.UIModel = UIModel;
        UIModel.view = view;

        // start up the GUI (view), and then tell the UIModel to initialise itself
        view.start(window);
        UIModel.initialise();
    }
}
