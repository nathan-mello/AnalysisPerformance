package entities;

public class MServers {

    //Fila M/M/m - m-Servidores

    private int requisitions;
    private int processing;
    private int servers;

    public MServers(int requisitions, int processing, int servers) {
        this.requisitions = requisitions;
        this.processing = processing;
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

    public int getNumberServers() {
        return servers;
    }

    public void setNumberServers(int numberServers) {
        this.servers = numberServers;
    }

    public int factorial(int n){
        int result = 1;

        for(int i=n;i>0;i--) {
            result *= i;

        }
        return result;
    }

    public double ro(){
        return (double) requisitions/(processing*servers);
    }

    public double noRequisitions(){
        double p = ro();
        double result = Math.pow(servers*p, servers)/(factorial(servers)*(1-p));


        for(int n=0; n<servers; n++){
            result += Math.pow(servers*p, n)/factorial(n);

        }
        return 1/result;
    }

    public double cErlang(){
        double result = Math.pow(servers*ro(), servers)/(factorial(servers)*(1-ro()));

        return result * noRequisitions();
    }

    public double nRequisitions(int n){

        if (n<=servers){
            return (Math.pow(servers*ro(),n)/factorial(n))*noRequisitions();

        }else {
            return  ((Math.pow(ro(), n)*Math.pow(servers, servers))
                    / factorial(servers)) * noRequisitions();

        }
    }

    public double waitingRequests() {
        return (ro()*cErlang())/(1-ro());
    }

    public double serviceRequests() {
        return servers*ro();
    }

    public double numberOfRequests() {
        return servers*ro() + waitingRequests();
    }

    public double avgTime() {
        double result = cErlang()/(servers*(1-ro()));
        return (1+result)*(1.0/processing);
    }

    public double avgWaitingTime() {
        return  cErlang()/servers*processing*(1-ro());
    }
}
