$(function () {

     $.ajax({
         //
        url:" http://www.hyz.com/StudentSystem03/session" ,
         type:"get",
         dataType:"json",
         xhrFields: {withCredentials: true},
         success:function (res) {
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


    //查看所有学生
   $(".AllStu").click(function () {
       $.ajax({
           url:"http://www.hyz.com/StudentSystem03/StudentServlet?ViewWay=1",
           type:"get",
           dataType:"json",
           xhrFields: {withCredentials: true},
           //数据请求成功后执行的方法
           success:function (res) {
               $(".stutable ").remove();
               $("#add").remove();
               $("#add1").remove();
               if(res.status==0){
                   $(".AllCourContent").append(`
                    <table  class="stutable" cellspacing="8" cellpadding="8" border="1">
                   <tr id="thead">
                    <td style="font-weight: 600">学号</td>
                    <td style="font-weight: 600">姓名</td>
                    <td style="font-weight: 600">性别</td>
                    <td style="font-weight: 600">成绩</td>
                    <td style="font-weight: 600">年龄</td>
                    <td style="font-weight: 600">年级</td>
                    <td style="font-weight: 600">住址</td>
                    <td style="font-weight: 600">联系方式</td>
                    <td style="font-weight: 600">邮箱</td>
                </tr>
                </table>
                   `);
                   for(var i=0;i<res.data.length;i++){
                       $(".stutable").append(`
                       <tr class="tcontent">
                    <td>${res.data[i].stuid}</td>
                    <td>${res.data[i].name}</td>
                    <td>${res.data[i].sex}</td>
                    <td>${res.data[i].score}</td>
                    <td>${res.data[i].age}</td>
                    <td>${res.data[i].grade}</td>
                    <td>${res.data[i].addr}</td>
                    <td>${res.data[i].phone}</td>
                    <td>${res.data[i].email}</td>
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

   });
   //查看所有学生

    //添加学生
     $(".AddStu").click(function () {
         $(".stutable").remove();
         $("#add").remove();
         $("#add1").remove();
         $(".AllCourContent").append(`
          <form onsubmit="return false" id="add">
                <div class="AddInfo">
                    <div class="prompt">请输入添加学生信息</div><br>
                    <div >学号 <input type="text" class="stuid"></div><br>
                    <div >姓名 <input type="text" class="name"></div><br>
                    <div>性别 <select name="sex" id="sex">
                        <option value ="男">男</option>
                        <option value ="女">女</option>
                    </select>
                    </div><br>
                    <div >成绩 <input type="text" class="score"></div><br>
                    <div >年龄 <input type="text" class="age"></div><br>
                    <div class="grade">年级<select name="grade" id="grade">
                        <option value ="初级">初级</option>
                        <option value ="中级">中级</option>
                        <option value ="高级">高级</option>
                    </select></div><br>
                    <div >住址 <input type="text" class="addr"></div><br>
                    <div>电话 <input type="text"  class="phone"></div><br>
                    <div >邮箱 <input type="text" class="email"></div><br>
                    <button type="submit" id="tijiao" class="tijiao">提交</button>
                </div>
            </form>
         `);

         $(".tijiao").click(function () {
             $.ajax({
                 url:"http://www.hyz.com/StudentSystem03/StudentServlet?ViewWay=3",
                 type:"get",
                 dataType:"json",
                 xhrFields: {withCredentials: true},
                 data:{
                     "stuid":parseInt($(".stuid").val()),
                     "name":$(".name").val(),
                     "sex":$("#sex").val(),
                     "score":parseInt($(".score").val()),
                     "age":parseInt($(".age").val()),
                     "grade":$("#grade").val(),
                     "addr":$(".addr").val(),
                     "phone":$(".phone").val(),
                     "email":$(".email").val(),
                 },
                 success:function (res) {

                     alert(res.msg);
                 },
                 error:function () {
                     alert("服务器忙");
                     }
             })
         });
     });

    //添加学生

    //修改学生
    $(".AltStu").click(function () {
        $(".stutable").remove();
        $("#add").remove();
        $("#add1").remove();
        $(".AllCourContent").append(`
        <div class="AddInfo">
         <form onsubmit="return false" id="add1">
                    <div class="prompt">请输入修改学生学号</div><br>
                    <div >学号 <input type="text" class="stuid"></div><br>
                    <button type="submit" id="tijiao1" class="tijiao1">提交</button> 
                </div>  
       </form>    
        `);
      $(".tijiao1").click(function () {
          $.ajax({
              url:"http://www.hyz.com/StudentSystem03/StudentServlet?ViewWay=2",
              type:"get",
              dataType:"json",
              xhrFields: {withCredentials: true},
              data:{
                  "ID":parseInt($(".stuid").val()),
              },
              success:function (res) {
                  alert(res.msg);
                  $("#add1").remove();
                  $(".AllCourContent").append(`
          <form onsubmit="return false" id="add">
                <div class="AddInfo">
                    <div class="prompt">请输入修改学生信息</div><br>
                    <div >姓名 <input type="text" class="name" placeholder=${res.data.name}></div><br>
                    <div>性别 <select name="sex" id="sex">
                        <option value ="男">男</option>
                        <option value ="女">女</option>
                    </select>
                    </div><br>
                    <div >成绩 <input type="text" class="score"  placeholder=${res.data.score}></div><br>
                    <div >年龄 <input type="text" class="age"  placeholder=${res.data.age}></div><br>
                    <div class="grade">年级<select name="grade" id="grade">
                        <option value ="初级">初级</option>
                        <option value ="中级">中级</option>
                        <option value ="高级">高级</option>
                    </select></div><br>
                    <div >住址 <input type="text" class="addr"  placeholder=${res.data.addr}></div><br>
                    <div>电话 <input type="text"  class="phone"  placeholder=${res.data.phone}></div><br>
                    <div >邮箱 <input type="text" class="email"  placeholder=${res.data.email}></div><br>
                    <button type="submit" id="tijiao" class="tijiao">提交</button>
                </div>
            </form>
         `);

                  $(".tijiao").click(function () {
                      $.ajax({
                          url:"http://www.hyz.com/StudentSystem03/StudentServlet?ViewWay=5",
                          type:"get",
                          dataType:"json",
                          xhrFields: {withCredentials: true},
                          data:{
                              "altID":parseInt(res.data.stuid),
                              "name":$(".name").val(),
                              "sex":$("#sex").val(),
                              "score":parseInt($(".score").val()),
                              "age":parseInt($(".age").val()),
                              "grade":$("#grade").val(),
                              "addr":$(".addr").val(),
                              "phone":$(".phone").val(),
                              "email":$(".email").val(),
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

        // $(".AllCourContent").append(`
        //   <form onsubmit="return false" id="add">
        //         <div class="AddInfo">
        //             <div class="prompt">请输入修改学生信息</div><br>
        //             <div >学号 <input type="text" class="stuid"></div><br>
        //             <div >姓名 <input type="text" class="name"></div><br>
        //             <div>性别 <select name="sex" id="sex">
        //                 <option value ="男">男</option>
        //                 <option value ="女">女</option>
        //             </select>
        //             </div><br>
        //             <div >成绩 <input type="text" class="score"></div><br>
        //             <div >年龄 <input type="text" class="age"></div><br>
        //             <div class="grade">年级<select name="grade" id="grade">
        //                 <option value ="初级">初级</option>
        //                 <option value ="中级">中级</option>
        //                 <option value ="高级">高级</option>
        //             </select></div><br>
        //             <div >住址 <input type="text" class="addr"></div><br>
        //             <div>电话 <input type="text"  class="phone"></div><br>
        //             <div >邮箱 <input type="text" class="email"></div><br>
        //             <button type="submit" id="tijiao" class="tijiao">提交</button>
        //         </div>
        //     </form>
        //  `);
        //
        // $(".tijiao").click(function () {
        //     $.ajax({
        //         url:"http://www.hyz.com/StudentSystem03/StudentServlet?ViewWay=3",
        //         type:"get",
        //         dataType:"json",
        //         data:{
        //             "stuid":parseInt($(".stuid").val()),
        //             "name":$(".name").val(),
        //             "sex":$("#sex").val(),
        //             "score":parseInt($(".score").val()),
        //             "age":parseInt($(".age").val()),
        //             "grade":$("#grade").val(),
        //             "addr":$(".addr").val(),
        //             "phone":$(".phone").val(),
        //             "email":$(".email").val(),
        //         },
        //         success:function (res) {
        //
        //             alert(res.msg);
        //         },
        //         error:function () {
        //             alert("服务器忙");
        //         }
        //     })
        // });
    });

    //修改学生

    //删除学生
    $(".DelStu").click(function () {
        $(".stutable").remove();
        $("#add").remove();
        $("#add1").remove();
        $(".AllCourContent").append(`
        <div class="AddInfo">
         <form onsubmit="return false" id="add1">
                    <div class="prompt">请输入删除的学生学号</div><br>
                    <div >学号 <input type="text" class="stuid"></div><br>
                    <button type="submit" id="tijiao1" class="tijiao1">提交</button> 
                </div>  
       </form>    
        `);
        $(".tijiao1").click(function () {
            $.ajax({
                url:"http://www.hyz.com/StudentSystem03/StudentServlet?ViewWay=2",
                type:"get",
                dataType:"json",
                xhrFields: {withCredentials: true},
                data:{
                    "ID":parseInt($(".stuid").val()),
                },
                success:function (res) {
                    alert(res.msg);
                    $("#add1").remove();
                    $(".AllCourContent").append(`
          <form onsubmit="return false" id="add">
                <div class="AddInfo">
                    <div class="prompt">您要删除的学生信息如下</div><br>
                    <div >姓名 <input type="text" class="name" readonly="true" placeholder=${res.data.name }></div><br>
                    <div>性别 <input type="text" placeholder=${res.data.sex } readonly="true">
                    </div><br>
                    <div >成绩 <input type="text" class="score"  placeholder=${res.data.score} readonly="true"></div><br>
                    <div >年龄 <input type="text" class="age"  placeholder=${res.data.age} readonly="true"></div><br>
                    <div class="grade">年级 <input type="text" placeholder=${res.data.grade} readonly="true"></div><br>
                    <div >住址 <input type="text" class="addr"  placeholder=${res.data.addr} readonly="true"></div><br>
                    <div>电话 <input type="text"  class="phone"  placeholder=${res.data.phone} readonly="true"></div><br>
                    <div >邮箱 <input type="text" class="email"  placeholder=${res.data.email} readonly="true"></div><br>
                    <button type="submit" id="tijiao" class="tijiao">确认删除</button>
                </div>
            </form>
         `);

                    $(".tijiao").click(function () {
                        $.ajax({
                            url:"http://www.hyz.com/StudentSystem03/StudentServlet?ViewWay=4",
                            type:"get",
                            dataType:"json",
                            xhrFields: {withCredentials: true},
                            data:{
                                "delID":parseInt(res.data.stuid),
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
    //删除学生


    //查看所有课程
    $(".AllCour").click(function () {
        $.ajax({
            url:"http://www.hyz.com/StudentSystem03/UserServlet?UserChoice=2&BookOperation=1",
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

    //添加课程
    $(".AddCourse").click(function () {
        $(".stutable").remove();
        $("#add").remove();
        $("#add1").remove();
        $(".AllCourContent").append(`
          <form onsubmit="return false" id="add">
                <div class="AddInfo">
                    <div class="prompt">请输入添加课程信息</div><br>
                    <div >课程ID <input type="text" class="stuid"></div><br>
                    <div >课程名称 <input type="text" class="name"></div><br>                 
                    <button type="submit" id="tijiao" class="tijiao">添加</button>
                </div>
            </form>
         `);

        $(".tijiao").click(function () {
            $.ajax({
                url:"http://www.hyz.com/StudentSystem03/UserServlet?UserChoice=2&BookOperation=3",
                type:"get",
                dataType:"json",
                xhrFields: {withCredentials: true},
                data:{
                    "ID":parseInt($(".stuid").val()),
                    "Cname":$(".name").val(),
                },
                success:function (res) {

                    alert(res.msg);
                },
                error:function () {
                    alert("服务器忙");
                }
            })
        });
    });
    //添加课程


    //修改课程
    $(".AltCourse").click(function () {
        $(".stutable").remove();
        $("#add").remove();
        $("#add1").remove();
        $(".AllCourContent").append(`
        <div class="AddInfo">
         <form onsubmit="return false" id="add1">
                    <div class="prompt">请输入修改课程ID</div><br>
                    <div >课程ID <input type="text" class="stuid"></div><br>
                    <button type="submit" id="tijiao1" class="tijiao1">提交</button> 
                </div>  
       </form>    
        `);
        $(".tijiao1").click(function () {
            $.ajax({
                url:"http://www.hyz.com/StudentSystem03/UserServlet?UserChoice=2&BookOperation=2",
                type:"get",
                dataType:"json",
                xhrFields: {withCredentials: true},
                data:{
                    "ID":parseInt($(".stuid").val()),
                },
                success:function (res) {
                    alert(res.msg);
                    $("#add1").remove();
                    $(".AllCourContent").append(`
          <form onsubmit="return false" id="add">
                <div class="AddInfo">
                    <div class="prompt">请输入修改课程信息</div><br>
                    <div >课程名称 <input type="text" class="name" placeholder=${res.data.cname}></div><br>
                    <button type="submit" id="tijiao" class="tijiao">提交</button>
                </div>
            </form>
         `);

                    $(".tijiao").click(function () {
                        $.ajax({
                            url:"http://www.hyz.com/StudentSystem03/UserServlet?UserChoice=2&BookOperation=4",
                            type:"get",
                            dataType:"json",
                            xhrFields: {withCredentials: true},
                            data:{
                                "ID":parseInt(res.data.cid),
                                "Cname":$(".name").val(),
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
    //修改课程

    //删除课程
    $(".DelCourse").click(function () {
        $(".stutable").remove();
        $("#add").remove();
        $("#add1").remove();
        $(".AllCourContent").append(`
        <div class="AddInfo">
         <form onsubmit="return false" id="add1">
                    <div class="prompt">请输入删除的课程ID</div><br>
                    <div >课程ID <input type="text" class="stuid"></div><br>
                    <button type="submit" id="tijiao1" class="tijiao1">提交</button> 
                </div>  
       </form>    
        `);
        $(".tijiao1").click(function () {
            $.ajax({
                url:"http://www.hyz.com/StudentSystem03/UserServlet?UserChoice=2&BookOperation=2",
                type:"get",
                dataType:"json",
                xhrFields: {withCredentials: true},
                data:{
                    "ID":parseInt($(".stuid").val()),
                },
                success:function (res) {
                    alert(res.msg);
                    $("#add1").remove();
                    $(".AllCourContent").append(`
          <form onsubmit="return false" id="add">
                <div class="AddInfo">
                    <div class="prompt">您要删除的课程信息如下</div><br>
                    <div >课程ID <input type="text" class="name" readonly="true" placeholder=${res.data.cid }></div><br>
                    <div>课程名称 <input type="text" placeholder=${res.data.cname} readonly="true"></div><br>
                    <button type="submit" id="tijiao" class="tijiao">确认删除</button>
                </div>
            </form>
         `);

                    $(".tijiao").click(function () {
                        $.ajax({
                            url:"http://www.hyz.com/StudentSystem03/UserServlet?UserChoice=2&BookOperation=5",
                            type:"get",
                            dataType:"json",
                            xhrFields: {withCredentials: true},
                            data:{
                                "ID":parseInt(res.data.cid),
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
    //删除课程

});