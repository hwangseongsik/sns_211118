<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="shadow-box m-5">
		<div class="d-flex justify-content-center m-5">
			<form id="loginForm" action="/user/sign_in" method="post">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">ID</span>
					</div>
					<input type="text" class="form-control" name="loginId">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">Password</span>
					</div>
					<input type="password" class="form-control" name="password">
				</div>
				
				<input type="submit" class="btn btn-block btn-info" value="로그인">
				<a class="btn btn-block btn-dark" href="/user/sign_up_view">회원가입</a>
			</form>
		</div>
	</div>
</div>

<script>
$(document).ready(function() {
	$('#loginForm').submit(function(e) {
		e.preventDefault();
		
		var loginId = $('input[name=loginId]').val().trim();
		if (loginId == '') {
			alert("아이디를 입력해주세요.");
			return;
		}
		
		var password = $('input[name=password]').val();
		if (password == '') {
			alert("비밀번호를 입력해주세요.");
			return;
		}
		
		var url = $(this).attr("action");
		var data = $(this).serialize();
		
		$.post(url, data)
		.done(function(data) {
			if (data.result == "success") {
				location.href="/timeline/timeline_view"; 
			} else {
				alert(data.error_message);
			}
		}); 
	});
});
</script>
© 2022 GitHub, Inc.