package ESB;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ESBServer {
	
	private ServerSocket ss=null;
	private int port=8888;
	
	public ESBServer() throws IOException{
		//��������������ָ���˿ں�
		ss=new ServerSocket(port);
		System.out.println("ESB�˷������Ѿ��ɹ���������");
	}
	
	public void Communite(){
		
		try {
			//�����ͻ��˵��������󲢽��ܣ����û�н�һֱ�ȴ���ȥ
			while(true){
				Socket s=ss.accept();
				System.out.println("ESB���Ѿ��ɹ��Ľ��յ�һ���ͻ��˵���������");
				//�����յ��Ŀͻ������ӽ���һ���̴߳���
				new Thread(new ESBListener(s)).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException{
		//��������
		new ESBServer().Communite();
	}
	
	
	

}
