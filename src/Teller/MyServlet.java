package Teller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	
	   private String url="127.0.0.1";
	   private int port=8888;
	
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
                     this.doService(request, response);
       }


       public void doPost(HttpServletRequest request, HttpServletResponse response)
	              throws ServletException, IOException {
                     this.doService(request, response);
       }

       public void doService(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

              //�����ı�����
              response.setContentType("text/html");

              //���ô��ݺͽ��ղ����ı���
              response.setCharacterEncoding("GBK");
              request.setCharacterEncoding("GBK");

               //��ñ��еĲ���
              String value=request.getParameter("inputValue");

              //����socketͨ��
              //���ӷ�����
              Socket s=new Socket(url,port);
              System.out.println("TELLER���Ѿ��ɹ������ӵ�ESB�ˣ�");
              //��װ���������
              PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
              BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
              //��socketͨ��д����Ϣ
              pw.println(value);
              System.out.println("TELLER���Ѿ��ɹ�����ESB�˷�����Ϣ  "+value);
              //��socketͨ��ȡ����˷��صĽ��
              String result=br.readLine();
              System.out.println("TELLER���Ѿ��ɹ��Ĵ�ESB�˽��յ���Ӧ��Ϣ " +result);
              //��������ظ�jspҳ����ʾ
              request.getRequestDispatcher("../view.jsp?result="+result).forward(request, response);
     }
	
}
