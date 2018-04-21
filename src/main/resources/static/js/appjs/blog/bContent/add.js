// $().ready(function() {
//
//     $('.summernote').summernote({
//         height : '220px',
//         lang : 'zh-CN',
//         callbacks: {
//             //本文的主题来了，调用官方提供的callbacks接口，用来自定义
//             onImageUpload: function (files) {      //onImageUpload代表图片上传事件，默认将图片变为base64的那个事件
//                 alert(1);
//                 var data = new FormData();        //html5提供的formdata对象，将图片加载为数据的容器
//                 data.append('img', files[0]);  //加载选中的第一张图片，并给这图片数据标记一个'image_up'的名称
//                 //调用上传图片
//                 $.ajax({
//                     url: '/blog/bContent/upImage',     //上传图片请求的路径
//                     method: 'POST',            //方法
//                     data: data,                 //数据
//                     processData: false,        //告诉jQuery不要加工数据
//                     contentType: false,        //<code class="javascript comments"> 告诉jQuery,在request head里不要设置Content-Type
//                     success: function (data) {  //图片上传成功之后，对返回来的数据要做的事情
//                         if (data.code == 0) {
//                             $(".summernote").summernote('insertImage', data.img);       //调用内部api——insertImage以路径的形式插入图片到文本编辑区
//                         }
//                         else {
//                             alert(data.msg);
//                         }
//                     }
//                 });
//             }
//         }
//         });
//
//     validateRule();
// });



$().ready(function() {
    $.ajax({
        cache : true,
        type : "GET",
        url : "/content/news/types",
        data: "",
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(r) {
            if (r.code == 0) {
                for(var i = 0; i < r.types.length; i++){
                    var typeName = r.types[i].typeName;
                    var id = r.types[i].ntId;
                    var option = "<option value='" + id + "'>" + typeName + "</option>";
                    $("#types").append(option);
                }
            } else {
                alert(r.msg);
            }

        }
    });
});

$.validator.setDefaults({
    submitHandler : function() {
        save(1);
    }
});
function save(status) {
    $("#status").val(status);
    // var content_sn = $("#content_sn").code();
    var content_sn = $(".w-e-text").html();
    $("#content").val(content_sn);

    var data = $('#signupForm').serialize();
    alert(data);

    $.ajax({
        cache : true,
        type : "POST",
        url : "/content/bContent/save",
        data : $('#signupForm').serialize(),// 你的formid
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(r) {
            if (r.code == 0) {
                parent.layer.msg(r.msg);
                parent.reLoad();
                $("#cid").val(r.cid);
                var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                parent.layer.close(index);

            } else {
                parent.layer.alert(r.msg)
            }

        }
    });

}
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            title : "required",
            author : "required",
            content :"required"
        },
        messages : {
            title : "请填写文章标题",
            author : "请填写文章作者",
            content :"请填写文章内容"
        }
    });
}


$('input[id=lefile]').change(function() {
    $('#photoCover').val($(this).val());
    var formData = new FormData();
    var img = $('#lefile')[0].files[0];
    formData.append("img", img);
    $.ajax({
        cache : false,
        type : "POST",
        url : "/content/bContent/upImage",
        data :formData,
        async : false,
        dataType: "json",
        processData: false,
        contentType: false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(r) {
            if (r.code == 0) {
                $("#imgUrl").val(r.url);
            } else {
                alert(r.msg)
            }

        }
    });
});

function returnList(){
    var index = parent.layer.getFrameIndex(window.name);
    alert(index);
    //获取窗口索引
    parent.layer.close(index);
//	parent.layer.close(layer.index);
}