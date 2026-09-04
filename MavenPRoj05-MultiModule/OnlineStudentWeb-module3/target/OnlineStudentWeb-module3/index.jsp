

<%@page import="com.nit.service.*"%>

<%
      ArithmeticOperations ar  = new ArithmeticOperations();
      int result = ar.sum(150,150);
%>
<h1> From Module3 :: Sum is <%=result %></h1>