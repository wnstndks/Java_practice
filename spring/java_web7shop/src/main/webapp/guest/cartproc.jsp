<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="cartMgr" class="pack.order.CartManager" scope="session"/>
<jsp:useBean id="order" class="pack.order.OrderBean"></jsp:useBean>
<jsp:setProperty property="*" name="order"/>
<%
String flag=request.getParameter("flag"); //구매목록 보기,수정,삭제 판단용
String id=(String)session.getAttribute("idKey");
//out.print(order.getProduct_no()+" "+order.getQuantity());

if(id==null){
	response.sendRedirect("../member/login.jsp"); //로그인을 안한 경우
}else{
	if(flag==null){
		//cart에 주문 상품 담기
		order.setId(id);
		cartMgr.addCart(order); //인수의 내용: prodcut_no,quantity,id
%>
	<Script>
	alert("장바구니담기 성공");
	location.href="cartlist.jsp";
	</Script>
<%
	}else if(flag.equals("update")){
		//out.print("u");
		order.setId(id);
		cartMgr.updateCart(order);
%>
	<Script>
	alert("장바구니 수정 성공");
	location.href="cartlist.jsp";
	</Script>
<%	
	}else if(flag.equals("del")){
		//out.print("d");
		cartMgr.deleteCart(order);
%>
	<Script>
	alert("해당 상품의 주문을 삭제했어요");
	location.href="cartlist.jsp";
	</Script>
		
<%
	}
}
%>














