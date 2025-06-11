package io.omoto.fms.infrastructure.queues.impl;

import io.omoto.fms.infrastructure.queues.Queues;
import io.omoto.fms.infrastructure.queues.QueuesVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.omoto.fms.commons.constants.QueueConstants.RABBIT_DELAY_EXCHANGE_NAME;
import static io.omoto.fms.commons.constants.QueueConstants.RABBIT_TOPIC_EXCHANGE_NAME;

@Component
public class RabbitMqQueue implements Queues {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqQueue.class.getName());


    /**
     * sendToQueueWithDelay sends data to rabbitmq.
     * @param queueVO contains queueName to use and data that needs to be send
     * Its has ability to schedule data in queue with delay.
     */
    @Override
    public void sendToQueueWithDelay(QueuesVO queueVO) {
        //Schedule message to queues with delay
        rabbitTemplate.convertAndSend(RABBIT_DELAY_EXCHANGE_NAME,
                queueVO.getQueueName(),
                queueVO.getData() ,
                message -> {
                    message.getMessageProperties()
                            .setHeader("x-delay", queueVO.getExecutionDelayInMin()*60*1000);//delay time in milliseconds
                    return message;
                });
    }


    @Override
    public void sendToQueue(QueuesVO queueVO) {
        LOGGER.info("Send the to Queue, {} ",queueVO);
        rabbitTemplate.convertAndSend(RABBIT_TOPIC_EXCHANGE_NAME,
                queueVO.getQueueName(),
                queueVO.getData());
    }
}
