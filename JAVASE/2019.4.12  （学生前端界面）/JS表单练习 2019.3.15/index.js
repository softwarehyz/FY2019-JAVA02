$(function () {
    $("#login").click(function () {

    var rule=$('input:radio[name="User"]:checked').val();
    var url="";
    if(rule==1){
        url="http://www.hyz.com/StudentSystem03/LoginServlet";
    }else{
        url="http://www.hyz.com//StudentSystem03/StudentLoginServlet";
    }
    $.ajax({
        url:url,
        type:"get",
        dataType:"json",
        xhrFields: {withCredentials: true},
        data:{
            "operation":"1",
            "username":$(".username").val(),
            "password":$(".password").val(),
        },
        success:function(res){

            if(res.status==0){
                //学生跳转到学生主页
                if(rule==2){
                    window.location.href="StuHome.html";
                }else{
                    window.location.href="TeacHome.html";
                }
            }else{
                alert(res.msg);
            }
        },
        error:function (res) {
            alert("服务器忙");
        }
    })
    })
});