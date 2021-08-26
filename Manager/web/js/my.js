document.getElementById("regist").onsubmit = function () {
    let loginname = document.getElementById("loginname").value;
    let password = document.getElementById("password").value;
    let l1 = /^[a-zA-Z]{4,8}$/;
    let l2 = /[a-zA-Z]+/;
    let l3 = /[0-9]+/;
    let p = /^[a-zA-Z0-9]{4,16}$/;
    if (!l1.test(loginname) && !l2.test(loginname) && l3.test(loginname)) {
        alert("登录名必须只能由数字和字母组成且长度为4-8");
        return false;
    }
    if (!p.test(password)) {
        alert("密码必须是长度4-16的英语字母或数字");
        return false;
    }
    return true;
}