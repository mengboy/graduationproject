//向上滚动代码
function startmarquee(elemenClASS,h,n,speed,delay){
 var t = null;
 var box = '.' + elemenClASS;
 $(box).hover(function(){
  clearInterval(t);
  }, function(){
  t = setInterval(start,delay);
 }).trigger('mouseout');
 function start(){
  $(box).children('ul:first').animate({marginTop: '-='+h},speed,function(){
   $(this).css({marginTop:'0'}).find('li').slice(0,n).appendTo(this);
  })
 }
}
//pc2008 old
//运行代码
function runCode(cod1)  {
	 cod=document.getElementById(cod1)
	  var code=cod.value;
	  if (code!=""){
		  var newwin=window.open('','','');  
		  newwin.opener = null 
		  newwin.document.write(code);  
		  newwin.document.close();
	}
}

function Browser(){
	if(window.navigator.userAgent.indexOf("MSIE")>=1) return 'IE';
	else if(window.navigator.userAgent.indexOf("Firefox")>=1) return 'FF';
	else return "OT";
}

//另存代码
function saveCode(obj) {
  if(Browser()=='IE'){
	var winname = window.open('', '_blank', 'top=10000');
	var obj1=document.getElementById(obj)
	winname.document.open('text/html', 'replace');
	winname.document.writeln(obj1.value);
	winname.document.execCommand('saveas','','code.htm');
	winname.close();}
  else{
	jConfirm("对不起，目前此功能只支持IE，请手动复制保存代码",'出错啦！')
	}
}

//javascript
function x(id)
{
	return document.getElementById(id);
}
//复制文本
function copyCode(id)
{
  copy( x(id).innerText,x(id) );
}
function copyIdHtml(id)
{
  copy( x(id).innerHTML,x(id) );
}

function copy(txt,obj)
{       
   if(window.clipboardData) 
   {        
        window.clipboardData.clearData();        
        window.clipboardData.setData("Text", txt);
        alert("复制成功！")
        if(obj.style.display != 'none'){
	  var rng = document.body.createTextRange();
	  rng.moveToElementText(obj);
	  rng.scrollIntoView();
	  rng.select();
	  rng.collapse(false);  
       }
   }
   else
    alert("目前此功能只支持IE，请选中文本，使用 Ctrl+C 复制!");
}