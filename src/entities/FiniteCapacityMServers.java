package entities;

public class FiniteCapacityMServers {

    //Fila M/M/m/B - m-Servidores com Capacidade Finita

    private int requisitions;
    private int processing;
    private int rowB;
    private int servers;

    public FiniteCapacityMServers(int requisitions, int processing, int rowB, int servers) {
        this.requisitions = requisitions;
        this.processing = processing;
        this.rowB = rowB;
        this.servers = servers;
    }

    public int getRequisitions() {
        return requisitions;
    }

    public void setRequisitions(int requisitions) {
        this.requisitions = requisitions;
    }

    public int getProcessing() {
        return processing;
    }

    public void setProcessing(int processing) {
        this.processing = processing;
    }

    public int getRowB() {
        return rowB;
    }

    public void setRowB(int rowB) {
        this.rowB = rowB;
    }

    public int getServers() {
        return servers;
    }

    public void setServers(int servers) {
        this.servers = servers;
    }

    public int factorial(int n){
        int result = 1;

        for(int i=n;i>0;i--) {
            result *= i;

        }
        return result;
    }

    public double ro() {
        return (double) requisitions/(processing*servers);
    }

    public double noRequisitions() {

        double p , result;

        p = ro();
        result = (1 - Math.pow(p , rowB-servers+1 ))
                * (Math.pow(servers*p, servers));

        result = 1 + result/(factorial(servers)*(1-p));


        for(int i =1; i<servers; i++) {
            result += Math.pow(servers*p, i)/factorial(i);
        }

        return 1/result;
    }

    public double nRequisitions(int n) {
        if(n<servers) {
            return Math.pow( (double) requisitions/processing, n)
                    * (1.0/factorial(n)
                    * noRequisitions());

        }else {
            return (Math.pow(servers, servers)/factorial(servers))
                    * Math.pow( (double) requisitions/processing, n)
                    * noRequisitions();
        }
    }

    public double utilization() {
        return ro()*(1-nRequisitions(rowB));
    }

    public double receivingRate() {
        return requisitions*(1- nRequisitions(rowB));
    }

    public double lossRate() {
        return requisitions*nRequisitions(rowB);
    }

    public double avgUsers() {
        double result = 0;

        for (int i=1; i<=rowB; i++){
            result += i*nRequisitions(i);
        }
        return result;
    }

    public double avgUsersQueue() {
        double result = 0;

        for (int i=servers+1; i<=rowB; i++) {
            result += (i - servers) * nRequisitions(i);
        }
        return result;
    }

    public double avgResponseTime() {
        return avgUsers()/(requisitions*(1-nRequisitions(rowB)));
    }

    public  double avgWaitingTime() {
        return avgUsersQueue()/(requisitions*(1-nRequisitions(rowB)));
    }



}
