package Interfaces;

public interface IReinstatement {

    //put parameters that we use in cancellation
    void startReinstatement(String transactionType, String transactionEffectiveDate, String transactionDescription);
    void processReinstatement(String reinstatementClaims, String reinstatementReason);

}
