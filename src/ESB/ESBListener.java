package ESB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ESBListener implements Runnable {

	private JMSToolsOperate tools=new JMSToolsOperate();
	private Socket s;
	
	public ESBListener(Socket s){
		this.s=s;
	}
	
	public void run() {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			//���մ�TELLER�˷�������Ϣ
			String reMsg=br.readLine();
			System.out.println("ESB���Ѿ��ɹ��Ľ��յ�TELLER�˵�������Ϣ "+reMsg);
			//����Ϣ������Ϣ����E2C��
			tools.sendMsg(reMsg, "E2C");
			System.out.println("ESB���Ѿ��ɹ�������Ϣ����E2C������Ϣ "+reMsg);
			
			//����Ϣ����C2E��ȡ����Ϣ
			String result=tools.receiveMsg("C2E");
			System.out.println("ESB���Ѿ��ɹ��Ĵ���Ϣ����C2E��ȡ����Ӧ��Ϣ "+result);
			//��������Ϣ����TELLER��
			pw.println(result);
			System.out.println("ESB���Ѿ��ɹ�����TELLER�˷�����Ӧ��Ϣ "+result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
