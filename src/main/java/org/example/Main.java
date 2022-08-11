package org.example;

import java.awt.*;
import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Arrays;


public class Main{
    public static void main(String[] args) throws IOException {
        String Name;
        int choice, nb;
        char restart;
        String filename;
        File file = new File("C://Users/Kuessi-Ansan Manuel/Desktop/members.txt");
        ArrayList<Member> ml = new ArrayList<Member>();
        //ObjectOutputStream mlos = new ObjectOutputStream(new FileOutputStream(file));
        ListIterator lis = null;
        Scanner scn = new Scanner(System.in);
        System.out.println("What's up folk..How are you doing ? \n");
        System.out.print("What's your name?:");
        Name = scn.nextLine();

        System.out.println("Okay..So Welcome "+Name);

        System.out.println("You're the admin of this system \n");


        do {
            System.out.println("What do you want to do?\n");
            System.out.println("1- Add \n2- View\n3-Delete\n");
            System.out.print("=>");

            choice = scn.nextInt();

            switch (choice){
                case 1:
                    System.out.println("How many members do you want to add : ");
                    nb = scn.nextInt();

                    for (int i=0; i<nb; i++){
                        try {
                            System.out.println("Enter the name of the member: ");
                            Scanner str = new Scanner(System.in);
                            String Nom = str.nextLine();
                            System.out.println("Enter the surnames of the member: ");
                            String Prenoms = str.nextLine();

                            System.out.println("Enter the age of the member: ");
                            int Age = str.nextInt();

                            System.out.println("Enter the sex of the member (M/F): ");
                            char Sex = str.next().charAt(0);

                            System.out.println("Enter the profession of the member: ");
                            Scanner prf = new Scanner(System.in);
                            String Profession = prf.nextLine();

                            ml.add(new Member(Nom, Prenoms, Age, Sex, Profession));
                        }catch(InputMismatchException ex){
                            System.out.println("Enter correct sh*ts: !!");
                        }

                    }
                    if (!file.exists()){
                        try{
                            file.createNewFile();
                        }catch(IOException e){
                            e.printStackTrace();
                        }
                    }else {
                        //public void printArrayListToFile(ml, "filename"){
                            PrintWriter writer = new PrintWriter(file);
                            for (Member line : ml) {
                                writer.println(line);
                            }
                            writer.close();
                        //}

                        //printArrayListToFile(ml, "members.txt");
                    }
                    //mlos = new ObjectOutputStream(new FileOutputStream(file));


                case 2:
                    for (Member mbr:ml) {
                        System.out.println(mbr);
                    };

                    if(file.exists()){
                        Desktop desktop = Desktop.getDesktop();//in order to directly open the file
                        desktop.open(file);
                    }else {
                        System.out.println("We couldn't find the file");
                    }
                    System.out.println("*****************************************************");
                        lis = ml.listIterator();
                        while (lis.hasNext())
                        {
                            System.out.println(lis.next());
                        }
                    System.out.println("*****************************************************");

                    break;
                case 3:
                    System.out.println("How many elements do you want to delete ? :\n");
                    System.out.println(" => ");
                    Scanner stri = new Scanner(System.in);
                    nb = stri.nextInt();

                    for (int i=0; i<nb; i++){
                        try {
                            System.out.println("Enter the position of the element you want to delete : ");
                            Scanner posi = new Scanner(System.in);
                            int pst = posi.nextInt();

                            for (Member mbr:ml) {
                                System.out.println(mbr);
                            }
                            ml.remove(pst);
                        }catch (IndexOutOfBoundsException exx){
                            System.out.println("We could'nt find the element you're looking for");
                        }
                    }

                    break;

                default:
                    System.out.println("You have to chose something my gee ;)");
            }
            System.out.println("Do you want to do something else ?(Y/y):");
            restart = scn.next().charAt(0);
        }while (restart == 'Y' || restart =='y');


    }
}
