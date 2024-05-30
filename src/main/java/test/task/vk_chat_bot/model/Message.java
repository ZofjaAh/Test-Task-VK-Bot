package test.task.vk_chat_bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Message {
    @JsonProperty("id")
    private int id;
    @JsonProperty("date")
    private int date;
    @JsonProperty("peer_id")
    private int peerId;
    @JsonProperty("from_id")
    private int fromId;
    @JsonProperty("text")
    private String text;

}