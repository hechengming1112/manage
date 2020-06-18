(function ($) {
    $.extend({
        setter:{
            "active":false,//true本地JSON，false联调ajax
            "rootBase":"http://localhost:8080/",
            currPath:function(){
                var div=document.createElement('div');
                div.innerHTML='<a href="./"></a>>';
                var path=div.firstChild.href;
                div=null;
                return path;
            },
            ctxStatic:function () {
                var path=$.setter.currPath();
                var paths=path.split("templates");
                var staticPath=paths[0];
                if ($.setter.active){

                } else {
                    staticPath=$.setter["rootBase"]
                }
                return staticPath;
            }
        }
    })
})