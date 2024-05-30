package test.task.vk_chat_bot.business;

import test.task.vk_chat_bot.model.Event;

public interface RequestService {
    void createResponse(Event event, String accessToken, String apiVersion, String vkUrl);
}
