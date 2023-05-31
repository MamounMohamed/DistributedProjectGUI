package com.mycompany.distrubutedproject;

import java.rmi.*;
import java.util.*;

public interface encyclopedia extends Remote{

    void setText(String Text)throws RemoteException;
    int count() throws RemoteException;
    ArrayList<String> repeatedWords() throws RemoteException;
    String longest() throws RemoteException;
    String shortest() throws RemoteException;
    Map<String, Integer> repeat() throws RemoteException;
    }


