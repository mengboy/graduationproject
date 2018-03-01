/* 图片滚动设置
*
*  使用方法：
*  var ScrollPic =new JackScrollPic.ScrollPic({
*       Container: "Container",
*       TextContainer: "TextContainer",
*       DataItem: Data,
*       scrollBtn: "scrollBtn",
*       scrollContainer: "scrollContainer"
*  });
*
*  参数描述：
*  Container:图片区域最外层容器，
*  TextContainer: 图片容器，
*  DataItem: 填充数据，
*  scrollBtn: 滚动条滑块容器，
*  scrollContainer: 滚动条容器，
*
*  注：后台传入的数据DataItem是程序读取，格式为数组类型
*      Eg：["图片路径"|"标题"|"简介"|"内容或者链接"|"0为打开链接，1为打开弹出层"]
*          如果没有数据可传入 "" 类型
*
*/

var JackScrollPic = {
    //版本号
    version: 1.0
};
JackScrollPic.ScrollPic = function (ScrollPicObj) {
    //验证图片区域最外层容器
    if (typeof (ScrollPicObj.Container) == "undefined") {
        alert("必须对Container属性赋值!");
        return;
    }
    //验证图片容器
    if (typeof (ScrollPicObj.TextContainer) == "undefined") {
        alert("必须对TextContainer属性赋值!");
        return;
    }
    //验证填充数据
    if (typeof (ScrollPicObj.DataItem) == "undefined") {
        alert("必须对DataItem属性赋值!");
        return;
    }
    //验证滚动条滑块容器
    if (typeof (ScrollPicObj.scrollBtn) == "undefined") {
        alert("必须对scrollBtn属性赋值!");
        return;
    }
    //验证滚动条容器
    if (typeof (ScrollPicObj.scrollContainer) == "undefined") {
        alert("必须对scrollContainer属性赋值!");
        return;
    }

    //获取图片容器
    var Container = document.getElementById(ScrollPicObj.Container);
    //获取滚动容器
    var TextContainer = document.getElementById(ScrollPicObj.TextContainer);
    //获取填充数据
    var DataItem = ScrollPicObj.DataItem;
    //获取滚动条滑块
    var scrollBtn = document.getElementById(ScrollPicObj.scrollBtn);
    //获取滚动条滑块容器
    var scrollContainer = document.getElementById(ScrollPicObj.scrollContainer);
    //变量声明
    var Timer, pop_body;

    //#region format方法
    String.prototype.format = function (args) {
        var result = this;
        if (arguments.length > 0) {
            if (arguments.length == 1 && typeof (args) == "object") {
                for (var key in args) {
                    if (args[key] != undefined) {
                        var reg = new RegExp("({" + key + "})", "g");
                        result = result.replace(reg, args[key]);
                    }
                }
            }
            else {
                for (var i = 0; i < arguments.length; i++) {
                    if (arguments[i] != undefined) {
                        var reg = new RegExp("({[" + i + "]})", "g");
                        result = result.replace(reg, arguments[i]);
                    }
                }
            }
        }
        return result;
    };
    //#endregion

    //#region 计算滚动容器宽度
    function CountWidth() {
        TextContainer.style.width = DataItem.length * 240 + "px";
    }
    //#endregion

    //#region 填充数据到页面
    function DataPage() {
        var htmlStr_link = "<div item=\"{id}\" class=\"card cardShad\" style=\"left:{leftnum}px;top:2px;\"><a target=\"_blank\" href=\"{link}\"><img src=\"{imgpath}\" /><span class=\"cardTitle\">{title}</span><span class=\"cardNarrative\">{content}</span></a></div>";
        var htmlStr = "<div item=\"{id}\" class=\"card cardShad\" style=\"left:{leftnum}px;top:2px;\"><img src=\"{imgpath}\" /><span class=\"cardTitle\">{title}</span><span class=\"cardNarrative\">{content}</span></div>";
        var HTML = "";
        var forEnd = DataItem.length > 6 ? 6 : DataItem.length;
        for (var i = 0; i < forEnd; i++) {
            if (DataItem[i].split("|")[4] == 0)
                HTML += htmlStr_link.format({ id: i, leftnum: i == 0 ? 2 : i * 240, link: DataItem[i].split("|")[3], imgpath: DataItem[i].split("|")[0], title: DataItem[i].split("|")[1], content: DataItem[i].split("|")[2] });
            else
                HTML += htmlStr.format({ id: i, leftnum: i == 0 ? 2 : i * 240, imgpath: DataItem[i].split("|")[0], title: DataItem[i].split("|")[1], content: DataItem[i].split("|")[2] });
        }
        TextContainer.innerHTML = HTML;

        for (var i = 0; i < TextContainer.getElementsByTagName("div").length; i++) {
            (function (item) {
                TextContainer.getElementsByTagName("div")[item].onmouseover = function () {
                    this.className = "card cardShadMed";
                    this.style.top = "0px";
                    this.style.left = parseInt(this.style.left) - 2 + "px";
                };
                TextContainer.getElementsByTagName("div")[item].onmouseout = function () {
                    this.className = "card cardShad";
                    this.style.top = "2px";
                    this.style.left = parseInt(this.style.left) + 2 + "px";
                };
                TextContainer.getElementsByTagName("div")[item].onclick = function () {
                    var idx = parseInt(this.getAttribute("item"));
                    if (DataItem[idx].split("|")[4] != 0) {
                        //创建弹出层
                        CreatePop(DataItem[idx].split("|")[1], DataItem[idx].split("|")[3]);
                    }
                };
            })(i);
        }
    };
    //#endregion

    //#region 计算加载位置
    function LoadPos(pos) {
        var htmlStr_link = "<div item=\"{id}\" class=\"card cardShad\" style=\"left:{leftnum}px;top:2px;\"><a target=\"_blank\" href=\"{link}\"><img src=\"{imgpath}\" /><span class=\"cardTitle\">{title}</span><span class=\"cardNarrative\">{content}</span></a></div>";
        var htmlStr = "<div item=\"{id}\" class=\"card cardShad\" style=\"left:{leftnum}px;top:2px;\"><img src=\"{imgpath}\" /><span class=\"cardTitle\">{title}</span><span class=\"cardNarrative\">{content}</span></div>";
        var ipos = 0;
        for (var i = 0; i < DataItem.length; i++) {
            if (i * 240 > pos) {
                ipos = i - 1;
                break;
            }
        }

        var HTML = "";
        var forEnd = DataItem.length > (ipos + 6) ? ipos + 6 : DataItem.length;
        if (DataItem.length > (ipos + 6)) {
            forEnd = ipos + 6;
        } else {
            ipos = DataItem.length - 6;
            forEnd = DataItem.length;
        }
        for (var i = ipos; i < forEnd; i++) {
            if (DataItem[i].split("|")[4] == 0)
                HTML += htmlStr_link.format({ id: i, leftnum: i == 0 ? 2 : i * 240, link: DataItem[i].split("|")[3], imgpath: DataItem[i].split("|")[0], title: DataItem[i].split("|")[1], content: DataItem[i].split("|")[2] });
            else
                HTML += htmlStr.format({ id: i, leftnum: i == 0 ? 2 : i * 240, imgpath: DataItem[i].split("|")[0], title: DataItem[i].split("|")[1], content: DataItem[i].split("|")[2] });
        }
        TextContainer.innerHTML = HTML;

        for (var i = 0; i < TextContainer.getElementsByTagName("div").length; i++) {
            (function (item) {
                TextContainer.getElementsByTagName("div")[item].onmouseover = function () {
                    this.className = "card cardShadMed";
                    this.style.top = "0px";
                    this.style.left = parseInt(this.style.left) - 2 + "px";
                };
                TextContainer.getElementsByTagName("div")[item].onmouseout = function () {
                    this.className = "card cardShad";
                    this.style.top = "2px";
                    this.style.left = parseInt(this.style.left) + 2 + "px";
                };
                TextContainer.getElementsByTagName("div")[item].onclick = function () {
                    var idx = parseInt(this.getAttribute("item"));
                    if (DataItem[idx].split("|")[4] != 0) {
                        //创建弹出层
                        CreatePop(DataItem[idx].split("|")[1], DataItem[idx].split("|")[3]);
                    }
                };
            })(i);
        }
    }
    //#endregion

    //#region 滚动条设置
    function ScrollSet() {
       // scrollBtn.style.width = parseInt(Container.clientWidth / (Container.scrollWidth / Container.clientWidth)) + "px";

        scrollBtn.onmousedown = function (e) {
            var x = (e || window.event).clientX;
            var l = this.offsetLeft;
            var max = scrollContainer.offsetWidth - this.offsetWidth;
            document.onmousemove = function (e) {
                var thisX = (e || window.event).clientX;
                var to = Math.min(max, Math.max(0, l + (thisX - x)));
                scrollBtn.style.left = to + "px";
                //开始移动
                StartMove(parseInt(to * (Container.scrollWidth / Container.clientWidth)) - 0);
                //计算加载位置
                LoadPos(parseInt(to * (Container.scrollWidth / Container.clientWidth)));
                window.getSelection ? window.getSelection().removeAllRanges() : document.selection.empty();
            };
            document.onmouseup = new Function("this.onmousemove=null");
        };
    };
    //#endregion

    //#region 开始移动
    function StartMove(iTarget) {
        clearInterval(Timer);
        Timer = setInterval(function () { DoMove(iTarget) }, 10);
    };
    function DoMove(iTarget) {
        var iSpeed = (iTarget - Container.scrollLeft) / 7;
        iSpeed = iSpeed > 0 ? Math.ceil(iSpeed) : Math.floor(iSpeed);
        Container.scrollLeft == iTarget ? clearInterval(Timer) : Container.scrollLeft = Container.scrollLeft + iSpeed;
    };
    //#endregion

    //#region 创建弹出层
    function CreatePop(title, content) {
        if (pop_body != undefined) {
            document.body.removeChild(pop_body);
        }

        pop_body = document.createElement("div");
        pop_body.className = "pop_body";
        document.body.appendChild(pop_body);

        var close = document.createElement("div");
        close.className = "close";
        pop_body.appendChild(close);

        close.onclick = function () {
            document.body.removeChild(pop_body);
            pop_body = null;
        };

        var pop_content = document.createElement("div");
        pop_content.className = "pop_content";
        pop_body.appendChild(pop_content);

        var pop_title = document.createElement("div");
        pop_title.className = "pop_title";
        pop_title.innerHTML = title;
        pop_content.appendChild(pop_title);

        var pop_text = document.createElement("div");
        pop_text.className = "pop_text";
        pop_text.innerHTML = content;
        pop_content.appendChild(pop_text);

        //设置窗体居中
        windowCenter();
    };
    //#endregion

    //#region 获得样式表中的CSS属性
    function GetCurrentStyle(obj, prop) {
        if (obj.currentStyle)
            return obj.currentStyle[prop];
        else if (window.getComputedStyle) {
            propprop = prop.replace(/([A-Z])/g, "-$1");
            propprop = prop.toLowerCase();
            return document.defaultView.getComputedStyle(obj, null)[propprop];
        }
        return null;
    };
    //#endregion

    //#region 设置窗体居中
    function windowCenter() {
        pop_body.style.left = (document.documentElement.clientWidth - parseInt(GetCurrentStyle(pop_body, "width"))) / 2 + "px";
    };
    //#endregion

    //#region 初始化
    this.Init = function () {
        //计算滚动容器宽度
        CountWidth();
        //填充数据到页面
        DataPage();
        //滚动条设置
        ScrollSet();
        //初始值
        Container.scrollLeft = 0;
    };
    //#endregion
};