package it.chatty.chat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private Integer messageId;
    private String username;
    private String messageText;
}
