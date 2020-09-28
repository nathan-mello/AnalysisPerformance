package entities;

public class SingleServer {

    //Fila M/M/1 - O Sistema Clássico

    private int requisitions;
    private int processing;

    public SingleServer(int processing, int requisitions) {
        this.processing = processing;
        this.requisitions = requisitions;
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

    public double trafficIntensity(){
        double result = (double) requisitions/processing;

        if (result<0) {
            return 0.0;
        }
        else if (result>1) {
            return 1.0;
        }

        return result;

    }

    public double noUser(){
        return 1.0 - trafficIntensity();
    }

    public double nUser(int number){
        return Math.pow(trafficIntensity(), number) * noUser();
    }

    public double nMoreUser(int number){
        return Math.pow(trafficIntensity(), number);
    }

    public double avgTime(){
        return 1/(processing*(1 - trafficIntensity()));
    }

    public double avgUser(){
        return trafficIntensity()/(1-trafficIntensity());
    }

    public double avgRequisition(){
        return Math.pow(trafficIntensity(), 2)/(1-trafficIntensity());
    }
}