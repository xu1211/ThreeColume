package ESB;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSToolsOperate {
	// ���岢�������ӹ���
	private ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
	// ���嵽��Ϣ���е�����
	private Connection connection;
	// ���屾�����ӵĻỰ
	private Session session;

	public void sendMsg(String message, String queueName) {
		try {
			// ��������
			connection = factory.createConnection();
			// ������
			connection.start();
			// �����������ӵĻỰ
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// ����һ����Ϣ���У���������д�����ʹ��֮�����򴴽�֮
			Destination queue = session.createQueue(queueName);
			// ����һ����Ϣ
			Message msg = session.createTextMessage(message);
			// ����һ��������,����Ϣ�ķ����ߣ���ָ����Ҫ������Ϣ��Ŀ�ĵأ�����Ϣ���У�
			MessageProducer producer = session.createProducer(queue);
			// ������Ϣ
			producer.send(msg);
			// �ͷ���Դ

		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				session.close();
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public String receiveMsg(String queueName) {
		String message = null;
		try {
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination queue = session.createQueue(queueName);
			// ����һ����Ϣ�������ߣ�����Ϣ�Ľ����ߣ���ָ�����Ľ���Ŀ�ĵأ������ĸ���Ϣ������ȡ��Ϣ��
			MessageConsumer consumer = session.createConsumer(queue);
			// ������Ϣ
			message = ((TextMessage) consumer.receive()).getText();
			// �ͷ���Դ
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				session.close();
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		return message;
	}
}
