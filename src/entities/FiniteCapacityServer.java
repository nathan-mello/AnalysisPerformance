package entities;

public class FiniteCapacityServer {

    //Fila M/M/1/B - Capacidade Finita

    private double requisitions;
    private double processing;
    private int rowB;


    public FiniteCapacityServer(double requisitions, double processing, int rowB) {
        this.requisitions = requisitions;
        this.processing = processing;
        this.rowB = rowB;

    }

    public double getRequisitions() {
        return requisitions;
    }

    public void setRequisitions(int requisitions) {
        this.requisitions = requisitions;
    }

    public double getProcessing() {
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

    public double ro(){
        double result = (double) requisitions/processing;

        if(result<0)
            return 0.0;
        else if (result>1)
            return 1.0;

        return result;
    }

    public double noRequisitions() {
        double p = ro();
        return (1 - p)/(1 - Math.pow(p, rowB+1));
    }

    public double NRequisitions(int n) {

        if(n<=rowB) {
            return noRequisitions()*Math.pow(ro(), n);
        }
        else
            return 0.0;

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


