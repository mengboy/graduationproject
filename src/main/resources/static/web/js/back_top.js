$(function() {
    //瀵艰埅鍒囨崲
	$(".navitem").hover(function() {
		$("div", this).stop().css("height",300).slideDown(300);
		$("#moved").stop().animate({
			left: $(this).position().left+$("#nav li").width()/2-40
		},
		600,"easeOutElastic")
	},
	function() {
		$("div", this).stop().delay(100).slideUp(200);
		$("#moved").stop().animate({
			left: $("#navactive").position().left+ $("#navactive").width()/2-40
		},
		300)
	});
	
	$("#moved").css("left", $("#navactive").position().left+ $("#navactive").width()/2-40);
	//鏍忕洰鐨刯s鏁堟灉
	$("#lanmu_list ul li:not(#cbnmove)").hover(function() {
            if ($(this).attr("id") == "cbnavactive") return;
            $("#cbnavactive a").css('color', '#555555');
            $("a", this).css('color', '#68a639');
            $("#cbnmove").stop().animate({ top: $(this).position().top }, 300)
        },
	    function() {
	        if ($(this).attr("id") == "cbnavactive") return;
	        $("a", this).css('color', '#555555');
	        $("#cbnmove").stop().animate({ top: $("#cbnavactive").position().top }, 300, function() { $("#cbnavactive a").css('color', '#fff'); })
	    });

        // $("#cbnmove").css("top", $("#cbnavactive").position().top);
        //$("#cbcolor a").click(function(e) {
           // $("#cbcolor a div").hide();
           // $("div", this).show();
           // $(this).blur();
           // return false;
       // });
        
        $(window).scroll(function(e) {
            if ($(this).scrollTop() >= 301) {
                $("#spleft").css({ "position": "fixed", "top": "140px" });
            }
            else {
                $("#spleft").css({ "position": "absolute", "top": "371px" });
            }
        });
	
	
	//杩斿洖椤堕儴
    $('.bk_top').addClass('hidden').click(function(){
    	$("html ,body").animate({scrollTop : $('#pagetop').offset().top},1000,"easeInOutQuint");
    	return false;
    });
	$.waypoints.settings.scrollThrottle = 30;
	$('#pagetop').waypoint(function(event, direction) {
		$('.bk_top').toggleClass('hidden', direction === "up");
	}, {
		offset: '-100%'
	});



})
/*
 //修改后的版本，还是报错
$(function() {
    //导航切换
	$(".navitem").hover(function() {
		$("div", this).stop().css("height",300).slideDown(300);
		$("#moved").stop().animate({
			left: $(this).position().left+$("#nav li").width()/2-40
		},
		600,"easeOutElastic")
	},
	function() {
		$("div", this).stop().delay(100).slideUp(200);
		$("#moved").stop().animate({
			left: $("#navactive").position().left+ $("#navactive").width()/2-40
		},
		300)
	});
	
	$("#moved").css("left", $("#navactive").position().left+ $("#navactive").width()/2-40);
	
	
	
	//返回顶部
    $('.bk_top').addClass('hidden').click(function(){
    	$("html ,body").animate({scrollTop : $('#pagetop').offset().top},1000,"easeInOutQuint");
    	return false;
    });
	$.waypoints.settings.scrollThrottle = 30;
	$('#pagetop').waypoint(function(event, direction) {
		$('.bk_top').toggleClass('hidden', direction === "up");
	}, {
		offset: '-100%'
	});
})
*/
/*
 //原始版本
$(function() {
    //瀵艰埅鍒囨崲
	$(".navitem").hover(function() {
		$("div", this).stop().css("height",300).slideDown(300);
		$("#moved").stop().animate({
			left: $(this).position().left+$("#nav li").width()/2-40
		},
		600,"easeOutElastic")
	},
	function() {
		$("div", this).stop().delay(100).slideUp(200);
		$("#moved").stop().animate({
			left: $("#navactive").position().left+ $("#navactive").width()/2-40
		},
		300)
	});
	
	$("#moved").css("left", $("#navactive").position().left+ $("#navactive").width()/2-40);
	//鏍忕洰鐨刯s鏁堟灉
	$("#lanmu_list ul li:not(#cbnmove)").hover(function() {
            if ($(this).attr("id") == "cbnavactive") return;
            $("#cbnavactive a").css('color', '#555555');
            $("a", this).css('color', '#68a639');
            $("#cbnmove").stop().animate({ top: $(this).position().top }, 300)
        },
	    function() {
	        if ($(this).attr("id") == "cbnavactive") return;
	        $("a", this).css('color', '#555555');
	        $("#cbnmove").stop().animate({ top: $("#cbnavactive").position().top }, 300, function() { $("#cbnavactive a").css('color', '#fff'); })
	    });
        $("#cbnmove").css("top", $("#cbnavactive").position().top);
        //$("#cbcolor a").click(function(e) {
           // $("#cbcolor a div").hide();
           // $("div", this).show();
           // $(this).blur();
           // return false;
       // });
        
        $(window).scroll(function(e) {
            if ($(this).scrollTop() >= 301) {
                $("#spleft").css({ "position": "fixed", "top": "140px" });
            }
            else {
                $("#spleft").css({ "position": "absolute", "top": "371px" });
            }
        });
	
	
	//杩斿洖椤堕儴
    $('.bk_top').addClass('hidden').click(function(){
    	$("html ,body").animate({scrollTop : $('#pagetop').offset().top},1000,"easeInOutQuint");
    	return false;
    });
	$.waypoints.settings.scrollThrottle = 30;
	$('#pagetop').waypoint(function(event, direction) {
		$('.bk_top').toggleClass('hidden', direction === "up");
	}, {
		offset: '-100%'
	});



})
*/

	
	


	
	

