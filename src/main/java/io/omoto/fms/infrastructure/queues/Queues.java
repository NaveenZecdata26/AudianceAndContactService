package io.omoto.fms.infrastructure.queues;

public interface Queues {
    void sendToQueueWithDelay(QueuesVO queueVO);
    void    sendToQueue(QueuesVO queueVO);
}
