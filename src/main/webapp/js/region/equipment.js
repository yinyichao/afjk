function show() {
	document.getElementById("changeDiv").style.display = "block";
}
function hidden() {
	if (document.getElementById("changeDiv").style.display == "block") {
		document.getElementById("changeDiv").style.display = "none";
	}
}
function changePrison(url) {
	parent.main.location.href = url;
}

//节点
function node(text,img,scene) {
	var node = new JTopo.Node(text);
	node.setLocation(100, 100);
	node.setSize(150, 150);
	node.setImage('/images/' + img + '.png');
	node.fontColor = "100,100,100";
	node.font = "16px Consolas"
	scene.add(node);
	return node
};
//连线
function linkNode(nodeFrom, nodeTo,scene) {
	var link = new JTopo.Link(nodeFrom, nodeTo); // 增加连线
	link.strokeColor = '214,214,214';
	scene.add(link);
};

//自定义节点
function linkNet(x,y,scene) {
	var nodeFrom = new JTopo.Node();
	nodeFrom.setSize(0, 0);
	nodeFrom.setCenterLocation(x, y);
	nodeFrom.fillColor = "213,229,238";
	nodeFrom.alpha = '1';
	nodeFrom.fontColor = "0,0,0";
	scene.add(nodeFrom);
	return nodeFrom;
}
//文本框线
function linkText(x, y, z, r,scene) {
	var node1 = linkNet(x - z, y,scene);
	var node2 = linkNet(x + z, y,scene);
	var node3 = linkNet(x - z, y + r,scene);
	var node4 = linkNet(x + z, y + r,scene);
	linkNode(node1, node2,scene)
	linkNode(node1, node3,scene)
	linkNode(node2, node4,scene)
	linkNode(node3, node4,scene)

}
//文本
function Text(x, y,scene,diagramNodes) {
	var data = [ "摄像机","仓井","电网","门禁","手机屏蔽","生命探测" ];
	var n = 0;
	for (var i = 0; i < 3; i++) {
		for (var j = 0; j < 2; j++) {
			var text = data[n++];
			var nodeText = new JTopo.Node(text);
			nodeText.setSize(38, 20);
			nodeText.setCenterLocation(x - 78 + j * 115,y + i * 25);
			nodeText.fillColor = "255,255,255";
			nodeText.fontColor = "0,0,0";
			nodeText.textPosition = "Middle_Center";
			nodeText.alpha = '0.3';
			scene.add(nodeText);
		}
	}
	var num = [diagramNodes.perimeter,diagramNodes.tel,diagramNodes.ewire,diagramNodes.door,diagramNodes.phone,diagramNodes.life];
	var m = 0;
	for (var r = 0; r < 4; r++) {
		for (var e = 0; e < 2; e++) {
			var text = num[m++];
			var nodeText = new JTopo.Node(text);
			nodeText.setSize(38, 20);
			nodeText.setCenterLocation(x - 30 + e * 115,y + r * 25);
			nodeText.fillColor = "255,255,255";
			nodeText.fontColor = "10,10,255";
			nodeText.font = "16px Consolas"
			nodeText.textPosition = "Middle_Center";
			nodeText.alpha = '0.5';
			scene.add(nodeText);
		}
	}

}
window.onload = function() {
	var diagramRoot = document.getElementById("diagramRoot").value;
	if(diagramRoot!=''){
		var winWidth,winHeight=0;
		// 获取窗口宽度
		if (window.innerWidth)
			winWidth = window.innerWidth;
		else if ((document.body) && (document.body.clientWidth))
			winWidth = document.body.clientWidth;
		// 获取窗口高度
		if (window.innerHeight)
			winHeight = window.innerHeight;
		else if ((document.body) && (document.body.clientHeight))
			winHeight = document.body.clientHeight;
		// 通过深入 Document 内部对 body 进行检测，获取窗口大小
		if (document.documentElement && document.documentElement.clientHeight
				&& document.documentElement.clientWidth) {
			winHeight = document.documentElement.clientHeight;
			winWidth = document.documentElement.clientWidth;
		}
		var canvas = document.getElementById('canvas');
		canvas.width = winWidth;
		canvas.height = winHeight;
		
		var stage = new JTopo.Stage(canvas);
		var scene = new JTopo.Scene(stage);
		scene.mode = "drag";
		
		//一级节点
		var picture1 = node(diagramRoot, 'icon1',scene);
		picture1.setCenterLocation(canvas.width / 2, canvas.height/8);

		var node1 = linkNet(canvas.width / 2, canvas.height/4,scene);
		var node2 = linkNet(canvas.width / 2, canvas.height/2.7,scene);
		linkNode(node1, node2,scene);

		var node_1 = [];
		var node_2 = [];
		var widths = [600,214,110,65,45,32];
		var diagramNodes = document.getElementById("diagramNodes").value;
		diagramNodes = eval("("+diagramNodes+")");
		var length = diagramNodes.length;
		for(var i = 0;i<length;i++){
			node_1[i] = linkNet(canvas.width/1.2 - i * length * widths[length-2] , canvas.height/2.7,scene);
			node_2[i] = linkNet(canvas.width/1.2 - i * length * widths[length-2] , canvas.height/2,scene);
			linkNode(node_1[i], node_2[i],scene);
			
			var picture1 = node(diagramNodes[i].name, 'icon3',scene);
			picture1.setCenterLocation(canvas.width/1.2 - i * length * widths[length-2] , canvas.height/1.68);
			Text(canvas.width/1.2 - i * length * widths[length-2] , canvas.height/1.37,scene,diagramNodes[i]);
			linkText(canvas.width/1.2 - i * length * widths[length-2] , canvas.height/1.4, 104, 85,scene);
		}
		linkNode(node_1[0], node_1[node_1.length-1],scene);
	}
}