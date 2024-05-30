package test.task.vk_chat_bot.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import test.task.vk_chat_bot.configuration.BeanConfiguration;
import test.task.vk_chat_bot.model.Event;


@Service
@AllArgsConstructor
@Slf4j
public class VkBotService {
    public static final String EVENT_TYPE_CONFIRMATION = "confirmation";
    public static final String EVENT_TYPE_NEW_MESSAGE = "message_new";

    private BeanConfiguration config;

    private final RequestService requestService;

    public ResponseEntity<?> createResponse(Event event) {

        if (!isSecretKeyValid(config.secretKey, event.getSecret())) {
            log.error("Received secret key is not identical to the one specified in " +
                    "the application.yml configuration: [{}]", event.getSecret());

            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        log.debug("Received: [{}]", event);
        if (event.getType().equals(EVENT_TYPE_CONFIRMATION)) {
            return new ResponseEntity<>(config.confirmationToken, HttpStatus.OK);
        }
        if (event.getType().equals(EVENT_TYPE_NEW_MESSAGE)) {
            requestService.createResponse(event, config.accessToken, config.apiVersion, config.vkUrl);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    private boolean isSecretKeyValid(String secretKey, String receivedKey) {
        log.info("Received Secret key is: [{}]", receivedKey);
        if (secretKey == null && receivedKey == null) // secret key was not received and not initialized for API client
            return true;
        if (secretKey == null || receivedKey == null) // secret key was not received but was expected, or vice versa
            return false;
        return secretKey.equals(receivedKey);
    }
}