<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productMgr" class="pack.product.ProductManager"/>
<%
request.setCharacterEncoding("utf-8");
String flag=request.getParameter("flag");
boolean result=false;

if(flag.equals("insert")){
	result=productMgr.insertProduct(request);
}else if(flag.equals("update")){
	result=productMgr.updateProduct(request);
}else if(flag.equals("delete")){
	result=productMgr.deleteProduct(request.getParameter("no"));	
}else{
	response.sendRedirect("productmanager.jsp");
}

if(result){
%>
	<script>
	alert("정상 처리");
	location.href="productmanager.jsp";
	</script>
<%}else{%>
	<script>
	alert("오류 발생\n관리자에게 문의 바람");
	location.href="productmanager.jsp";
	</script>

<%	
}
%>