package entities;

import java.util.Scanner;

public class Menu {

    public static int modulo(int number){
        if(number<0){
            return number*-1;
        }
        return number;

    }

    public static double modulo(double number){
        if(number<0.0){
            return number*-1.0;
        }
        return number;

    }

    public static void optionSingleServer(){

        Scanner sc = new Scanner(System.in);


        int  user;
        double requisition, processing;

        System.out.println("requisições por segundo: ");
        requisition = sc.nextDouble();


        System.out.println("capacidade de processamento por /s:  ");
        processing = sc.nextDouble();


        System.out.println("Usuários: ");
        user = modulo(sc.nextInt());


        SingleServer row = new SingleServer(processing, requisition);

        System.out.println(row.getProcessing());


        System.out.printf("Intensidade de tráfego: %.2f", row.trafficIntensity() * 100);
        System.out.println(" %");

        System.out.printf("nenhum usuário no sistema: %.2f", row.noUser()*100);
        System.out.println(" %");

        System.out.printf("N usuários no sistema: %.2f", row.nUser(user)*100);
        System.out.println(" %");

        System.out.printf("N ou mais usuários no sistema: %.2f", row.nMoreUser(user)*100);
        System.out.println(" %");

        System.out.printf("um ou mais usuários no sistema: %.2f", row.nMoreUser( 1)*100);
        System.out.println(" %");

        System.out.println("Tempo médio de resposta: "+ row.avgTime()+ "s");
        System.out.println("Tempo médio de espera na fila: " + row.avgTime() + "s");
        System.out.println("Número médio de usuários: "
                + row.avgUser()
                + " requisições");

        System.out.println("Número médio de requisições na fila: "
                + row.avgRequisition()
                + " requisições");


        sc.close();
    }

    public static void optionMServers() {

        Scanner sc = new Scanner(System.in);

        int  server, user;
        double requisition, processing;

        System.out.println("requisições por segundo: ");
        requisition = sc.nextDouble();

        System.out.println("capacidade de processamento por /s:  ");
        processing = sc.nextDouble();

        System.out.println("Servidores: ");
        server = modulo(sc.nextInt());

        System.out.println("Usuários: ");
        user = modulo(sc.nextInt());


        MServers mserver = new MServers(requisition, processing, server);


        System.out.printf("Ro: %.2f", mserver.ro()*100);
        System.out.println(" %");

        System.out.printf("Probabilidade de não existir requisição: %.2f",
                 mserver.noRequisitions()*100);
        System.out.println(" %");

        System.out.printf("Probabilidade de n requisições no sistema: %.2f",
                mserver.nRequisitions(user)*100);
        System.out.println(" %");

        System.out.printf("C de Erlang: %.2f%n", mserver.cErlang());
        System.out.printf("Número médio de requisições em espera: %.2f Requisições%n",
                mserver.waitingRequests());

        System.out.printf("requisições em atendimento: %.2f Requisições%n",
                mserver.serviceRequests());

        System.out.printf("Número de requisições: %.2f Requisições%n", mserver.numberOfRequests());
        System.out.printf("Utilização: %.2f%n", mserver.ro());
        System.out.printf("Tempo médio de resposta: %.2f s %n", mserver.avgTime());
        System.out.printf("Tempo médio de espera na fila: %.2f s %n", mserver.avgWaitingTime());

        sc.close();

        }

    public static void optionInfiniteServers() {

        Scanner sc = new Scanner(System.in);

        int user;
        double processing, requisition, noUser;


        System.out.println("requisições por segundo: ");
        requisition = modulo(sc.nextDouble());

        System.out.println("capacidade de processamento por /s:  ");
        processing = modulo(sc.nextDouble());

        System.out.println("Probabilidade de 0 usuarios: ");
        noUser = modulo(sc.nextDouble());

        System.out.println("Usuários: ");
        user = modulo(sc.nextInt());

        InfiniteServers infiniteServers = new InfiniteServers(requisition,processing);

        System.out.printf("Ro: %.2f", infiniteServers.ro()*100);
        System.out.println(" %");
        System.out.printf("N usuarios: %.2f", infiniteServers.nRequisitions(user, noUser)*100);
        System.out.println(" %");
        System.out.printf("numero media de suarios: %.2f%n", infiniteServers.avgUsers());
        System.out.printf("tempo medio: %.2f%n", infiniteServers.avgTime());


        sc.close();
    }

    public static void optionFiniteCapacityServer() {

        Scanner sc = new Scanner(System.in);

        int server, user, rowB;
        double processing, requisition;

        System.out.println("requisições por segundo: ");
        requisition = modulo(sc.nextDouble());

        System.out.println("capacidade de processamento por /s:  ");
        processing = modulo(sc.nextDouble());

        System.out.println("B: ");
        rowB = modulo(sc.nextInt());

        System.out.println("Usuarios: ");
        user = modulo(sc.nextInt());

        FiniteCapacityServer row = new FiniteCapacityServer(requisition, processing, rowB);

        System.out.printf("Variável 'rô': %.2f", row.ro()*100);
        System.out.println(" %");

        System.out.printf("Probabilidade de n usuários no Sistema: %.2f", row.NRequisitions(user)*100);
        System.out.println(" %");

        System.out.printf("Probabilidade de nenhum usuário no sistema: %.2f", row.noRequisitions()*100);
        System.out.println(" %");

        System.out.printf("Utilização: %.2f%n", row.utilization());
        System.out.printf("Taxa Efetiva de chegada: %.2f%n", row.receivingRate());
        System.out.printf("Taxa de perda: %.2f%n", row.lossRate());
        System.out.printf("Número  médio de usuários do Sistema: %.2f%n", row.avgUsers());
        System.out.printf("Número médio de usuários na fila: %.2f%n", row.avgUsersQueue());
        System.out.printf("Tempo médio de resposta: %.2f%n", row.avgResponseTime());
        System.out.printf("Tempo médio de espera: %.2f%n", row.avgWaitingTime());

        sc.close();

    }

