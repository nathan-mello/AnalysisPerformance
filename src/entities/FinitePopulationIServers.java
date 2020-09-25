package entities;

public class FinitePopulationIServers {

    private int requisitions;
    private int processing;
    private int population;
    private int servers;

    public FinitePopulationIServers(int requisitions, int processing, int population, int servers) {
        this.requisitions = requisitions;
        this.processing = processing;
        this.population = population;
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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getServers() {
        return servers;
    }

    public void setServers(int servers) {
        this.servers = servers;
    }

    public double noRequisitions() {
        return 1.0/Math.pow(1.0 + (double) requisitions/processing, population);
    }

    public double nRequisitions(int n) {
        if (n<=population) {
            return (Math.pow( (double) requisitions/processing, n) *
                    ((double) population/n)) /
                    Math.pow(1.0+ (double) requisitions/processing, population);
        }
        else {
            return 0.0;
        }
    }

    public double ro() {
        return (population*requisitions)/(1 + (double) requisitions/processing);
    }

    public double avgUser() {
        double result = (population*( (double) requisitions/processing));

        return result/(1.0 + (double) requisitions/processing);
    }

}
