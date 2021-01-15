function open_win(url, name){
	window.open(url, name, "width=500,height=230");
}

function modifyCheck(){
	if(document.frm.UPw.value.length ==0){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	if(document.frm.UAddr.value.length ==0){
		alert("주소를 입력하세요.");
		return false;
	}
	if(document.frm.UPhone.value.length ==0){
		alert("전화번호를 입력하세요");
		return false;
	}
	if(document.frm.UEmail.value.length ==0){
		alert("이메일을 입력하세요.");
		return false;
	}
	return true;
}
function joinCheck(){
	if(document.frm.UserId.value.length ==0){
		alert("아이디를 입력하세요.");
		return false;
	}
	if(document.frm.UName.value.length ==0){
		alert("이름를 입력하세요.");
		return false;
	}
	if(document.frm.UPw.value.length ==0){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	if(document.frm.UAddr.value.length ==0){
		alert("주소를 입력하세요.");
		return false;
	}
	if(document.frm.UPhone.value.length ==0){
		alert("전화번호를 입력하세요");
		return false;
	}
	if(document.frm.UEmail.value.length ==0){
		alert("이메일을 입력하세요.");
		return false;
	}
	return true;
}

function paddCheck(){
	if(document.frm.PName.value.length ==0){
		alert("상품명을 입력해주십시오.");
		return false;
	}
	if(document.frm.PPhoto.value.length ==0){
		alert("사진을 업로드해주십시오.");
		return false;
	}
	if(document.frm.PPrice.value.length ==0){
		alert("가격을 입력해주십시오.");
		return false;
	}
	if(document.frm.PClass1.value.length ==0){
		alert("1차 분류를 선택해 주십시오.");
		return false;
	}
	if(document.frm.PClass2.value.length ==0){
		alert("2차 분류를 선택해주십시오.");
		return false;
	}
	if(document.frm.PDetail.value.length >100){
		alert("최소 100글자 이상 설명해주십시오.");
		return false;
	}
	return true;
}


function passCheck(){
	if(document.frm.password.value.length==0){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}

function wrongPass(){
	alert("비밀번호를 입력하세요.");
	return false;
}