package org.crystal.Client.jms.consumer;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component

public class JmsConsumer {
	private int a = 1;
	private int b = 1;

	@JmsListener(destination = "queue1", containerFactory = "queueListener")
	public void handleMessage(TextMessage message) throws JMSException {

		System.out.println("1收到消息:" + message.getText() + "   " + (a++));

	}

	@JmsListener(destination = "queue1", containerFactory = "queueListener")
	public void handleMessage1(TextMessage message) throws JMSException {

		System.out.println("2收到消息:" + message.getText() + "   " + (b++));

	}

	@JmsListener(destination = "topic1", containerFactory = "topicListener")
	public void handleTopicMessage1(String message) {

		System.out.println("1收到订阅消息:" + message);
	}

	@JmsListener(destination = "topic1", containerFactory = "topicListener")
	public void handleTopicMessage2(String message) {

		System.out.println("2收到订阅消息:" + message);
	}
}
