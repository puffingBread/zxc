$(function(){
    //导航条样式
    $("ul.nav-sidebar li").removeClass();
    $("#retailer").addClass("active");
});
$(function(){
    $('.btn-success').click(function(){
    	$('span.tip').show().fadeOut(5000);
    	var password1=$('#password').val();
    	var password2=$('#re_password').val();
    	if(password1!=password2)
    	{
    	alert("password not same");
    	}
    	else
    	{
    	alert("success");
        $.ajax({
               url:  "../../regist",
               data: {
                       appuserName:$('#userName').val(),
                       password:password1,
                       phone_num:$('#phone_num').val()
                       },
               type : "post",
               dataType : "json",
               contentType : "application/x-www-form-urlencoded; charset=utf-8"
    	       })
    	}
    })
   //重置按钮
   $('.btn-warning').click(function(){
       $('.login-input').val("");
   })
})