package Core;

import ESB.JMSToolsOperate;

public class CoreServer {
	
	public static void main(String[] args){
		  System.out.println("CORE���Ѿ�������");
		  JMSToolsOperate tools=new JMSToolsOperate();
		  while(true){
			//����Ϣ������ȡ����Ϣ
				 String message=tools.receiveMsg("E2C");
				 System.out.println("CORE���Ѿ��ɹ��Ĵ���Ϣ����E2C��ȡ����Ϣ "+message );
				 //����Ϣ���д���
				 String newMsg=message.toUpperCase();
				 System.out.println("CORE���Ѿ��ɹ��Ĵ�����Ϣ��");
				 
				 //��������������Ϣ����
				 tools.sendMsg(newMsg, "C2E");
				 System.out.println("CORE���Ѿ��ɹ�������Ϣ����C2E�з��ʹ�������Ϣ "+newMsg); 
		  }
		
		 
	}

}
