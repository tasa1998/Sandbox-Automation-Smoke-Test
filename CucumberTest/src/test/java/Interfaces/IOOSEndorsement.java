package Interfaces;

public interface IOOSEndorsement {

    //put parameters that we use in cancellation
    void startOOSEndorsement(String transactionType, String transactionReason, String transactionEffectiveDate, String transactionDescription);
    void bodyOfTheOOSEndorsement(String firstName2, String lastName2, String dateOfBirth2, String gender2, String maritalStatus2, String certificate2, String occupation2, String licenceStatus2, String type2);
    void endOOSEndorsement();

}
