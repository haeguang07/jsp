<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form action="email.do">
<ul>
<li><label for="email">�̸��� �Է�</label>
<input type="email" name="email" value="${email}"></li>
<li><input type="submit" value="��������"></li>
</ul>
</form>
<form action="check.do">
<fieldset>
<legend>������ȣ Ȯ��</legend>
<label>������ȣ</label><input type="text" name="certification">
<c:if test="${random}!=null">
<input style="display: disable" name="random" value="${random}">
</c:if>

<button type="button" onclick="${(random=decument.quaryselector(input[name=certification]).innertext) ? 'check.do':alert('��������)'}" >����</button>
</fieldset>
</form>