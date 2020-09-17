package entities;

import java.util.Scanner;

public class Menu {

    public static void optionSingleServer(){

        Scanner sc = new Scanner(System.in);

        int processing, requisition, user;

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


        sc.close();
    }

    public static void optionMServers() {

        Scanner sc = new Scanner(System.in);

        int processing, requisition, server, user;


        System.out.println("requisições por segundo: ");
        requisition = sc.nextInt();

        System.out.println("capacidade de processamento por /s:  ");
        processing = sc.nextInt();

        System.out.println("Servidores: ");
        server = sc.nextInt();

        System.out.println("Usuários: ");
        user = sc.nextInt();



        MServers mserver = new MServers(requisition, processing, server);

        System.out.println("Probabilidade de n requisições no sistema (Pn): " + mserver.nRequisitions(user));
        System.out.println("Ro: " + mserver.ro());
        System.out.println("Probabilidade de não existir requisição: " + mserver.noRequisitions());
        System.out.println("C de Erlang: " + mserver.cErlang());
        System.out.println("Número médio de requisições em espera: " + mserver.waitingRequests());
        System.out.println("requisições em atendimento: " + mserver.serviceRequests());
        System.out.println("Número de requisições: " + mserver.numberOfRequests());
        System.out.println("Utilização: " + mserver.ro());
        System.out.println("Tempo médio de resposta: " + mserver.avgTime());
        System.out.println("Tempo médio de espera na fila: " + mserver.avgWaitingTime());

        sc.close();

        }

    public static void optionInfiniteServers() {

        Scanner sc = new Scanner(System.in);

        int processing, requisition, user;
        double noUser;


        System.out.println("requisições por segundo: ");
        requisition = sc.nextInt();

        System.out.println("capacidade de processamento por /s:  ");
        processing = sc.nextInt();

        System.out.println("Probabilidade de 0 usuarios%: ");
        noUser = sc.nextDouble();

        System.out.println("Usuários: ");
        user = sc.nextInt();

        InfiniteServers infiniteServers = new InfiniteServers(requisition,processing);

        System.out.println("Ro: "+ infiniteServers.ro());
        System.out.println("5 usuarios: " + infiniteServers.nRequisitions(user, noUser));
        System.out.println("numero media de suarios: " + infiniteServers.ro());
        System.out.println("tempo medio: " + infiniteServers.avgTime());


        sc.close();
    }

    public static void optionFiniteCapacityServer() {

        Scanner sc = new Scanner(System.in);

        int processing, requisition,server, user, rowB;


        System.out.println("requisições por segundo: ");
        requisition = sc.nextInt();

        System.out.println("capacidade de processamento por /s:  ");
        processing = sc.nextInt();

        System.out.println("B: ");
        rowB = sc.nextInt();

        System.out.println("Servidor: ");
        server = sc.nextInt();

        System.out.println("Usuarios: ");
        user = sc.nextInt();

        FiniteCapacityServer row = new FiniteCapacityServer(requisition, processing, rowB, server);


        System.out.println("Probabilidade de n usuários no Sistema: " + row.NRequisitions(user));
        System.out.println("Variável 'rô': " + row.ro());
        System.out.println("Probabilidade de nenhum usuário no sistema: " + row.noRequisitions());
        System.out.println("Utilização: " + row.utilization());
        System.out.println("Taxa Efetiva de chegada: " + row.receivingRate());
        System.out.println("Taxa de perda: " + row.lossRate());
        System.out.println("Número  médio de usuários do Sistema: " + row.avgUsers());
        System.out.println("Número médio de usuários na fila: " + row.avgUsersQueue());
        System.out.println("Tempo médio de resposta: " + row.avgResponseTime());
        System.out.println("Tempo médio de espera: " + row.avgWaitingTime());

        sc.close();

    }

    public static void optionFiniteCapacityMServer() {
        Scanner sc = new Scanner(System.in);

        int processing, requisition,server, user, rowB;


        System.out.println("requisições por segundo: ");
        requisition = sc.nextInt();

        System.out.println("capacidade de processamento por /s:  ");
        processing = sc.nextInt();

        System.out.println("B: ");
        rowB = sc.nextInt();

        System.out.println("Servidor: ");
        server = sc.nextInt();

        System.out.println("Usuarios: ");
        user = sc.nextInt();

        FiniteCapacityMServers row = new FiniteCapacityMServers(requisition, processing, rowB, server);


        System.out.println("A probabilidade de n usuários no sistema: " + row.nRequisitions(user));
        System.out.println("A probabilidade de nenhum usuário no sistema: " + row.noRequisitions());
        System.out.println("Utilização: " + row.utilization());
        System.out.println("Taxa efetiva de chegada: " + row.receivingRate());
        System.out.println("Taxa de Perda: " + row.lossRate());
        System.out.println("Número médio de usuários no sistema: " + row.avgUsers());
        System.out.println("Número médio de usuários na fila: " + row.avgUsersQueue());
        System.out.println("Tempo médio de resposta: " + row.avgResponseTime());
        System.out.println("Tempo médio de espera: " + row.avgWaitingTime());

        sc.close();

    }

}
