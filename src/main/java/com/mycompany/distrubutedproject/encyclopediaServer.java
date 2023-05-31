package com.mycompany.distrubutedproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class encyclopediaServer extends UnicastRemoteObject implements encyclopedia {

    protected String text = "";

    protected Map<String,Integer> map = new HashMap<>();

    protected ArrayList<String> words = new ArrayList<>();

    protected encyclopediaServer() throws RemoteException {
        super();
    }

    @Override
    public void setText(String Text){
        text = Text;
        map.clear();
        words.clear();
        for(String word : text.split(("\\s+"))){
            if(!map.containsKey(word)) {
                map.put(word, 1);
                words.add(word);
            }
            else
                map.replace(word,map.get(word)+1);
        }

    }

    @Override
    public int count(){
        return text.length();
    }

    @Override
    public String shortest(){
        String ans = words.get(0);
        for(String word : words){
            if(word.length()<ans.length()) {
                ans = word;
            }
        }
        return ans;
    }

    @Override
    public String longest(){
        String ans = words.get(0);

        for(String word : words){
            if(word.length()>ans.length()) {
                ans = word;
            }
        }
        return ans;
    }
    @Override
    public ArrayList<String> repeatedWords(){
        ArrayList<String> ans = new ArrayList<>();

        for(String word: words) {
            if(map.get(word)>1)
                ans.add(word);
        }
        return ans;
        }

    @Override
    public Map<String, Integer> repeat() {
        return map;
    }
}





