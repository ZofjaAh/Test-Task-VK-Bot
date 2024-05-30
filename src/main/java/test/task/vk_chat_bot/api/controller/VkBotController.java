package test.task.vk_chat_bot.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.task.vk_chat_bot.business.VkBotService;
import test.task.vk_chat_bot.model.Event;


@RestController
@AllArgsConstructor
@RequestMapping(value = VkBotController.API_MESSAGE , produces = MediaType.APPLICATION_JSON_VALUE)
public class VkBotController{
    public static final String API_MESSAGE = "/api/message";
    private final VkBotService vkBotService;

    @PostMapping
    public ResponseEntity<?> ResponseCreating(@RequestBody Event event) throws Exception
    {
        return vkBotService.createResponse(event);
    }

}
