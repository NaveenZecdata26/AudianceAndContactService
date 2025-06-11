package io.omoto.fms.domains.quota;

public class Quota {
    private String type;
    private Long accountId;
    private int quotaReductionCount;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public int getQuotaReductionCount() {
        return quotaReductionCount;
    }

    public void setQuotaReductionCount(int quotaReductionCount) {
        this.quotaReductionCount = quotaReductionCount;
    }
}