    public static void optionFiniteCapacityMServer() {
        Scanner sc = new Scanner(System.in);

        int server, user, rowB;
        double processing, requisition;

        System.out.println("requisições por segundo: ");
        requisition = sc.nextDouble();

        System.out.println("capacidade de processamento por /s:  ");
        processing = sc.nextDouble();

        System.out.println("B: ");
        rowB = sc.nextInt();

        System.out.println("Servidor: ");
        server = sc.nextInt();

        System.out.println("Usuarios: ");
        user = sc.nextInt();

        FiniteCapacityMServers row = new FiniteCapacityMServers(requisition, processing, rowB, server);


        System.out.printf("Ro: %.2f", row.ro());
        System.out.println(" %");

        System.out.printf("A probabilidade de n usuários no sistema: %.2f", row.nRequisitions(user));
        System.out.println(" %");

        System.out.printf("A probabilidade de nenhum usuário no sistema: %.2f", row.noRequisitions());
        System.out.println(" %");

        System.out.printf("Utilização: %.2f%n", row.utilization());
        System.out.printf("Taxa efetiva de chegada: %.2f%n", row.receivingRate());
        System.out.printf("Taxa de Perda: %.2f%n", row.lossRate());
        System.out.printf("Número médio de usuários no sistema: %.2f%n", row.avgUsers());
        System.out.printf("Número médio de usuários na fila: %.2f%n", row.avgUsersQueue());
        System.out.printf("Tempo médio de resposta: %.2f%n", row.avgResponseTime());
        System.out.printf("Tempo médio de espera: %.2f%n", row.avgWaitingTime());

        sc.close();

    }

    public static void optionFinitePopulationServer() {

        Scanner sc = new Scanner(System.in);

        int populacao, user;
        double processing, requisition;

        System.out.println("requisições por segundo: ");
        requisition = sc.nextDouble();

        System.out.println("capacidade de processamento por /s:  ");
        processing = sc.nextDouble();

        System.out.println("Universo de Usuários: ");
        populacao = sc.nextInt();

        System.out.println("Usuários: ");
        user = sc.nextInt();


        FinitePopulationServer row = new FinitePopulationServer(requisition, processing, populacao);

        System.out.printf("Ro: %.2f", row.ro());
        System.out.println(" %");
        System.out.printf("A probabilidade de n usuários no sistema: %.2f", row.nRequisitions(user));
        System.out.println(" %");
        System.out.printf("A probabilidade de nenhum usuário no sistema: %.5f", row.noRequisitions());
        System.out.println(" %");
        System.out.printf("Utilização: %.2f%n", row.utilization());
        System.out.printf("Taxa efetiva de chegada: %.2f%n", row.receivingRate());
        System.out.printf("Número médio de usuários no sistema: %.2f%n", row.avgUsers());
        System.out.printf("Número médio de usuários na fila: %.2f%n", row.avgUsersQueue());
        System.out.printf("Tempo médio de resposta: %.2f%n", row.avgResponseTime());
        System.out.printf("Tempo médio de espera: %.2f%n", row.avgWaitingTime());

        sc.close();

    }

    public static void optionFinitePopulationIServers() {

        Scanner sc = new Scanner(System.in);

        int populacao, user;
        double processing, requisition;

        System.out.println("requisições por segundo: ");
        requisition = modulo(sc.nextDouble());

        System.out.println("capacidade de processamento por /s:  ");
        processing = modulo(sc.nextDouble());

        System.out.println("Universo de Usuários: ");
        populacao = modulo(sc.nextInt());

        System.out.println("Usuários: ");
        user = modulo(sc.nextInt());


        FinitePopulationIServers row = new FinitePopulationIServers(requisition, processing, populacao);

        System.out.printf("Ro: %.2f", row.ro()*100);
        System.out.println(" %");

        System.out.println("A probabilidade de n usuários no sistema: " + row.nRequisitions(user));
        System.out.println("A probabilidade de nenhum usuário no sistema: " + row.noRequisitions());
        System.out.println("Media de usuarios no sistema: " + row.avgUser());



        sc.close();


    }

    public static void optionFinitePopulationMServers() {

        Scanner sc = new Scanner(System.in);

        int populacao, rowB, server, user;
        double processing, requisition, ro;

        System.out.println("requisições por segundo: ");
        requisition = sc.nextDouble();

        System.out.println("capacidade de processamento por /s:  ");
        processing = sc.nextDouble();

        System.out.println("Universo de Usuários: ");
        populacao = sc.nextInt();

        System.out.println("B: ");
        rowB = sc.nextInt();

        System.out.println("server: ");
        server = sc.nextInt();

        System.out.println("Probabilidade de 0 usuarios no sistema: ");
        ro = sc.nextDouble();

        System.out.println("Usuários: ");
        user = sc.nextInt();

        FiniteCapacityPopulationMServers row = new FiniteCapacityPopulationMServers(requisition, processing, populacao,
                rowB, server, ro);

        System.out.println("Intensidade de tráfego: " + row.ro());
        System.out.println("Utilização: " + row.utilization());
        System.out.println("Número médio de usuários no sistema: " + row.avgUsers());
        System.out.println("Tempo médio de espera na fila: " + row.avgUsersQueue());
        System.out.println("Tempo médio de resposta: " + row.avgResponseTime());
        System.out.println("Taxa efetiva de chegadas: " + row.receivingRate());
    }
}
