/**
 * 유저 입력 form의 submit event 재정의 
 */
var $email = $("#hiddenForm input[name='email']");
var $password = $("#hiddenForm input[name='password']");
 
    // Server로부터 받은 공개키 입력
var rsa = new RSAKey();
rsa.setPublic(modulus, exponent);
 
$("#loginForm").submit(function(e) {
    // 실제 유저 입력 form은 event 취소
    // javascript가 작동되지 않는 환경에서는 유저 입력 form이 submit 됨
    // -> Server 측에서 검증되므로 로그인 불가
    e.preventDefault();
 
    // 아이디/비밀번호 암호화 후 hidden form으로 submit
    var email = $(this).find("#email").val();
    var password = $(this).find("#password").val();
    $email.val(rsa.encrypt(email)); // 아이디 암호화
    $password.val(rsa.encrypt(password)); // 비밀번호 암호화
    $("#hiddenForm").submit();
});