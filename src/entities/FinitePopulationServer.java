package entities;

public class FinitePopulationServer {

    private int requisitions;
    private int processing;
    private int population;

    public FinitePopulationServer(int requisitions, int processing, int population) {
        this.requisitions = requisitions;
        this.processing = processing;
        this.population = population;
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

    public int factorial(int n){
        int result = 1;

        for(int i=n;i>0;i--) {
            result *= i;
        }
        return result;
    }

    public  double ro() {
        return (double) requisitions/processing;
    }

    public double noRequisitions() {

        double result = 1;
        for(int n=0; n<=population; n++) {

            result = Math.pow((double) requisitions/processing, n) *
                    ( (double) factorial(population)/factorial(population-n));
        }
        return 1.0/result;
    }

    public double nRequisitions(int n) {
        if (n <= population) {
            return  Math.pow( (double) requisitions/population, n) *
                    ((double) factorial(population)/factorial(population-n))
                            * noRequisitions();
        }
        else {
            return 0.0;
        }
    }

    public double utilization() {
        return ro() * ( population - avgUsers() );
    }

    public double avgUsersQueue() {
        return population - (double) ((requisitions-processing)/requisitions)
                * (1 - noRequisitions());
    }

    public double avgUsers() {
        return avgUsersQueue() + (1 - noRequisitions());
    }

    public double avgWaitingTime() {
        return avgUsersQueue()/ (requisitions * (population - avgUsers()));
    }

    public double avgResponseTime() {
        return avgWaitingTime() + 1.0/processing;
    }

    public double receivingRate() {
        return processing * (1 - noRequisitions());
    }

}