package com.wangyousong.practice.texttosql;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class SqlGenerator {

    private final ChatClient chatClient;

    SqlGenerator(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    String generate(String question) {
        String response = chatClient
            .prompt(question)
            .call()
            .content().trim();

        boolean isSelectQuery = response.startsWith("SELECT");
        if (!isSelectQuery) {
            throw new InvalidQueryException(response);
        }
        log.info("Generated SQL: \n{}", response);
        return response;
    }

}