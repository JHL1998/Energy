window.onload = function() {
    //匀速运动动画效果函数
function animate(obj,target) {
    clearInterval(obj.timer); //先清除定时器  很重要！！！
    var speed = obj.offsetLeft < target ? 15 : -15; //盒子移动距离小于目标位置，5：前进，-5：后退
    obj.timer = setInterval(function() {
       var result = target - obj.offsetLeft;  //目标位置与移动距离的差值
       obj.style.left = obj.offsetLeft + speed +"px";
       if(Math.abs(result)<=15) //如果差值小于等于5 就停止计时器
       {
           clearInterval(obj.timer);
           obj.style.left = target +"px"; //补足差值的小于5的那部分值
      }    
    },20)
}

var box = document.getElementById("box");
var ul = document.getElementById("ul");
var liLis = ul.children;   
//克隆第一个li放到最后一个
ul.appendChild(ul.children[0].cloneNode(true));
//动画效果


//添加定时器
var timer = null,k=0,squer=0;
timer = setInterval(autoplay,4000);
function autoplay() {
    k++;
    console.log(k);
    if( k > liLis.length-1 )
    {
        ul.style.left = 0;//迅速调回到初始位置
        k=1;           
        //下面这样也可以！！？？  而且不需要复制第一张了吧
        // ul.style.left = 500;
        console.log(k);
    }
    animate(ul,-k*1450);
    
}

}
