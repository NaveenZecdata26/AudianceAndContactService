package io.omoto.fms.domains.quota;

public interface QuotaService {
    boolean isQuotaAvailable(Quota quota);

    boolean isQuotaPresent(Quota quota);

   // boolean sendQuotaNotificationEmail(Quota quota);

    boolean reduceQuota(Quota quota);
}
