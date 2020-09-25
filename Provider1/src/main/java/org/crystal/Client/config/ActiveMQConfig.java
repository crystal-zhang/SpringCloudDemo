package org.crystal.Client.config;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQPrefetchPolicy;
import org.apache.activemq.RedeliveryPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

@Configuration
public class ActiveMQConfig {
	// 在Queue模式中，对消息的监听需要对containerFactory进行配置
	@Bean("queueListener")
	public JmsListenerContainerFactory<?> queueJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setPubSubDomain(false);
		// 是否开启事务
		factory.setSessionTransacted(false);
		// 消息确认方式
		factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
		//factory.setSubscriptionDurable(true);
		return factory;
	}

	// 在Topic模式中，对消息的监听需要对containerFactory进行配置
	@Bean("topicListener")
	public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(ConnectionFactory connectionFactory) throws JMSException {

		ActiveMQPrefetchPolicy prefetchPolicy = new ActiveMQPrefetchPolicy();
		prefetchPolicy.setTopicPrefetch(10);//每次取10条消息

		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setClientId("AAAA");
		factory.setPubSubDomain(true);//发布订阅模式
		factory.setSubscriptionDurable(true);// 持久化
		factory.setConnectionFactory(connectionFactory);
		return factory;
	}

	/**
	 * 重发机制
	 * 
	 * @return
	 */
	@Bean
	public RedeliveryPolicy redeliveryPolicy() {
		RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
		/*
		 * redeliveryPolicy.setMaximumRedeliveries(6);
		 * redeliveryPolicy.setMaximumRedeliveryDelay(1000);
		 */
		return redeliveryPolicy;
	}
}
