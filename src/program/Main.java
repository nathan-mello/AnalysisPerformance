package program;

import entities.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);

        /*int processing, requisition, user;

        System.out.println("requisições por segundo: ");
        requisition = sc.nextInt();

        System.out.println("capacidade de processamento por /s:  ");
        processing = sc.nextInt();

        System.out.println("Usuários: ");
        user = sc.nextInt();

        SingleServer row = new SingleServer(processing, requisition);

        System.out.println("Intensidade de tráfego: "+ row.trafficIntensity());
        System.out.println("nenhum usuário no sistema: "+ row.noUser());
        System.out.println("N usuários no sistema: " + row.nUser(user));
        System.out.println("N ou mais usuários no sistema: " + row.nMoreUser(user));
        System.out.println("um ou mais usuários no sistema: "+ row.nMoreUser( 1));
        System.out.println("Tempo médio de resposta: " + row.avgTime());
        System.out.println("Tempo médio de espera na fila: " + row.avgTime());
        System.out.println("Número médio de usuários: " + row.avgUser());
        System.out.println("Número médio de requisições na fila:" + row.avgRequisition());

         */

        MServers mserver = new MServers(10, 12, 2);

        System.out.println("Probabilidade de n requisições no sistema (Pn): " + mserver.nRequisitions(5));
        System.out.println("Ro: " + mserver.ro());
        System.out.println("Probabilidade de não existir requisição: " + mserver.noRequisitions());
        System.out.println("C de Erlang: " + mserver.cErlang());
        System.out.println("Número médio de requisições em espera: " + mserver.waitingRequests());
        System.out.println("requisições em atendimento: " + mserver.serviceRequests());
        System.out.println("Número de requisições: " + mserver.numberOfRequests());
        System.out.println("Utilização: " + mserver.ro());
        System.out.println("Tempo médio de resposta: " + mserver.avgTime());
        System.out.println("Tempo médio de espera na fila: " + mserver.avgWaitingTime());

        System.out.println("--------------------------------------------------------");
        InfiniteServers infiniteServers = new InfiniteServers(20,30);

        System.out.println("Ro: "+ infiniteServers.ro());
        System.out.println("5 usuarios: " + infiniteServers.nRequisitions(5, 0.50));
        System.out.println("numero media de suarios: " + infiniteServers.ro());
        System.out.println("tempo medio: " + infiniteServers.avgTime());



        sc.close();



    }
}
