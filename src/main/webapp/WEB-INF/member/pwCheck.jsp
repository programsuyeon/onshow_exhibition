<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/user.jsp" %>

<style>
	.w25 {
		width: 25%;
		display: inline-block;
	}
</style>

<div class="container">
	<h3 align=center style="padding:20px 0">본인확인</h3>
	<form:form commandName = "member" method="post" action ="pwcheck.me">
		<table border=1 class="table" style="width:auto; margin:0 auto;">
		
			<tr>
				<th class="table-secondary"><label for = "password">비밀번호</label></th>
				<td>
					<input class="form-control w50" type="password" name="password" min="1" required>
					<form:errors cssClass="err" path="password"/>
					
				</td>
			</tr>
			<tr align="center" class="table-primary">
				<td colspan=2><input class="btn btn-secondary" type="submit" value="비밀번호 확인"></td>
			</tr>
		
		</table>
	</form:form>
	
</div>
<%@ include file="../../WEB-INF/common/footer.jsp" %>