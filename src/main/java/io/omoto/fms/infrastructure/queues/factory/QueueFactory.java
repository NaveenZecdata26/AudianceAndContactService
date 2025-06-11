package io.omoto.fms.infrastructure.queues.factory;

import io.omoto.fms.commons.constants.QueueConstants;
import io.omoto.fms.infrastructure.queues.Queues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueFactory{
    @Autowired
    private BeanFactory beanFactory;

    public Queues getQueueProvider(String queueProviderName){
        if (queueProviderName.equals(QueueConstants.RABBIT_MQ)) {
            return beanFactory.getBean("rabbitMqQueue", Queues.class);
        } else {
            throw new IllegalArgumentException("queue not found!");
        }
    }
}