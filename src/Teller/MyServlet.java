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

              //设置文本类型
              response.setContentType("text/html");

              //设置传递和接收参数的编码
              response.setCharacterEncoding("GBK");
              request.setCharacterEncoding("GBK");

               //获得表单中的参数
              String value=request.getParameter("inputValue");

              //建立socket通信
              //连接服务器
              Socket s=new Socket(url,port);
              System.out.println("TELLER端已经成功的连接到ESB端！");
              //封装输入输出流
              PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
              BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
              //向socket通道写入消息
              pw.println(value);
              System.out.println("TELLER端已经成功的向ESB端发送消息  "+value);
              //从socket通道取出后端返回的结果
              String result=br.readLine();
              System.out.println("TELLER端已经成功的从ESB端接收到响应消息 " +result);
              //将结果返回给jsp页面显示
              request.getRequestDispatcher("../view.jsp?result="+result).forward(request, response);
     }
	
}
