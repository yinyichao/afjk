/*开始预览 */ 
	function showStartPreview(name)
		{
			LoginPlat();
			StartPreview();  
			shoWenzi(name)
	}
	/*开始回放  */
	  function showPlayBack(){
	  	init();
	  	LoginPlat();
	  	OnPlaybackEx();
	  	shoWenzi()
	  }
    /*登陆平台 */
    function LoginPlat()
		{
//			var IP = document.frmApp.IP.value;
//			var port = document.frmApp.port.value;
//			var UserName = document.frmApp.UserName.value;
//			var Password = document.frmApp.Password.value;
			var IP = document.getElementById("IP").value;
			var port = document.getElementById("port").value;
			var UserName = document.getElementById("UserName").value;
			var Password = document.getElementById("Password").value;
			var v1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?><LoginInfo><LoginType>2</LoginType><SynLogin>1</SynLogin><IP>"+IP+"</IP><Port>"+port
			+"</Port><UserName>"+UserName+"</UserName><Password>"+Password+"</Password></LoginInfo>";
			var v = preview.LoginPlat(v1);
			//alert("登陆成功");
		} 
	/*登陆平台预览 */
	function StartPreview()
		{
			//alert("开始预览");
//			var Code = document.frmApp.CameraIndexCode.value;
			var Code = document.getElementById("CameraIndexCode").value;
			var _param = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Preview><CamIndexCode>"+Code+"</CamIndexCode></Preview>";
			preview.StartPreview( _param);
			//setTimeout(,500);
		}
	/*停止预览*/
	function OnStopPreview(){
		preview.StopPreview();
	}
	window.onbeforeunload = onclose;	
	function onclose(){
		//alert("hehe")
		OnStopPreview();
	}
	/*显示文字*/
	function shoWenzi(name){
		var _param = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<OSD>"
		+"<X>0</X>"
		+"<Y>500</Y>"
		+"<Strings>"
		+"<String>"+name+"</String>"
		+"</Strings>"
		+"</OSD>";
		preview.SetOSDParam(_param);
	}
	/*开始回放  */  
    function playBackHK(){
    	LoginPlatBack();
		OnPlaybackEx();
	}
    function init()
	    {
	        var _param = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
	            + "<PlaybackOcxConfig>"
	            + "<SnapParam><FileFormat>0</FileFormat><FilePath>C:\\capture\\</FilePath>"
	            + "<FileCategorization>0</FileCategorization><FileNameFormat></FileNameFormat><SnapMode>2</SnapMode>"
	            + "<ContinousNum>3</ContinousNum><ContinousMode>2</ContinousMode><ContinousInterval>1000</ContinousInterval></SnapParam>"
	            + "<ClipParam><FilePath>C:\clip\\</FilePath><FileNameFormat></FileNameFormat><PackSize>256</PackSize></ClipParam>"
	            + "</PlaybackOcxConfig>";
	        playback.SetLocalParam(_param);
	    }

    function LoginPlatBack()
    {
        //Demo默认使用密码登录方式
//        var IP = document.frmApp.IP.value;
//        var port = document.frmApp.port.value;
//        var UserName = document.frmApp.UserName.value;
//        var Password = document.frmApp.Password.value;
        var IP = document.getElementById("IP").value;
		var port = document.getElementById("port").value;
		var UserName = document.getElementById("UserName").value;
		var Password = document.getElementById("Password").value;
        var v1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?><LoginInfo><LoginType>2</LoginType><IP>"+IP+"</IP><Port>"+port
        +"</Port><UserName>"+UserName+"</UserName><Password>"+Password+"</Password></LoginInfo>";
        //var v1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?><LoginInfo><LoginType>2</LoginType><IP>10.33.29.133</IP><Port>80</Port><UserName>admin</UserName><Password>Abc12345</Password></LoginInfo>";
        //alert(v1);
        var v = playback.LoginPlat(v1);
        if (v != 0)
        {
            alert("登录失败，请查看日志playback.log");
        }
        else
        {
            alert("登录成功");
        }
    }
    /*视频回放 */ 
    function OnPlaybackEx()
    {
//        var Code = document.frmApp.CameraIndexCode.value;
//        var CameraName = document.frmApp.CameraName.value;
//        var StoreDeviceType= document.frmApp.StoreDeviceType.value;
        var Code = document.getElementById("CameraIndexCode").value;
		var CameraName = document.getElementById("CameraName").value;
		var StoreDeviceType = document.getElementById("StoreDeviceType").value;
		
        var BeginTime= document.getElementById("BeginTime").value;
        var EndTime= document.getElementById("EndTime").value;
        var _param = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
        + "<PlaybackBasicInfo><CameraIndexCode>"+Code+"</CameraIndexCode>"
        + "<CameraName>"+CameraName+"</CameraName>"
        + "<StoreDeviceType>"+StoreDeviceType+"</StoreDeviceType>"
        + "<BeginTime>"+BeginTime+"</BeginTime>"
        + "<EndTime>"+EndTime+"</EndTime>"
        + "<RightCode>10001,10002,10003,10004,10005,10006,10011,10012,10013,10014,10015,10017,10020,10021,10022,10024,10027,10028,10029,10032,10033,10051,10052</RightCode>"
        + "</PlaybackBasicInfo>";
        //alert(_param);
        playback.SearchAndPlay(_param);
    }

    function StopPlay()
    {
        playback.StopPlayback();
    }

    function GetPlayerTime()
    {
        //alert(_param);
        var v=playback.GetPlayerTime();
        alert(v);
    }

    function SetPlayPos()
    {
//        var _param = document.frmApp.PlayPosition.value;
        var _param= document.getElementById("PlayPosition").value;
        //alert(_param);
        playback.SetPlayPos(_param);
    }

    function SetPreNextBtnState()
    {
//        var _param = document.frmApp.PreNextBtnVisible.value;
        var _param= document.getElementById("PreNextBtnVisible").value;
        if (_param == "true")
        {
            playback.SetPreNextBtnState(true, true);
        }
        else
        {
            playback.SetPreNextBtnState(false, false);
        }
    }