package test.task.vk_chat_bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class EventObject {
    @JsonValue
    @JsonProperty("message")
    private Message message;


}