package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Member {
    private String Nom;
    private String Prenoms;
    private int Age;
    private char Sexe;
    private String Profession;



    public Member(){

    }


    public Member(String nom, String prenoms, int age, char sexe, String profession) {
        Nom = nom;
        Prenoms = prenoms;
        Age = age;
        Sexe = sexe;
        Profession = profession;
    }



}
