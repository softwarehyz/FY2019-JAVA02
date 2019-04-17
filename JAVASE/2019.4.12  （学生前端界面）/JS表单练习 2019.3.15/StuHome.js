$(function () {

    $.ajax({
        url:" http://www.hyz.com/StudentSystem03/StudentSession" ,
        type:"get",
        dataType:"json",
        xhrFields: {withCredentials: true},
        crossDomain: true,
        withCredentials: true,
        success:function (res) {
            console.log(res);
            if(res.status==0){
                $(".banner").append(`
                <div class="welcomeinfo">欢迎:${res.data.name}</div>
                `)
            }else{

            }
        },
        error:function () {
            alert("服务器忙");
        }
    });

//查看所有课程
$(".AllCour").click(function () {
    $.ajax({
        url:"http://www.hyz.com/StudentSystem03/StudentChooseCourse?CourseOperation=1",
        type:"get",
        dataType:"json",
        xhrFields: {withCredentials: true},
        //数据请求成功后执行的方法
        success:function (res) {
            $("#add").remove();
            $("#add1").remove();
            $(".stutable").remove();
            if(res.status==0){
                $(".AllCourContent").append(`
                      <table  class="stutable" cellspacing="8" cellpadding="8" border="1">
                   <tr id="thead">
                    <td style="font-weight: 600">课程ID</td>
                    <td style="font-weight: 600">课程名</td>
                </tr>
                </table>
                   `);
                for(var i=0;i<res.data.length;i++){
                    $(".stutable").append(`
                       <tr class="tcontent">
                    <td>${res.data[i].cid}</td>
                    <td>${res.data[i].cname}</td>
                </tr>    
                       `)
                }
            }else{
                alert(res.msg);
            }
        },
        //数据请求失败后执行的方法
        error:function (res) {
            alert("服务器忙");
        }
    })

});//查看所有课程

//选择辅修课程
$(".AddCourse").click(function () {
    $(".stutable").remove();
    $("#add").remove();
    $("#add1").remove();
    $(".AllCourContent").append(`
          <form onsubmit="return false" id="add">
                <div class="AddInfo">
                    <div class="prompt">请输入选择课程ID</div><br>
                    <div >课程ID <input type="text" class="stuid"></div><br>       
                    <button type="submit" id="tijiao" class="tijiao">确定</button>
                </div>
            </form>
         `);

    $(".tijiao").click(function () {
        $.ajax({
            url:"http://www.hyz.com/StudentSystem03/UserServlet?UserChoice=2&BookOperation=2",
            type:"get",
            dataType:"json",
            xhrFields: {withCredentials: true},
            data:{
                "ID":parseInt($(".stuid").val()),
            },
            success:function (res) {
                $("#add").remove();
                alert(res.msg);
                $(".AllCourContent").append(`
          <form onsubmit="return false" id="add1">
                <div class="AddInfo">
                    <div class="prompt">您要选择的课程信息如下</div><br>
                    <div >课程ID <input type="text" class="name" readonly="true" placeholder=${res.data.cid }></div><br>
                    <div>课程名称 <input type="text" placeholder=${res.data.cname} readonly="true"></div><br>
                    <button type="submit" id="tijiao" class="tijiao">确认选择</button>
                </div>
            </form>
         `);
                $(".tijiao").click(function () {
                    $.ajax({
                        url:"http://www.hyz.com/StudentSystem03/StudentChooseCourse?CourseOperation=2",
                        type:"get",
                        dataType:"json",
                        xhrFields: {withCredentials: true},
                        data:{
                            "Cid":res.data.cid,
                        },
                        success:function (res) {
                            alert(res.msg);
                        },
                        error:function () {
                            alert("服务器忙");
                        }
                    })
                });

            },
            error:function () {
                alert("服务器忙");
            }
        })
    });
});
//选择辅修课程


//删除已选课程
$(".DelCourse").click(function () {
    $(".stutable").remove();
    $("#add").remove();
    $("#add1").remove();
    $(".AllCourContent").append(`
        <div class="AddInfo">
         <form onsubmit="return false" id="add1">
                    <div class="prompt">请输入删除课程ID</div><br>
                    <div >课程ID <input type="text" class="stuid"></div><br>
                    <button type="submit" id="tijiao1" class="tijiao1">提交</button> 
                </div>  
       </form>    
        `);
    $(".tijiao1").click(function () {
        $.ajax({
            url:"http://www.hyz.com/StudentSystem03/StudentChooseCourse?CourseOperation=3",
            type:"get",
            dataType:"json",
            xhrFields: {withCredentials: true},
            data:{
                "Cid":parseInt($(".stuid").val()),
            },
            success:function (res) {
                $("#add1").remove();
                alert(res.msg);
            },
            error:function () {
                alert("服务器忙");
            }
        })

    });
});
//删除已选课程

//查看已选课程
$(".ViewCourse").click(function () {
    $(".stutable").remove();
    $("#add").remove();
    $("#add1").remove();

        $.ajax({
            url:"http://www.hyz.com/StudentSystem03/StudentChooseCourse?CourseOperation=4",
            type:"get",
            dataType:"json",
            xhrFields: {withCredentials: true},
            success:function (res) {
                if(res.status==0){
                    $(".AllCourContent").append(`
                      <table  class="stutable" cellspacing="8" cellpadding="8" border="1">
                   <tr id="thead">
                    <td style="font-weight: 600">课程ID</td>
                    <td style="font-weight: 600">课程名</td>
                </tr>
                </table>
                   `);
                    for(var i=0;i<res.data.length;i++){
                        $(".stutable").append(`
                       <tr class="tcontent">
                    <td>${res.data[i].cid}</td>
                    <td>${res.data[i].cname}</td>
                </tr>    
                       `)
                    }
                }else{
                    alert(res.msg);
                }
            },
            error:function () {
                alert("服务器忙");
            }
        })
});
//查看已选课程

});