<h2> 
<%
if(session.getAttribute("login")==null || session.getAttribute("login")=="")
{
	response.sendRedirect("Login.jsp");
}
%>
welcome,<%=session.getAttribute("login") %>
</h2>
<h3>
<a href="Logout.jsp">Logout</a>
</h3>