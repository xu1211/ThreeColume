package Core;

import ESB.JMSToolsOperate;

public class CoreServer {
	
	public static void main(String[] args){
		  System.out.println("CORE端已经启动！");
		  JMSToolsOperate tools=new JMSToolsOperate();
		  while(true){
			//从消息队列中取出消息
				 String message=tools.receiveMsg("E2C");
				 System.out.println("CORE端已经成功的从消息队列E2C中取出消息 "+message );
				 //对消息进行处理
				 String newMsg=message.toUpperCase();
				 System.out.println("CORE端已经成功的处理消息！");
				 
				 //将处理结果放入消息队列
				 tools.sendMsg(newMsg, "C2E");
				 System.out.println("CORE端已经成功的向消息队列C2E中发送处理后的信息 "+newMsg); 
		  }
		
		 
	}

}
