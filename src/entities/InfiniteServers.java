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
        double result = (double) requisitions/processing;

        if(result<0)
            return 0.0;
        else if (result>1)
            return 1.0;

        return result;
    }

    public double nRequisitions (int n, double use) {
        return (Math.pow(ro(), n)/ factorial(n))*(use);
    }

    public double avgUsers () {
        return (double) requisitions/processing;
    }

    public double avgTime() {
        return  (double) 1/processing;
    }
}
