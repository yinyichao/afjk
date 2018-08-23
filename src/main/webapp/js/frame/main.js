$().ready(function(){
	// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    legend: {
		    	selectedMode:false,
		    	right :48,
		    	//top:45,
		    	height:22,
		    	padding: [
				    40,  // 上
				    32, // 右
				    18,  // 下
				    10, // 左
				],
				itemWidth:22,
				itemHeight:22,
				textStyle:{
					color:'#333333'
				},
		        data:['摄像头','仓讲','门禁','电网','会见','生命探测','手机屏蔽']
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis : [
		        {
		            type : 'category',
		            axisLine :{
		            	lineStyle:{
		            		color:{
		            		type: 'linear',
		            		color:'#d1d1d1',
		            		},
		            		width :2
		            	}
		            },
		            axisTick :{
		            	show:false
		            },
		            /* axisLabel:{
                     interval:0,
                     rotate:45,
                     margin:2,
                     textStyle:{
                              color:"#222"
                     }}, */

		            data : ['哈尔滨','北安','牡丹江','呼兰','泰来','六三','讷河','凤凰山','华山','五大连池','香兰','新康','佳木斯','双鸭山','松滨','未犯所','新建','鸡西','七台河','女子监狱','齐齐哈尔',]
		        }
		    ],
		    grid: { // 控制图的大小，调整下面这些值就可以，
	              x: 40,
	              y: 75,
	              x2: 38,
	              y2: 40// y2可以控制 X轴跟Zoom控件之间的间隔，避免以为倾斜后造成 label重叠到zoom上
     		},
		    yAxis : [
		        {
		            type : 'value',
		            name:'单位：（个）',
		            yAxis : 10,
		            interval: 50,
		            axisLine :{
		            	show:false
		            },
		            axisTick :{
		            	show:false
		            },
		            data:[],
		        }
		    ],
		    series : [
		    	{
		            name:'摄像头',
		            type:'bar',
		            stack: '设备',
		            barWidth : 36,//柱图宽度
		            itemStyle:{  
                         normal:{color:'#125282'}  
                    },
		            data:eval($("#sec1").val()),
	    	 },
		        {
		            name:'仓讲',
		            type:'bar',
		            stack: '设备',
		            itemStyle:{  
                         normal:{color:'#1c867c'}  
                    },
		            data:eval($("#sec2").val())
		        },
		        {
		            name:'门禁',
		            type:'bar',
		            stack: '设备',
		            itemStyle:{  
                         normal:{color:'#34b57c'}  
                    },
		           	data:eval($("#sec3").val())
		        },
		        {
		            name:'电网',
		            type:'bar',
		            stack: '设备',
		            itemStyle:{  
                         normal:{color:'#96e041'}  
                    },
		            data:eval($("#sec4").val())
		        },
		        {
		            name:'会见',
		            type:'bar',
		            stack: '设备',
		            itemStyle:{  
                         normal:{color:'#faf468'}  
                    },
		            data:eval($("#sec5").val())
		        },
		        {
		            name:'生命探测',
		            type:'bar',
		            stack: '设备',
		            itemStyle:{  
                         normal:{color:'#f7a854'}  
                    },
		            data:eval($("#sec6").val())
		        },
		        {
		            name:'手机屏蔽',
		            type:'bar',
		            stack: '设备',
		            itemStyle:{  
                         normal:{color:'#f78761'}  
                    },
		            data:eval($("#sec7").val())
		        }
		        
		       
		    ],barGap:'60%'
		};

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
});

//跳转设备详情
function showEquipmentItem(x){
		 parent.main.location.href="/region/findAllEquipment?code="+x;	
}