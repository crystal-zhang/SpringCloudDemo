package org.crystal.Client.jms;

import java.time.LocalDateTime;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 如果需要多个Topic、Queue该怎么配置？
 * 
 * @author Administrator
 *
 */
@RestController
public class JmsProducerController {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
//	@Autowired
//	private Queue queue;
//	@Autowired
//	private Topic topic;

	@RequestMapping("sendQueue")
	public String sendQueueMessage(String message) {

		Queue queue = new ActiveMQQueue("queue1");
		String now = LocalDateTime.now().toString();
		this.sendMessage(queue, message + now);
		System.out.print("发送队列消息:" + message + now);
		return "success";
	}

	@RequestMapping("sendTopic")
	public String sendTopicMessage(String message) {
		Topic topic = new ActiveMQTopic("topic1");
		this.sendMessage(topic, message);

		return "success";
	}

	private void sendMessage(Destination destination, final String message) {
		for (int i = 0; i < 10000; i++) {
			jmsMessagingTemplate.convertAndSend(destination, message);
		}

	}

}
