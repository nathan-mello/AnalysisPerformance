package entities;

public class FiniteCapacityServer {

    //Fila M/M/1/B - Capacidade Finita

    private int requisitions;
    private int processing;
    private int rowB;
    private int servers;

    public FiniteCapacityServer(int requisitions, int processing, int rowB, int servers) {
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

    public double ro(){
        return (double) requisitions/(processing);
    }

    public double noRequisitions() {
        double p = ro();
        return (1 - p)/(1 - Math.pow(p, rowB+1));
    }

    public double NRequisitions(int n) {
        return noRequisitions()*Math.pow(ro(), n);
    }

    public double utilization() {
        double p = ro();
        return p*(1 - NRequisitions(rowB));
    }

    public double receivingRate() {
        return processing*(1-NRequisitions(rowB));
    }

    public double lossRate() {
        return processing*NRequisitions(rowB);
    }

    public double avgUsers() {
        double p = ro();
        double result = (rowB+1)*Math.pow(p, rowB+1);

        return  (p/(1-p))-(result/(1-Math.pow(p, rowB+1)));
    }

    public double avgUsersQueue() {
        double p = ro();
        double result = 1 + rowB * Math.pow(p, rowB);

        return  (p/(1-p))-p*(result/(1-Math.pow(p, rowB+1)));
    }

    public double avgResponseTime() {
        return avgUsers()/(processing*(1-NRequisitions(rowB)));
    }

    public double avgWaitingTime() {
        return avgUsersQueue()/(processing*(1-NRequisitions(rowB)));
    }
}


