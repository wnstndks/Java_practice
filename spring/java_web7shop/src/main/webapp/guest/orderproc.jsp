<%@page import="pack.order.OrderBean"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cartMgr" class="pack.order.CartManager" scope="session" />
<jsp:useBean id="productMgr" class="pack.product.ProductManager" />
<jsp:useBean id="orderMgr" class="pack.order.OrderManager"></jsp:useBean>

<%-- 장바구니에 담긴 상품 주문하기 --%>
<%
Hashtable hCart =cartMgr.getCartList();

Enumeration enu=hCart.keys();
if(hCart.size()==0){
	%>
	<script>
	alert("주문내용이 없어요");
	location.href="orderlist.jsp";
	</script>
	<%
}else{

	while(enu.hasMoreElements()){
		OrderBean orderBean =(OrderBean)hCart.get(enu.nextElement());
		orderMgr.insertOrder(orderBean); //카트에 내요을 주문 테이블에 저장
		productMgr.reduceProduct(orderBean); //주문수량만큼 상품 재고량에서 줄이기
		cartMgr.deleteCart(orderBean);
	}
	%>
	<script>
	alert("주문 처리가 잘 되었습니다.\n 고객님 사랑해요");
	location.href="orderlist.jsp";
	</script>
	<%
}
%>