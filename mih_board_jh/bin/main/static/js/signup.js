function register() {
    var email = document.getElementsByName("userEmail")[0].value;
    var name = document.getElementsByName("userNm")[0].value;
    var password = document.getElementsByName("userPw")[0].value;
    var emailPattern = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;

    if (email == null || email == "" || email == /\s/g || emailPattern.test(email) === false || name == null || name == "" || name == /\s/g || password == null || password == "" || password == /\s/g) {
        alert("Check your Info");
        return false;
    }
}