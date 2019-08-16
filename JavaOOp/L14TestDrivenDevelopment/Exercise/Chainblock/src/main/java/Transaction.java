public interface Transaction {
    int getId();
    TransactionStatus getStatus();
    void setStatus(TransactionStatus status);
    String getFrom();
    void setFrom(String from);
    String getTo();
    void setTo(String to);
    double getAmount();
    void setAmaunt(Double amaunt);

}
