package Interfaces;

public interface IEndorsement {


    void startEndorsement(String transactionType, String transactionSubtype, String transactionReason, String transactionEffectiveDate, String transactionDescription);
    void bodyOfTheEndorsement(String yearValue, String makeValue, String modelValue, String specificationValue, String usageValue, String ownershipValue);
    void endEndorsement();

}
