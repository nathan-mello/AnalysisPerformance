package program;
import entities.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        System.out.println("---------------------\n"
                          + "1 - Um servidor\n"
                          + "2 - N Servidores\n"
                          + "3 - Infinitos Servidores\n"
                          + "---------------------\n");

        int option = scn.nextInt();


        if(option == 1)
            Menu.optionSingleServer();

        else if (option == 2)
            Menu.optionMServers();

        else if (option == 3)
            Menu.optionInfiniteServers();

        scn.close();

    }
}
