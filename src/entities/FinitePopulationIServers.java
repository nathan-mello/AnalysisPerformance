package entities;

public class FinitePopulationIServers {

    //Fila M/M/(infinitos)//K - População Finita com Infinitos Servidores

    private int requisitions;
    private int processing;
    private int population;

    public FinitePopulationIServers(int requisitions, int processing, int population) {
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

    public double nRequisitions(int n) {
        if (n<=population) {
            return (Math.pow( (double) (requisitions/processing), n) *
                    ((double) population/n)) /
                    Math.pow(1.0 + (double) (requisitions/processing), population);
        }
        else {
            return 0.0;
        }
    }

    public double noRequisitions() {

        double result = 1.0 + (double) (requisitions/processing);
        return 1.0/(Math.pow(result, population));
    }

    public double ro() {
        double result =  (population*requisitions)/(1 + (double) requisitions/processing);

        if (result>=1.0) {
            return 1.0;
        } else if (result<=0.0) {
            return 0.0;
        }
        return result;
    }

    public double avgUser() {
        double result = (population*( (double) requisitions/processing));

        return result/(1.0 + (double) requisitions/processing);
    }

}
