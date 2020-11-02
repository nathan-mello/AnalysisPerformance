package program;
import entities.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        System.out.println("------------------------------------\n"
                          + "1 - Um servidor\n"
                          + "2 - N Servidores\n"
                          + "3 - Infinitos Servidores\n"
                          + "4 - Fila com capacidade finita\n"
                          + "5 - m-Servidores com Capacidade Finita\n"
                          + "6 - População Finita com um Servidor\n"
                          + "7 - População Finita com Infinitos Servidores\n"
                          + "8 - M Senidores com Capacidade e População Finitos\n"
                          + "------------------------------------\n");

        int option = scn.nextInt();


        if(option == 1)
            Menu.optionSingleServer();

        else if (option == 2)
            Menu.optionMServers();

        else if (option == 3)
            Menu.optionInfiniteServers();

        else if (option == 4)
            Menu.optionFiniteCapacityServer();

        else if (option == 5)
            Menu.optionFiniteCapacityMServer();

        else if (option == 6)
            Menu.optionFinitePopulationServer();

        else if (option == 7)
            Menu.optionFinitePopulationIServers();

        else if (option ==8)
            Menu.optionFinitePopulationMServers();

        scn.close();

    }
}
