<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="bean" class="pack.board.BoardBean"/>
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="boardMgr" class="pack.board.BoardManager"/>
<%
String spage=request.getParameter("page");
int num=bean.getNum();
int gnum=bean.getGnum();
int onum=bean.getOnum()+1; //댓글이니까 1증가시킴
int nested=bean.getNested()+1; //댓글이니까 1증가시킴

//같은 그룹 내에서 새로운 댓글의 onum보다 크거나 같은 값을 댓글 입력 전에 먼저 수정하기
//작으면 수정 안함

boardMgr.updateOnum(gnum,onum); //onum 갱신

//댓글 자료 저자
bean.setOnum(onum);
bean.setNested(nested);
bean.setBip(request.getRemoteAddr());
bean.setBdate();
bean.setNum(boardMgr.currentGetMaxNum()+1); //댓(새)글의 num

boardMgr.saveReplyData(bean);
response.sendRedirect("boardlist.jsp?page="+spage); //댓글 작성 후 글 목록 보기로 이동
%>