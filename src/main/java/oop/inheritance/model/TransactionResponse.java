package oop.inheritance.model;

public class TransactionResponse {
    private boolean approved;
    private String hostReference;

    public TransactionResponse(boolean approved, String hostReference) {
        this.approved = approved;
        this.hostReference = hostReference;
    }

    public boolean isApproved() {
        return this.approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getHostReference() {
        return this.hostReference;
    }

    public void setHostReference(String hostReference) {
        this.hostReference = hostReference;
    }
}
