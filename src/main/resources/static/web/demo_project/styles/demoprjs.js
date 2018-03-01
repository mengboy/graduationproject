/*  Free Template by www.templatemo.com  */

/*
 Dragonfruit Template
 http://www.templatemo.com/preview/templatemo_411_dragonfruit
 */

jQuery(function(){
  $ = jQuery;
  $(window).load( function() {
    $('.external-link').unbind('click');
  });

  //demoprjs
  var min_height = 100;
  $(".event_box_img").load(function(){
    img_height = $(this).height();
    $(".event_box_wap").each(function(){
      header_height = $(this).children(".event_box_caption").children("h1").outerHeight();
      if (header_height < min_height) {
        min_height = header_height;
      }
    });
    view_height = img_height + min_height;
    $(this).parent(".event_box_wap").height(view_height);
  });
  $(window).on("load resize", function(){
    img_height = $(".event_box_img").height();
    $(".event_box_wap").each(function(){
      header_height = $(this).children(".event_box_caption").children("h1").outerHeight();
      if (header_height < min_height) {
        min_height = header_height;
      }
    });
    view_height = img_height + min_height;

    if($(window).width()>550){

      $(".event_box_wap").each(function(){

        $(".event_box_wap").height(view_height);
        header_height = $(this).children(".event_box_caption").children("h1").outerHeight();
        hide_paragraph_height = header_height + 10 - min_height;
        $(this).children(".event_box_caption").css({"top": "-" + hide_paragraph_height + "px"});
      });
    }else{
      $(".event_box_wap").height(view_height);
      $(".event_box_wap").each(function(){
        total_height = $(this).children(".event_box_caption").outerHeight();
        $(this).height(total_height+img_height);
        $(this).children(".event_box_caption").css({"top": "0px"});
      });
    }
  });
  $(".event_box_wap").hover(function(){
    if($(window).width()>550){
      paragraph_height = $(this).children(".event_box_caption").children("p").outerHeight();
      header_height = $(this).children(".event_box_caption").children("h1").outerHeight();
      hide_paragraph_height =  paragraph_height + header_height - min_height;
      $(this).children(".event_box_caption").stop().animate({"top": "-" + hide_paragraph_height + "px"});
    }
  },function(){
    if($(window).width()>550){
      header_height = $(this).children(".event_box_caption").children("h1").outerHeight();
      hide_paragraph_height = header_height + 10 - min_height;
      $(this).children(".event_box_caption").stop().animate({"top": "-" + hide_paragraph_height + "px"});
    }
  });
});
