window.onload = function(){
   

var main = document.getElementById("main")
var myChart = echarts.init(main);

var zhexian = document.getElementById("zhexian")
var myChart1 = echarts.init(zhexian);

function randomData() {  
return Math.round(Math.random()*500);  
};

var mydata = [  
        {name: '北京',value: '100' },{name: '天津',value: randomData() },  
        {name: '上海',value: randomData() },{name: '重庆',value: randomData() },  
        {name: '河北',value: randomData() },{name: '河南',value: randomData() },  
        {name: '云南',value: randomData() },{name: '辽宁',value: randomData() },  
        {name: '黑龙江',value: randomData() },{name: '湖南',value: randomData() },  
        {name: '安徽',value: randomData() },{name: '山东',value: randomData() },  
        {name: '新疆',value: randomData() },{name: '江苏',value: randomData() },  
        {name: '浙江',value: randomData() },{name: '江西',value: randomData() },  
        {name: '湖北',value: randomData() },{name: '广西',value: randomData() },  
        {name: '甘肃',value: randomData() },{name: '山西',value: randomData() },  
        {name: '内蒙古',value: randomData() },{name: '陕西',value: randomData() },  
        {name: '吉林',value: randomData() },{name: '福建',value: randomData() },  
        {name: '贵州',value: randomData() },{name: '广东',value: randomData() },  
        {name: '青海',value: randomData() },{name: '西藏',value: randomData() },  
        {name: '四川',value: randomData() },{name: '宁夏',value: randomData() },  
        {name: '海南',value: randomData() },{name: '台湾',value: randomData() },  
        {name: '香港',value: randomData() },{name: '澳门',value: randomData() }  
    ];

    var optionMap = {  
        backgroundColor: '#FFFFFF',  
        title: {  
            text: '全国设备覆盖图',  
            subtext: '',  
            x:'center'  
        },  
        tooltip : {  
            trigger: 'item'  
        },  
        
        //左侧小导航图标
        visualMap: {  
            show : true,  
            x: 'left',  
            y: 'center',  
            splitList: [   
                {start: 500, end:600},{start: 400, end: 500},  
                {start: 300, end: 400},{start: 200, end: 300},  
                {start: 100, end: 200},{start: 0, end: 100},  
            ],  
            color: ['#5475f5', '#9feaa5', '#85daef','#74e2ca', '#e6ac53', '#9fb5ea']  
        },  
        
        //配置属性
        series: [{  
            name: '数据',  
            type: 'map',  
            mapType: 'china',   
            roam: true,  
            label: {  
                normal: {  
                    show: true  //省份名称  
                },  
                emphasis: {  
                    show: false  
                }  
            },  
            data:mydata  //数据
        }]  
    };  
//使用制定的配置项和数据显示图表
myChart.setOption(optionMap);

var base = +new Date(2020, 5, 1);
var oneDay = 24 * 3600 * 1000;
var valueBase = Math.random() * 300;
var valueBase2 = Math.random() * 50;
var data = [];
var data2 = [];

for (var i = 1; i < 10; i++) {
    var now = new Date(base += oneDay);
    var dayStr = [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('-');

    valueBase = Math.round((Math.random() - 0.5) * 20 + valueBase);
    valueBase <= 0 && (valueBase = Math.random() * 300);
    data.push([dayStr, valueBase]);

    valueBase2 = Math.round((Math.random() - 0.5) * 20 + valueBase2);
    valueBase2 <= 0 && (valueBase2 = Math.random() * 50);
    data2.push([dayStr, valueBase2]);
}

optionline = {
    animation: false,
    title: {
        left: 'center',
        text: '运维处理量',
    },
    legend: {
        top: 'bottom',
        data: ['意向']
    },
    tooltip: {
        triggerOn: 'none',
        position: function (pt) {
            return [pt[0], 130];
        }
    },
    toolbox: {
        left: 'center',
        itemSize: 25,
        top: 55,
        feature: {
            dataZoom: {
                yAxisIndex: 'none'
            },
            restore: {}
        }
    },
    xAxis: {
        type: 'time',
        // boundaryGap: [0, 0],
        axisPointer: {
            value: '2020-6-6',
            snap: true,
            lineStyle: {
                color: '#004E52',
                opacity: 0.5,
                width: 2
            },
            label: {
                show: true,
                formatter: function (params) {
                    return echarts.format.formatTime('yyyy-MM-dd', params.value);
                },
                backgroundColor: '#004E52'
            },
            handle: {
                show: true,
                color: '#004E52'
            }
        },
        splitLine: {
            show: false
        }
    },
    yAxis: {
        type: 'value',
        axisTick: {
            inside: true
        },
        splitLine: {
            show: false
        },
        axisLabel: {
            inside: true,
            formatter: '{value}\n'
        },
        z: 10
    },
    grid: {
        top: 110,
        left: 15,
        right: 15,
        height: 160
    },
    dataZoom: [{
        type: 'inside',
        throttle: 50
    }],
    series: [
        {
            name: '修复量',
            type: 'line',
            smooth: true,
            symbol: 'circle',
            symbolSize: 5,
            sampling: 'average',
            itemStyle: {
                color: '#8ec6ad'
            },
            stack: 'a',
            areaStyle: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                    offset: 0,
                    color: '#8ec6ad'
                }, {
                    offset: 1,
                    color: '#ffe'
                }])
            },
            data: data
        },
        {
            name: '故障剩余',
            type: 'line',
            smooth: true,
            stack: 'a',
            symbol: 'circle',
            symbolSize: 5,
            sampling: 'average',
            itemStyle: {
                color: '#d68262'
            },
            areaStyle: {
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                    offset: 0,
                    color: '#d68262'
                }, {
                    offset: 1,
                    color: '#ffe'
                }])
            },
            data: data2
        }

    ]
};
myChart1.setOption(optionline);

  }
