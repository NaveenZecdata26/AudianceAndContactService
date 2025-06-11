package io.omoto.fms.commons.constants;

/**
 * Created by omoto on 13/01/18.
 */
public class QueueConstants {
    public static final String RABBIT_MQ="rabbit_mq";

    public static final String RABBIT_DELAY_EXCHANGE_NAME ="delay-exchange";
    public static final String RABBIT_TOPIC_EXCHANGE_NAME ="topic-exchange";

    //rabbitMQ queues names
    public static final String RABBIT_ACTIVATION_REMINDER_QUEUE_NAME = "activation-reminder-queue";
    public static final String RABBIT_CREATE_AUDIENCE_QUEUE_NAME = "audience-creation-queue";
    public static final String RABBIT_SAVE_AUDIENCE_QUEUE_NAME = "audience-save-queue";
    public static final String COMMUNICATION_QUEUE_NAME = "communication-queue";
    public static final String RABBIT_ACCOUNT_ACTIVATION_REMINDER_QUEUE_NAME = "account-activation-reminder-queue";
    public static final String RABBIT_INSERT_RESPONSE_QUEUE_NAME = "response-insertion-queue";
    public static final String RABBIT_INSERT_FILTER_QUEUE_NAME = "filter-insertion-queue";
    public static final String LISTENER_DEFAULT_METHOD_NAME = "onMessage";
    public static final String RABBIT_INSERT_REPORTS_QUEUE_NAME = "report-generate-queue";

    private QueueConstants(){

    }
}
