package io.omoto.fms.infrastructure.queues;

public class QueuesVO {
    private String providerName;
    private String queueName;
    private Object data;
    private Integer executionDelayInMin;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getExecutionDelayInMin() {
        return executionDelayInMin;
    }

    public void setExecutionDelayInMin(Integer executionDelayInMin) {
        this.executionDelayInMin = executionDelayInMin;
    }

    @Override
    public String toString() {
        return "QueuesVO{" +
                "providerName='" + providerName + '\'' +
                ", queueName='" + queueName + '\'' +
                ", data=" + data +
                ", executionDelayInMin=" + executionDelayInMin +
                '}';
    }
}
