package io.juliodias.analyzer;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueService.class);

    private final QueueMessagingTemplate queueMessagingTemplate;

    public QueueService(AmazonSQSAsync amazonSQSAsync) {
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSQSAsync);
    }

    public void sendMessage(final String queueName, final String payload) {
        final Message<String> message = MessageBuilder.withPayload(payload).build();
        queueMessagingTemplate.send(queueName, message);
        LOGGER.info("Message: [{}] sent with success to queue: {}", message, queueName);
    }

}
