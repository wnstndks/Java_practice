function zipCheck() {
	//alert("aa");
	let url = "zipcheck.jsp?check=y";
	window.open(url, "post",
		"toolbar=no,width=500,height=400,top=200,left=300,scrollbars=yes,menubar=no");
}

function idCheck() {
	if (regForm.id.value === "") {
		alert("id를 입력하시오");
		regForm.id.focus();
		return;
	}
	let url2 = "idcheck.jsp?id=" + regForm.id.value;
	window.open(url2, "id",
		"toolbar=no,width=300,height=150,top=200,left=300,scrollbars=yes,menubar=no");
}

function inputCheck() {
	//alert("cc");
	if (regForm.id.value === "") {
		alert("아이디를 입력하시오");
		regForm.id.focus();
		return false;
	}
	if (regForm.passwd.value==="") {
		alert("비밀번호 입력하세요!");
		regForm.passwd.focus();
		return false;
	}
	
	if (regForm.repasswd.value !== regForm.repasswd.value) {
		alert("비밀번호 불일치!");
		regForm.repasswd.focus();
		return false;
	}

	if (regForm.name.value === "") {
		alert("이름을 입력하시오");
		regForm.name.focus();
		return false;
	}

	//정규 표현식으로 이메일 검사
	var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
	if (!regForm.email.value.match(regExp)){
		alert("이메일을 정확히 입력하시오");
		regForm.email.focus();
		return;
	}

	//전화번호
	var regExp2 = /^\d{2,3}-\d{3,4}-\d{4}/;         //010-111-1234
	if (!regForm.phone.value.match(regExp2)) {
		alert("전화번호를 정확히 입력하시오");
		regForm.phone.focus();
		return;
	}
	
	if (regForm.job.value === "0") {
		alert("직업을 입력하시오");
		regForm.job.focus();
		return false;
	}
	
	document.regForm.submit();
}

//쇼핑몰 로그인 후 자신의 정보 수정용
function memberUpdate(){
	//입력자료 오류 검사후..그러나 생략
	document.upForm.submit();
}
function memberUpdateCancel(){
	location.href="../guest/guest_index.jsp";
}
function memberDelete(){
	alert("회원탈퇴는 죽음");
}


//관리자 회원 수정용
function memUpdate(id){
	//alert(id);
	document.updateFrm.id.value=id;
	document.updateFrm.submit();	
}

//관리자 상품처리용
function productDetail(no)
{
	//alert(no);
	document.detailFrm.no.value=no;
	document.detailFrm.submit();	
}

function productUpdate(no){
	document.updateForm.no.value=no;
	document.updateForm.submit();	
}
function productDelete(no){
	document.deleteForm.no.value=no;
	document.deleteForm.submit();	
}

//사용자에서 상품처리용
function productDetail_g(no)
{
	//alert(no);
	document.detailFrm.no.value=no;
	document.detailFrm.submit();	
}


//cart 처링용
function cartUpdate(form){
	//alert("a");
	form.flag.value="update";
	form.submit();
}
function cartDelete(form){
	//alert("aa");
	form.flag.value="del";
	form.submit();
}

//카트에서 사용
function productDetailCart(no)
{
	//alert(no);
	document.detailFrm.no.value=no;
	document.detailFrm.submit();	
}


//주문관리에서 사용
function orderDetail(no)
{
	//alert(no);
	document.detailFrm.no.value=no;
	document.detailFrm.submit();	
}

function orderUpdate(form){
	document.detailFrm.flag.value="update";
	form.submit();
}

function orderDelete(form){
	document.detailFrm.no.value="delete";
	form.submit();	
}
















