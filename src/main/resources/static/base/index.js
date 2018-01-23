$(function(){
    $('.page-sidebar ul li p').click(function(){
        $('.page-sidebar ul li p').css('color','white')
        $(this).css('color','#ff8100');
        $(this).next('ul').show();
        $(this).parent().siblings().children('ul').hide();
    })
    $('.dropdown-toggle').click(function(){
        $('dropdown-menu').show();
    })
})