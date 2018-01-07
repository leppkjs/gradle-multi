<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 유저가 입력하는 form -->
<form action="/kai-server/main/login" method="post" id="loginForm">
    <fieldset>
        <legend class="screen_out">로그인 폼</legend>
 
        <label for="email">이메일</label>
        <input type="text" id="email" name="email" autofocus autocomplete="off" required />
 
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" autocomplete="off" required />
 
        <button type="submit">
            <i class="fa fa-sign-in"></i> 로그인
        </button>
    </fieldset>
</form>
 
<!-- 실제 서버로 전송되는 form -->
<form action="/kai-server/main/login" method="post" id="hiddenForm">
    <fieldset>
        <input type="hidden" name="email" />
        <input type="hidden" name="password" />
    </fieldset>
</form>

<!-- javascript lib load -->
<script src="<c:url value="/js/jquery-3.2.1.min.js" />"></script>
<script src="<c:url value="/js/rsa/jsbn.js" />"></script>
<script src="<c:url value="/js/rsa/prng4.js" />"></script>
<script src="<c:url value="/js/rsa/rng.js" />"></script>
<script src="<c:url value="/js/rsa/rsa.js" />"></script>

<script>
var modulus  = "${modulus}";
var exponent = "${exponent}";
</script>

<script src="<c:url value="/main/js/login.js" />"></script>