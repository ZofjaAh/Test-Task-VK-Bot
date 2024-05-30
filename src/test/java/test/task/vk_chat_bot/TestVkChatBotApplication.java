package test.task.vk_chat_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestVkChatBotApplication {

	public static void main(String[] args) {
		SpringApplication.from(VkChatBotApplication::main).with(TestVkChatBotApplication.class).run(args);
	}

}
