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
            url: config.register,
            data: data,
            dataType: "json",
            success: function (data) {
                console.log(data);
                // alert("success");
            },
            error: function (err) {
                // alert("error");
                console.log(data);
            }
        });
    });


});