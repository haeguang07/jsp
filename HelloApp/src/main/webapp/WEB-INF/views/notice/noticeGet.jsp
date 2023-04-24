<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>상세 페이지(noticeGet.jsp)</h3>
<style>
	#content {
		padding: 15px auto;
	}
</style>
<form action="modifyNotice.do" method="get">
	<table class="table">

		<tr>
			<th>글번호</th>
			<td><input type="text" name="nid" value="${noticeInfo.noticeId}" readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${noticeInfo.noticeTitle}" readonly></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="subject" rows="3" cols="25" readonly="readonly">${noticeInfo.noticeSubject}</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="${noticeInfo.noticeWriter}" readonly></td>
		</tr>
		<tr style="display: 'none'">
			<th>첨부파일 ${fileType}</th>
			<td>
				<c:if test="${noticeInfo.attachFile !=null}">
					<c:choose>
						<c:when test="${fileType =='image'}">
							<img width="200px" height="200px" src="images/${noticeInfo.attachFile }">
						</c:when>
						<c:otherwise>
							<a href="images/${noticeInfo.attachFile}">${noticeInfo.attachFile}</a>
						</c:otherwise>
					</c:choose>

				</c:if>
			</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${noticeInfo.noticeDate }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<c:choose>
					<c:when test="${memberInfo.name== noticeInfo.noticeWriter}">
						<button type="submit">수정</button>
					</c:when>
					<c:otherwise>
						<button disabled="disabled" type="submit">수정</button>
					</c:otherwise>
				</c:choose>
				<button type="button" onclick="location.href='noticeList.do?page=${pageNum}'">
					목록 ${pageNum}</button>
			</td>
		</tr>
	</table>

</form>
<!-- 댓글등록 -->
<div id="content">
	<span>${memberInfo.name}</span>
	<input type="text" id="reply">
	<button type="button" id="addBtn">등록</button>
</div>
<!-- 댓글 정보 -->
<table class="table">
	<thead>
		<tr>
			<th>댓글번호</th>
			<th>작성자</th>
			<th>글내용</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody id="tlist">

	</tbody>
</table>

<script>
	let showFields = ['replyId', 'replyWriter', 'reply']
	let xhtp = new XMLHttpRequest();
	xhtp.open('get', 'replyList.do?nid=${noticeInfo.noticeId}');
	xhtp.send();
	xhtp.onload = function () {
		console.log(xhtp.response);
		//목록생성
		let tlist = document.querySelector('#tlist');
		let data = JSON.parse(xhtp.response); //json ->object
		for (let reply of data) {
			console.log(reply);
			let tr = makeTrFunc(reply);
			tlist.append(tr);
		}
	}
	//등록 이벤트
	document.querySelector('#addBtn').addEventListener('click', addReplyFnc);

	function addReplyFnc(e) {
		if("${memberInfo.email}"==null){
			alert('로그인후 등록가능');
			location.href="loginForm.do";
			return;
		}
		//console.log('click',e);
		console.log('reply', document.querySelector('#reply').value)
		console.log('id', "${memberInfo.email}");
		let reply = document.querySelector('#reply').value;

		//Ajax 호출
		xhtp = new XMLHttpRequest();
		xhtp.open('post', 'addReply.do');
		xhtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhtp.send('id=${memberInfo.email }&reply=' + reply + "&noticeId=${noticeInfo.noticeId}");
		xhtp.onload = function () {
			console.log(xhtp.response);
			let result = JSON.parse(xhtp.response);
			if (result.retCode == 'Success') {
				//값을 이용해서 tr생성
				let tr = makeTrFunc(result.data);
				tlist.append(tr);
			} else if (result.retCode == 'Fail') {
				//alert('처리중 에러')
			}
		}

	}
	//tr생성해주는 함수
	function makeTrFunc(reply = {}) {
		let tr = document.createElement('tr');
		for (let prop of showFields) {
			let td = document.createElement('td');
			td.innerText = reply[prop];
			tr.append(td);
		}
		//삭제버튼
		let btn = document.createElement('button');
		btn.addEventListener('click',function(e){
			//db에서 삭제 화면에서 삭제.
			let xhtp =new XMLHttpRequest();
			xhtp.open('post','removeReply.do');
			xhtp.setRequestHeader('Content-type','application/x-www-form-urlencoded');
			console.log(btn.parentElement.parentElement.children[0].innerText);
			xhtp.send('rid='+btn.parentElement.parentElement.children[0].innerText);
			xhtp.onload = function(){
				let result = JSON.parse(xhtp.response);
				console.log(result);
				if(result.retCode == 'Success'){
					//화면에서 지우기.
					btn.parentElement.parentElement.remove();
				}else if(result.retCode =='Fail'){
					alert('처리중 에러발생');
				}else{
					alert('알수 없는 결과값입니다');
				}
			}
		})
		btn.innerText='삭제';
		let td = document.createElement('td');
		td.append(btn);
		tr.append(td)
		return tr; //생성한 tr을 반환
	}
</script>