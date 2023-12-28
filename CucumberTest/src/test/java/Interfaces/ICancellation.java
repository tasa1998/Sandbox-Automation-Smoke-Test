package Interfaces;

public interface ICancellation {

    //put parameters that we use in cancellation
    void startCancellation(String transactionType, String transactionEffectiveDate, String transactionDescription);
    void processCancellation(String cancelReason, String cancelMethod);

}
