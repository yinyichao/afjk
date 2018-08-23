window.onload = function(){ 	
  		var myChart = echarts.init(document.getElementById("myChart")); 
  	  	var resultVidicon = document.getElementById("resultVidicon").value; 
  		option = {
  	    tooltip : {
  	        formatter: "{a} <br/>{b} : {c}%" 
  	    },
  	    toolbox: {
  	        show:false,
  	    },
  	    series: [
  	        {
  	            name: '业务指标',
  	            type: 'gauge',
  	            startAngle:180,
  	            endAngle:0, 
  	            splitNumber:5,
  	            //仪表盘轴线
  	            axisLine:{
  	                      show:true,
  	                      // 属性lineStyle控制线条样式
  	                      lineStyle: {
  	                  	    color:[[resultVidicon/100,'#0094ec'],[1,'#cddbe5']]
  	                      }
  	              },
  	            splitLine:{
  	                        show:true,
  	                    },
  	            axisTick: {
  	                        show:false,
  	                    },
  	            //刻度标签
  	            axisLabel:{
  	            			show:true,
  	            			distance:-60,
  	            			textStyle:{
  	            			  color:['#0099CC'],
  	            			  fontWeight:200,
  	            			  fontSize:16,
  	            			},
  	            },
  	            //仪表盘指针
  	            pointer:{
  	            	show:true,
  	                //指针长度
  	                length:'90%',
  	                color:['#3399ff']          	
  	            },
  	            //仪表盘指针样式
  	            itemStyle:{
  	            	normal:{
  	            		color:['#666666'],
  	            	},
  	            },
  	            title:{
  	            	offsetCenter:[-30,'30%'],
  	            	textStyle:{
  	            		fontSize:18,
  	            		color:['#333333'],
  	            	},         	
  	            },
  	            detail: {formatter:'{value}%',
  	            	offsetCenter:[30,'28%'],
  	            	textStyle:{
  	            		fontSize:22,
  	            	},
  	            },
  	            data: [{value:resultVidicon, name:'摄像机'}]
  	        }
  	    ]
  	};
  myChart.setOption(option);
  	
var myChart1 = echarts.init(document.getElementById('myChart1'));
var warehouse = document.getElementById("warehouse").value 
	option = {
    tooltip : {
        formatter: "{a} <br/>{b} : {c}%"
    },
    toolbox: {
        show:false,
    },
    series: [
        {
            name: '业务指标',
            type: 'gauge',
            startAngle:180,
            endAngle:0,
            splitNumber:5,
            axisLine:{
                      show:true,
                      // 属性lineStyle控制线条样式
                      lineStyle: {
                  	    color:[[warehouse/100,'#0094ec'],[1,'#cddbe5']]
                      }
              },
            splitLine:{
                        show:true,
                    },
            axisTick: {
                        show:false,
                    },
            //刻度标签
            axisLabel:{
            			show:true,
            			distance:-60,
            			textStyle:{
            			  color:['#0099CC'],
            			  fontWeight:200,
            			  fontSize:16,
            			}
            },
            //仪表盘指针
            pointer:{
            	show:true,
                //指针长度
                length:'90%',
                color:['#3399ff']          	
            },
            //仪表盘指针样式
            itemStyle:{
            	normal:{
            		color:['#666666'],
            	},
            },
            title:{
            	offsetCenter:[-20,'30%'],
            	textStyle:{
            		fontSize:18,
            		color:['#333333'],
            	},         	
            },
            detail: {formatter:'{value}%',
            	offsetCenter:[30,'28%'],
            	textStyle:{
            		fontSize:22,
            	},
            },
            data: [{value: warehouse, name:'仓讲'}]
        }
    ]
};
myChart1.setOption(option); 

var myChart2 = echarts.init(document.getElementById('myChart2'));
var access = document.getElementById("access").value; 
	option = {
    tooltip : {
        formatter: "{a} <br/>{b} : {c}%"
    },
    toolbox: {
        show:false,
    },
    
    series: [
        {
            name: '业务指标',
            type: 'gauge',
            startAngle:180,
            endAngle:0,
    		splitNumber:5,
            axisLine:{
                      show:true,
                      // 属性lineStyle控制线条样式
                      lineStyle: {
                  	    color:[[access/100,'#0094ec'],[1,'#cddbe5']]
                      }
              },
            splitLine:{
                        show:true,
                    },
            axisTick: {
                        show:false,
                    },
            //刻度标签
            axisLabel:{
            			show:true,
            			distance:-60,
            			textStyle:{
            			  color:['#0099CC'],
            			  fontWeight:200,
            			  fontSize:16,
            			}
            },
            //仪表盘指针
            pointer:{
            	show:true,
                //指针长度
                length:'90%',
                color:['#3399ff']          	
            },
            //仪表盘指针样式
            itemStyle:{
            	normal:{
            		color:['#666666'],
            	},
            },
            title:{
            	offsetCenter:[-20,'30%'],
            	textStyle:{
            		fontSize:18,
            		color:['#333333'],
            	},         	
            },
            detail: {formatter:'{value}%',
            	offsetCenter:[30,'28%'],
            	textStyle:{
            		fontSize:22,
            		color:['#3399ff'],
            	},
            },
            data: [{value:access, name:'门禁'}],
        }
    ]
};
myChart2.setOption(option);

var myChart3 = echarts.init(document.getElementById('myChart3')); 
var lifeDetection = document.getElementById("lifeDetection").value;
	option = {
    tooltip : {
        formatter: "{a} <br/>{b} : {c}%"
    },
    toolbox: {
        show:false,
    },
    series: [
        {
            name: '业务指标',
            type: 'gauge',
            startAngle:180,
            endAngle:0,
            splitNumber:5,
            axisLine:{
                      show:true,
                      // 属性lineStyle控制线条样式
                      lineStyle: {
                  	    color:[[lifeDetection/100,'#0094ec'],[1,'#cddbe5']]
                      }
              },
            splitLine:{
                        show:true,
                    },
            axisTick: {
                        show:false,
                    },
            //刻度标签
            axisLabel:{
            			show:true,
            			distance:-60,
            			textStyle:{
            			  color:['#0099CC'],
            			  fontWeight:200,
            			  fontSize:16,
            			}
            },
            //仪表盘指针
            pointer:{
            	show:true,
                //指针长度
                length:'90%',         	
            },
            //仪表盘指针样式
            itemStyle:{
            	normal:{
            		color:['#666666'],
            	},
            },
            title:{
            	offsetCenter:[-40,'30%'],
            	textStyle:{
            		fontSize:18,
            		color:['#333333'],
            	},         	
            },
            detail: {formatter:'{value}%',
            	offsetCenter:[30,'28%'],
            	textStyle:{
            		fontSize:22,
            		color:['#3399ff'],
            	},
            },
            data: [{value:lifeDetection, name:'生命探测'}]
        }
    ]
};
myChart3.setOption(option);

var myChart4 = echarts.init(document.getElementById('myChart4')); 
var shield = document.getElementById("shield").value
	option = {
    tooltip : {
        formatter: "{a} <br/>{b} : {c}%"
    },
    toolbox: {
        show:false,
    },
    series: [
        {
            name: '业务指标',
            type: 'gauge',
            startAngle:180,
            endAngle:0,
            splitNumber:5,
            axisLine:{
                      show:true,
                      // 属性lineStyle控制线条样式
                      lineStyle: {
                  	    color:[[shield/100,'#0094ec'],[1,'#cddbe5']]
                      }
              },
            splitLine:{
                        show:true,
                    },
            axisTick: {
                        show:false,
                    },
            //刻度标签
            axisLabel:{
            			show:true,
            			distance:-60,
            			textStyle:{
            			  color:['#0099CC'],
            			  fontWeight:200,
            			  fontSize:16,
            			}
            },
            //仪表盘指针
            pointer:{
            	show:true,
                //指针长度
                length:'90%',
                color:['#3399ff']          	
            },
            //仪表盘指针样式
            itemStyle:{
            	normal:{
            		color:['#666666'],
            	},
            },
            title:{
            	offsetCenter:[-40,'30%'],
            	textStyle:{
            		fontSize:18,
            		color:['#333333'],
            	},         	
            },
            detail: {formatter:'{value}%',
            	offsetCenter:[30,'28%'],
            	textStyle:{
            		fontSize:22,
            	},
            },
            data: [{value: shield, name:'手机屏蔽'}]
        }
    ]
};
myChart4.setOption(option);

var myChart5 = echarts.init(document.getElementById('myChart5')); 
var grid = document.getElementById("grid").value;
	option = {
    tooltip : {
        formatter: "{a} <br/>{b} : {c}%"
    },
    toolbox: {
        show:false,
    },
    series: [
        {
            name: '业务指标',
            type: 'gauge',
            startAngle:180,
            endAngle:0,
            splitNumber:5,
            axisLine:{
                      show:true,
                      // 属性lineStyle控制线条样式
                      lineStyle: {
                  	    color:[[grid/100,'#0094ec'],[1,'#cddbe5']]
                      }
              },
            splitLine:{
                        show:true,
                    },
            axisTick: {
                        show:false,
                    },
            //刻度标签
            axisLabel:{
            			show:true,
            			distance:-60,
            			textStyle:{
            			  color:['#0099CC'],
            			  fontWeight:200,
            			  fontSize:16,
            			}
            },
            //仪表盘指针
            pointer:{
            	show:true,
                //指针长度
                length:'90%',
                color:['#3399ff']          	
            },
            //仪表盘指针样式
            itemStyle:{
            	normal:{
            		color:['#666666'],
            	},
            },
            title:{
            	offsetCenter:[-20,'30%'],
            	textStyle:{
            		fontSize:18,
            		color:['#333333'],
            	},         	
            },
            detail: {formatter:'{value}%',
            	offsetCenter:[30,'28%'],
            	textStyle:{
            		fontSize:22,
            	},
            },
            data: [{value: grid, name:'电网'}]
        }
    ]
};
myChart5.setOption(option);
}

function show(){ 	
	document.getElementById("changeDiv").style.display="block";
}
function hidden(){
	if(document.getElementById("changeDiv").style.display=="block"){
		document.getElementById("changeDiv").style.display="none";
	}
	
} 	
function changePrison(url){
	parent.main.location.href=url;
}
function equipmentInform(url){
	parent.main.location.href=url;
}
