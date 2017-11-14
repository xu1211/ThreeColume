<%@ page language="java"  pageEncoding="utf-8"%>
<%String path = request.getContextPath();%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>首页</title>
    <style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
    </style>
</head>
  
  <body  bgcolor="#62C0EE" >
    <form action="<%=path%>/servlet/MyServlet" method="post">
	   <table bgcolor="D2E8FF" align="center" border="1">
	   <% String result=request.getParameter("result");
	       if(result==null)result=""; %>
	        
	        <tr style="font-size:large;"><td align="center">请输入&nbsp;&nbsp; Hello Word!：</td><td ><input type="text" name="inputValue" style="font-size: medium;"></td></tr>
	      
	        <tr style="font-size:large;"><td colspan="2" align="center"><input type="submit" value="提交" style="font-size: medium;"/>|<input type="reset" value="重置" style="font-size: medium;"/></td></tr>
	        
	          <tr style="font-size:large;"><td align="center">执行结果&nbsp;&nbsp;&nbsp;&nbsp;：</td>
	            <td><input name="result" type="text" class="STYLE1" style="font-size: medium;"  value="<%=result %>"></td>
	          </tr>
	  </table>
  </form>
  </body>
</html>

