/**
* jQuery v1.7.2 swpixel.com | swpixel.com/
* Conact   Jet XUE  <358089270@qq.com>
*/
/*
运动算法
*/
jQuery.easing['jswing'] = jQuery.easing['swing'];

jQuery.extend( jQuery.easing,
{
	def: 'easeOutQuad',
	swing: function (x, t, b, c, d) {
		//alert(jQuery.easing.default);
		return jQuery.easing[jQuery.easing.def](x, t, b, c, d);
	},
	easeInQuad: function (x, t, b, c, d) {
		return c*(t/=d)*t + b;
	},
	easeOutQuad: function (x, t, b, c, d) {
		return -c *(t/=d)*(t-2) + b;
	},
	easeInOutQuad: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t + b;
		return -c/2 * ((--t)*(t-2) - 1) + b;
	},
	easeInCubic: function (x, t, b, c, d) {
		return c*(t/=d)*t*t + b;
	},
	easeOutCubic: function (x, t, b, c, d) {
		return c*((t=t/d-1)*t*t + 1) + b;
	},
	easeInOutCubic: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t*t + b;
		return c/2*((t-=2)*t*t + 2) + b;
	},
	easeInQuart: function (x, t, b, c, d) {
		return c*(t/=d)*t*t*t + b;
	},
	easeOutQuart: function (x, t, b, c, d) {
		return -c * ((t=t/d-1)*t*t*t - 1) + b;
	},
	easeInOutQuart: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t*t*t + b;
		return -c/2 * ((t-=2)*t*t*t - 2) + b;
	},
	easeInQuint: function (x, t, b, c, d) {
		return c*(t/=d)*t*t*t*t + b;
	},
	easeOutQuint: function (x, t, b, c, d) {
		return c*((t=t/d-1)*t*t*t*t + 1) + b;
	},
	easeInOutQuint: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t*t*t*t + b;
		return c/2*((t-=2)*t*t*t*t + 2) + b;
	},
	easeInSine: function (x, t, b, c, d) {
		return -c * Math.cos(t/d * (Math.PI/2)) + c + b;
	},
	easeOutSine: function (x, t, b, c, d) {
		return c * Math.sin(t/d * (Math.PI/2)) + b;
	},
	easeInOutSine: function (x, t, b, c, d) {
		return -c/2 * (Math.cos(Math.PI*t/d) - 1) + b;
	},
	easeInExpo: function (x, t, b, c, d) {
		return (t==0) ? b : c * Math.pow(2, 10 * (t/d - 1)) + b;
	},
	easeOutExpo: function (x, t, b, c, d) {
		return (t==d) ? b+c : c * (-Math.pow(2, -10 * t/d) + 1) + b;
	},
	easeInOutExpo: function (x, t, b, c, d) {
		if (t==0) return b;
		if (t==d) return b+c;
		if ((t/=d/2) < 1) return c/2 * Math.pow(2, 10 * (t - 1)) + b;
		return c/2 * (-Math.pow(2, -10 * --t) + 2) + b;
	},
	easeInCirc: function (x, t, b, c, d) {
		return -c * (Math.sqrt(1 - (t/=d)*t) - 1) + b;
	},
	easeOutCirc: function (x, t, b, c, d) {
		return c * Math.sqrt(1 - (t=t/d-1)*t) + b;
	},
	easeInOutCirc: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return -c/2 * (Math.sqrt(1 - t*t) - 1) + b;
		return c/2 * (Math.sqrt(1 - (t-=2)*t) + 1) + b;
	},
	easeInElastic: function (x, t, b, c, d) {
		var s=1.70158;var p=0;var a=c;
		if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
		if (a < Math.abs(c)) { a=c; var s=p/4; }
		else var s = p/(2*Math.PI) * Math.asin (c/a);
		return -(a*Math.pow(2,10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
	},
	easeOutElastic: function (x, t, b, c, d) {
		var s=1.70158;var p=0;var a=c;
		if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
		if (a < Math.abs(c)) { a=c; var s=p/4; }
		else var s = p/(2*Math.PI) * Math.asin (c/a);
		return a*Math.pow(2,-10*t) * Math.sin( (t*d-s)*(2*Math.PI)/p ) + c + b;
	},
	easeInOutElastic: function (x, t, b, c, d) {
		var s=1.70158;var p=0;var a=c;
		if (t==0) return b;  if ((t/=d/2)==2) return b+c;  if (!p) p=d*(.3*1.5);
		if (a < Math.abs(c)) { a=c; var s=p/4; }
		else var s = p/(2*Math.PI) * Math.asin (c/a);
		if (t < 1) return -.5*(a*Math.pow(2,10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
		return a*Math.pow(2,-10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )*.5 + c + b;
	},
	easeInBack: function (x, t, b, c, d, s) {
		if (s == undefined) s = 1.70158;
		return c*(t/=d)*t*((s+1)*t - s) + b;
	},
	easeOutBack: function (x, t, b, c, d, s) {
		if (s == undefined) s = 1.70158;
		return c*((t=t/d-1)*t*((s+1)*t + s) + 1) + b;
	},
	easeInOutBack: function (x, t, b, c, d, s) {
		if (s == undefined) s = 1.70158; 
		if ((t/=d/2) < 1) return c/2*(t*t*(((s*=(1.525))+1)*t - s)) + b;
		return c/2*((t-=2)*t*(((s*=(1.525))+1)*t + s) + 2) + b;
	},
	easeInBounce: function (x, t, b, c, d) {
		return c - jQuery.easing.easeOutBounce (x, d-t, 0, c, d) + b;
	},
	easeOutBounce: function (x, t, b, c, d) {
		if ((t/=d) < (1/2.75)) {
			return c*(7.5625*t*t) + b;
		} else if (t < (2/2.75)) {
			return c*(7.5625*(t-=(1.5/2.75))*t + .75) + b;
		} else if (t < (2.5/2.75)) {
			return c*(7.5625*(t-=(2.25/2.75))*t + .9375) + b;
		} else {
			return c*(7.5625*(t-=(2.625/2.75))*t + .984375) + b;
		}
	},
	easeInOutBounce: function (x, t, b, c, d) {
		if (t < d/2) return jQuery.easing.easeInBounce (x, t*2, 0, c, d) * .5 + b;
		return jQuery.easing.easeOutBounce (x, t*2-d, 0, c, d) * .5 + c*.5 + b;
	}
});

/*main*/
(function($){
    $.fn.slides=function(options){
		var settings={
		    conTag:"#conCls",
			navTag:"#navCls",
			nextTag:"#nextCls",
			prevTag:"#prevCls",
			duration:200,
			interval:3000,
			effect:"scrollx",
			autoPlay:true,
			iswarp:false,
			activeCls:"selected",
			triggletype:'click'
		};
		$.extend(true,settings,options);
		return this.each(function(){
		    var conTag=$(settings.conTag,this),
			    navTag=$(settings.navTag,this),
				nextTag=$(settings.nextTag,this),
				prevTag=$(settings.prevTag,this),
				moveWidth=conTag.children().width(),
				moveHeight=conTag.children().height(),
				count=conTag.children().length,
				index=0,
				isetTimeout,
		        currentindex=0,
				mouOn=false;
			/*设置CSS样式*/ 
			    $(this).css({position:"relative"});
			    switch(settings.effect){
				case "scrollx":
					
				    if(settings.iswarp){conTag.wrap("<div style='width:"+moveWidth+"px;height:"+moveHeight+"px;overflow:hidden;position:relative;'></div>")};
				    conTag.css({width:moveWidth*count,position:"absolute"});
				    break;
				case "scrolly":
				    if(settings.iswarp){conTag.wrap("<div style='width:"+moveWidth+"px;height:"+moveHeight+"px;overflow:hidden;position:relative;'></div>");};
				    conTag.css({height:moveHeight*count,position:"absolute"});
					conTag.children().css("clear","both");
					break;
				case "fade":
				    navTag.css({"z-index":"1000"});
				    conTag.css({position:"absolute"});
					conTag.children().css({position:"absolute",left:"0px",top:"0px"});
					break;
	            default: alert("effect none");
				};
			autoplay(index+1);
			nextTag.click(function(){
			    next();
			});
			prevTag.click(function(){
			    prev();
			});
			conTag.hover(function(){stopTime()},function(){
			mouOn=false;
			autoplay();
			
			});
			navTag.children().mouseover(function(){
				mouOn=true;
	            if(settings.triggletype=='mouseover'){
					runTo(index=$(this).index());
				}
	        });
			if(settings.triggletype=='click'){
			navTag.children().click(function(){
				runTo(index=$(this).index());
			})}
			navTag.children().mouseout(function(){
			    mouOn=false;
				(!!isetTimeout)&&clearInterval(isetTimeout);
			     isetTimeout=setTimeout(function(){autoplay();},500) 
			});
			
			function runTo(i){
				if(settings.wz){
					if(i!=currentindex){
					var wz = $(settings.wz);
					wz.eq(currentindex).stop(false,false).animate({left:-1000},{duration:settings.duration*0.7,easing:"easeInCubic",complete:function(){
					$(this).css("left",300);		
				    }})}
				}
				
				stopTime();
				navTag.children().eq(i).addClass(settings.activeCls).siblings().removeClass(settings.activeCls);
				currentindex =i;
				switch(settings.effect){
				case "scrollx":
					
				    conTag.stop().animate({left:-i*moveWidth},{duration:settings.duration,easing:"easeInCubic"});
					
		    	    mouOn||autoplay();
					break;
				case "scrolly":
					
				    conTag.stop().animate({top:-i*moveHeight},{duration:settings.duration,easing:"easeInCubic"});
		    	    mouOn||autoplay();
					break;
				case "fade":
				 
					conTag.children().eq(i).css("z-index","999").stop(true,true).animate({opacity:1},settings.duration).siblings().css("z-index","1").stop(true,true).animate({opacity:0},settings.duration); 
		    	    mouOn||autoplay();
					break;
					
				default: alert("effect none");
				}
			};
			function autoplay(){
				 !settings.autoPlay||(settings.autoPlay=setTimeout(function(){next()},(settings.interval-settings.duration)))
			};
			function stopTime(){
	            clearTimeout(settings.autoPlay)
	        };
	        function next(){
				
		        index++;
	            index>=count&&(index=0);
		        runTo(index)
	        };
			function prev(){
			    index--;
	            index<0&&(index=(count-1));
		        runTo(index)
			}
			
		})
	}
})(jQuery);