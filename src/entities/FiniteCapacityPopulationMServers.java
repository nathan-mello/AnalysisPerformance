package entities;

public class FiniteCapacityPopulationMServers {

    private int requisitions;
    private int processing;
    private int population;
    private int rowB;
    private int servers;
    private int noRequisitions;

    public FiniteCapacityPopulationMServers(int requisitions, int processing, int population,
                                            int rowB, int servers, int noRequisitions) {
        this.requisitions = requisitions;
        this.processing = processing;
        this.population = population;
        this.rowB = rowB;
        this.servers = servers;
        this.noRequisitions = noRequisitions;
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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
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

    public int getNoRequisitions() {
        return noRequisitions;
    }

    public void setNoRequisitions(int noRequisitions) {
        this.noRequisitions = noRequisitions;
    }

    public int factorial(int n){
        int result = 1;

        for(int i=n;i>0;i--) {
            result *= i;

        }
        return result;
    }

    public double ro() {
        double result = (double) requisitions/(processing*servers);

        if(result<0)
            return 0.0;
        else if (result>1)
            return 1;

        return result;
    }

    public double nRequisitions(int n) {

        if(population <= servers-1 ){
            return ((double) population/n)*ro()*noRequisitions;
        }
        else{
            double result;
            result = factorial(n)/(factorial(servers)*Math.pow(servers, n-servers));

            return result*((double) population/n)*ro()*noRequisitions;
        }
    }

    public double utilization() {
        return 1-noRequisitions;
    }

    public double avgUsers() {
        double result = 0;
        for(int i=0; i<=servers; i++){
            result += i*nRequisitions(i);
        }
        return result;
    }

    public double receivingRate(){
        return  1.0;
    }
}
