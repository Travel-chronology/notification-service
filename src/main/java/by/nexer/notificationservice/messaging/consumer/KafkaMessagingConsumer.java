package by.nexer.notificationservice.messaging.consumer;

import by.nexer.notificationservice.messaging.event.NotificationEmailEvent;
import by.nexer.notificationservice.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class KafkaMessagingConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaMessagingConsumer.class);
    private static final String topicCreateOrder = "${topic.send-notification-email}";
    private static final String kafkaConsumerGroupId = "${spring.kafka.consumer.group-id}";
    private final EmailService emailService;

    @Autowired
    public KafkaMessagingConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @Transactional
    @KafkaListener(topics = topicCreateOrder, groupId = kafkaConsumerGroupId, properties = {"spring.json.value.default.type=by.nexer.notificationservice.messaging.event.NotificationEmailEvent"})
    public NotificationEmailEvent createGoogleEvent(NotificationEmailEvent notificationEmailEvent) {
        try {
            emailService.sendSimpleEmail(notificationEmailEvent.getEmail(),
                    notificationEmailEvent.getTitle(),
                    notificationEmailEvent.getMessage()
            );
            logger.info("Send email");
        } catch (Exception e) {
            logger.warn("Something get wrong with event {}", notificationEmailEvent);
            throw new RuntimeException("Something get wrong with event " + notificationEmailEvent);
        }

        return notificationEmailEvent;
    }
}
