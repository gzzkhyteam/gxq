$(function(){
    /**
     * Created by Administrator on 2016/12/16.
     */
    function $(id){
        return document.getElementById(id);
    }
//画布 的大小设置
    /*  var mywindow=window.screen;*/
    var canvas=$("canvas");
    canvas.width=window.innerWidth;
    canvas.height=window.innerHeight;

//要输出的信息
    var str="0123456789";
    str=str.split("");
    var fontSize=14;//输出字体的大小

//每列显示多少个信息
    var cols=canvas.width/fontSize;
//数组，统计下落的位置
    var drops=[];
    for(var i=0;i<cols;i++){
        drops[i]=1;
    }

    var ctx=canvas.getContext("2d");
    function draw(){
        /**
         * 获取页面的 大小 包括宽度和高度
         * 用cols获取能够宽度加载列数
         * drops加载每一列的位置
         * drops[2]=10 2为第二排的 top为10
         */
        ctx.fillStyle="rgba(0,0,0,0.3)";
        ctx.fillRect(0,0,canvas.width,canvas.height);

        ctx.fillStyle="#0093ff";
        ctx.font=fontSize+"px arial";
        for(var i=0;i<cols;i++){
            var text=str[ Math.floor( Math.random() * (str.length) ) ];
            // console.info("x-"+i*fontSize);
            // console.info("y-"+drops[i]*fontSize);
            ctx.fillText(text,i*fontSize,drops[i]*fontSize);
            if(drops[i]*fontSize > canvas.height || Math.random() > 0.95)
                drops[i] = 0;//把位置恢复到最上面
            //控制下落的位置
            drops[i]++;
        }
    }
    setInterval(draw,50);
})