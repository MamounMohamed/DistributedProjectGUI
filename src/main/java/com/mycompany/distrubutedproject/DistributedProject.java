package com.mycompany.distrubutedproject;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class DistributedProject {

    public static void main(String[] args) throws IOException ,AlreadyBoundException  {
            encyclopedia server = new encyclopediaServer();
            Registry registry = LocateRegistry.createRegistry(69);
            registry.bind("encyclopedia", server);
            System.out.println("Server started");
            new mainFrame();
    }

}

