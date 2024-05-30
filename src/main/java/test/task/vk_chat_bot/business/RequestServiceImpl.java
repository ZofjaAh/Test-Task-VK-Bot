package test.task.vk_chat_bot.business;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import test.task.vk_chat_bot.model.Event;

import java.security.SecureRandom;

@Slf4j
@Service
public class RequestServiceImpl implements RequestService{

    @Override
    public void createResponse(Event event, String accessToken, String apiVersion, String vkUrl) {
        MultiValueMap<String,String> parameters = new LinkedMultiValueMap<>();
        parameters.add("access_token", accessToken);
        parameters.add("user_id", String.valueOf(event.getEventObject().getMessage().getFromId()));
        parameters.add("random_id", String.valueOf(new SecureRandom().nextInt()));
        parameters.add("message", "Вы написали: " + event.getEventObject().getMessage().getText());
        parameters.add("v", apiVersion);

        WebClient webClient = WebClient.create(vkUrl);
        webClient.post().uri(uriBuilder -> uriBuilder
                .path("/messages.send")
                .queryParams(parameters)
                .build())
                .accept(MediaType.APPLICATION_JSON )
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(error-> log.error("An error has occurred {}", error.getLocalizedMessage()))
                .onErrorResume(e-> Mono.empty())
                .block();
    }
}
