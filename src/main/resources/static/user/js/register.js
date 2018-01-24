$(function () {

    $("#register").click(function () {

        // window.open("creatCompany.html");

        var  data ={
            phone:$("#phone").val(),
            userName:$("#name").val(),
            password:$("#psw").val()
        };

        $.ajax({
            type: "POST",
            url: zydUrl.userlogin,
            data: data,
            dataType: "json",
            success: function (data) {
                alert("success");
            },
            error: function (err) {
                alert("error");
            }
        });
    });


});