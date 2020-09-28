package entities;

public class InfiniteServers {

    //Fila M/M/(infinitos) - Infinitos Servidores

    private int requisitions;
    private int processing;

    public InfiniteServers(int requisitions, int processing) {
        this.requisitions = requisitions;
        this.processing = processing;
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

    public int factorial(int n){
        int total = 1;

        for(int i=n;i>0;i--) {
            total *= i;

        }
        return total;
    }

    public  double ro() {
        return (double) requisitions/processing;
    }

    public double nRequisitions (int n, double use) {
        return (Math.pow(ro(), n)/ factorial(n))*(use);
    }

    public double avgTime() {
        return  (double) 1/processing;
    }
}
