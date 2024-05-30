package test.task.vk_chat_bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Event {
    @JsonProperty("type")
    private String type;

    @JsonProperty("group_id")
    private Long groupId;

    @JsonProperty("event_id")
    private String eventId;

    @JsonProperty("secret")
    private String secret;

    @JsonValue
    @JsonProperty("object")
    private EventObject eventObject;


}
