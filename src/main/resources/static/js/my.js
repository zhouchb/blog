window.onload = function() {

    var chars = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'];
    function generateMixed(n) {
    var res = "";
    for (var i = 0; i < n; i++) {
    var id = Math.ceil(Math.random() * 16);
    res += chars[id];
    }
    return res;
    }
    var num = generateMixed(6);
    // var p = document.getElementById('broadcast');
    var p = document.querySelector('.broadcast');
    p.style.color = "#" + num;
/*页眉三杠*/
    $('.menu.toggle').click(function () {
        $('.m-item').toggleClass('m-mobile-hide');
    });

    /*赞赏*/
    $('#payButton').popup({
        popup : $('.payQR.popup'),
        on : 'click',
        position: 'bottom center'
    });

    /*弹出目录*/
    $('.toc').popup({
        popup : $('.toc-container.popup'),
        on : 'click',
        position: 'left center'
    });

    /*目录生成激活*/
    tocbot.init({
        // Where to render the table of contents.
        tocSelector: '.js-toc',
        // Where to grab the headings to build the table of contents.
        contentSelector: '.js-toc-content',
        // Which headings to grab inside of the contentSelector element.
        headingSelector: 'h1, h2, h3',
        // For headings inside relative or absolute positioned containers within content.
       /* hasInnerContainers: true,*/
    });

    /*=======网页生成二维码qrcode=========*/
    var qrcode = new QRCode(document.getElementById("qrcode"), {
        text: "http://jindo.dev.naver.com/collie",
        width: 110,
        height: 110,
        colorDark : "#000000",
        colorLight : "#ffffff",
        correctLevel : QRCode.CorrectLevel.H
    });

    /*=====滚动检测=======*/
    var waypoint = new Waypoint({
        element: document.getElementById('waypoints'),
        handler: function(direction) {
            if (direction=='down'){
            $('#toolbar').slideDown(300);
            }else {
            $('#toolbar'). fadeToggle(500);/*淡入淡出*/
            }
            /*https://blog.csdn.net/dongjiong0213/article/details/101431229?utm_term=jqueryshow()%E5%8A%A8%E7%94%BB&utm_medium=distribute.pc_aggpage_search_result.none-task-blog-2~all~sobaiduweb~default-1-101431229&spm=3001.4430*/
        }
    })

/*后台管理，头像下拉*/
/*    $('.ui.dropdown').dropdown();*/
};
/*把鼠标移动到qq图标上显示qq号*/
$(".qq").popup();

/*滑动到微信图标上显示图片*/
$('.wechat').popup({
    popup : $('.wechat-qr'),
    position: 'top center'
});

/*滑动到微信图标上显示图片*/
$('.wechat2').popup({
    popup : $('.wechat-qr2'),
    // on : 'click',
    position: 'left center'
});

/*后台管理，头像下拉*/
$('.ui.dropdown').dropdown();

/*后台管理表单*/
$('.ui.form').form({
    fields : {
        title : {
            identifier: 'title',
            rules: [{
                type : 'empty',
                prompt: '标题：请输入博客标题'
            }]
        }
    }
})


/*=====editormd  初始化Markdown编辑器=====*/
var contentEditor;
$(function() {
    contentEditor = editormd("md-content", {
        width   : "90%",
        height  : 640,
        syncScrolling : "single",
        path    : "/lib/editormd/lib/",
        emoji:true
    });
});

/*=====自动滑到顶部速度=====*/
$('#toTop').click(function () {
    $(window).scrollTo(0,500);
});


