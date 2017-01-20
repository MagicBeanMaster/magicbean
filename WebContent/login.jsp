<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>澳洲金鼎</title>
         <!-- IE8及以下版本提示升级 -->
         <!-- <script>window.location.href='http://cdn.dmeng.net/upgrade-your-browser.html?referrer='+location.href;</script> -->
		<%@page import="com.base.constant.Constant"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1.0">        
<link rel="shortcut icon" href="<%=Constant.RESROURSEPATH%>images/favicon.ico">

<link href="<%=Constant.RESROURSEPATH%>css/login.css" rel="stylesheet"/>
<style>
.login{background-color:#fff;padding:2% 0 !important;}
.disabled {cursor: not-allowed;opacity: 0.65;filter: alpha(opacity=65);-webkit-box-shadow: none;box-shadow: none;}
.disabled:hover{color: #fff!important;background-color: #3598dc!important;border: 1px solid #2765bd!important;}
.login .weather-con .weather-bg{ position:absolute; display:inline-block; left:0px; top:0px; right:0px; bottom:0px;z-index:10}
.ie8{position:absolute;top:0;left:0;right:0;bottom:0;color:#000;background-color: #FAF7F7;opacity: 0.8;filter:Alpha(opacity=60);z-index: 999;}
.ie8>div{width:800px;margin:60px auto 0;}
.ie8 h1{font-size: 36px;font-weight: 100;}
.ie8 p{margin:20px 0;font-size: 30px;color:red;font-weight:bold;}
.ie8 .browser{padding: 10px 0;}
.ie8 .browser li{width: 146px;height: 34px;line-height: 22px;float: left;list-style: none;}
.ie8 .browser a{margin-right:10px;color: #0072c6;font-size: 18px;}
.ie8 .browser a span{display: block;font-size: 12px;line-height: 12px;}
</style>
    </head>
    <%
    	if(session.getAttribute("businessUser") != null){
    		session.removeAttribute("businessUser");
    		session.invalidate();
    	}
    %>
    <img src="<%=basePath %>state/img/cloud10.png" style="display:none" />
    
    <body class="login" onload="load()">
    	<!-- <div class="ie8">
			<div>
				<p>为了让您对系统的体验更佳友好，我们建议您升级浏览器</p>
				<hr>
				<ul class="browser">
					<li class="browser-chrome"><a href="http://rj.baidu.com/soft/detail/14744.html" target="_blank"> 谷歌浏览器<span>Google Chrome</span></a></li>
					<li class="browser-firefox"><a href="http://rj.baidu.com/soft/detail/11843.html"  target="_blank"> 火狐浏览器<span>Mozilla Firefox</span></a></li>
					<li class="browser-ie"><a href="http://rj.baidu.com/soft/detail/14917.html"  target="_blank"> IE浏览器<span>Internet Explorer</span></a></li>
					<li class="browser-360"><a href="http://se.360.cn/"  target="_blank"> 360安全浏览器 <span>360 Security Browser</span></a></li>
				</ul>
			</div>
		</div> -->
   		<!--[if lte IE 8]>
		
   		<![endif]-->
        <div class="log-content" style="background:none">
        <i style="z-index:1;position:absolute;border-radius:5px; left:0px; top:0px; right:0px; bottom:0px; background:#fff;opacity:1;"></i>
             <form style="position:relative;z-index:2;" id="loginform" class="login-form" action="<%=basePath%>login/toLogin.php" method="post">
                <h3 class="form-title">
                	<img alt="澳洲金鼎" src="<%=Constant.RESROURSEPATH%>images/aozhoulogo_06.png"> 
                	<div>澳洲地产客户管理系统</div>
                </h3>
                <div id="mess" class="alert alert-danger display-hide">
                    <button type="button" class="close" data-close="alert" onclick="this.parentNode.style.display='none'"></button>
                    <span id="tip">请填写正确的账号与密码</span>
                </div>
                <div class="form-group">
                    <input class="form-control form-control-solid placeholder-no-fix" id="account" onkeydown="accountDown(event)"  type="text" autocomplete="off" placeholder="用户名" name="account"/>
                	 <img class="form-group-img" src="<%=Constant.RESROURSEPATH%>images/user.png"  />
                </div>
                <div class="form-group">
                   
                    <input class="form-control  form-control-solid placeholder-no-fix" id="pwd" type="password" onkeydown="passwordDown(event)" autocomplete="off" placeholder="密码" name="pwd"/>
                	  <img class="form-group-img" src="<%=Constant.RESROURSEPATH%>images/lock2.png"  />
                </div>
                <div class="form-group clearfix" style="padding-right:120px;">
                    <input class="form-control form-control-code form-control-solid placeholder-no-fix" onkeydown="codeDown(event)" type="text" name="code" id = "code" value="" class="loginText loginyanz"  maxlength="4"  placeholder="验证码" 
                  />
			        <a style="float:right" href="javascript:void(0)" onclick="refresh()">
			         <img  id="random_img" src="<%=basePath%>random/code.php?r=<%=new java.util.Random().nextDouble()%>"/></a>
			          <img src="<%=Constant.RESROURSEPATH%>images/question_shield_filled.png"  class="form-group-img" />
                </div>
                <div class="form-actions">
                    <input type="button" id="btnlogin" class="btn blue" onClick="doLogin()" value="登录" >
                </div>
                <%-- <a href="<%=Constant.basePath%>index/test.php">BC测试消息发送</a> --%>
                
            </form>
        </div>
        <div class="info-copyright" >
<!--           <div style="margin-bottom:5px;"><a href="http://www.chinakingding.com/"  target="_bank" >金鼎集团官网</a></div> -->
          <div>版权所有：成都金鼎时代网络科技有限公司   Copyright  2015 澳洲地产 All Rights Reserved   蜀ICP备15022293号</div>
        </div>
        <div  class="weather-con">
        <i class="weather-bg"></i>
        	 <iframe   id="weather-con" width="420" scrolling="no" height="60" frameborder="0" allowtransparency="true" src=""></iframe>
        </div>
         

<script type="text/javascript" src="<%=Constant.RESROURSEPATH%>js/plugins/cloud/ThreeWebGL.js"></script>
<script type="text/javascript" src="<%=Constant.RESROURSEPATH%>js/plugins/cloud/ThreeExtras.js"></script>
<script type="text/javascript" src="<%=Constant.RESROURSEPATH%>js/plugins/cloud/Detector.js"></script>
<script type="text/javascript">

		if(window.top!==window.self){
			parent.window.location.href = window.location.href;
		}
		<%-- window.onfocus=function(){
			 var xhr2 = null,_url2='<%=basePath%>login/validateSess.php';
	       	 window.XMLHttpRequest ? xhr2 = new XMLHttpRequest() : xhr2 = new ActiveXObject("Microsoft.XMLHTTP");
	       	 xhr2.open("GET", _url2, true);
	       	 xhr2.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	       	 xhr2.onreadystatechange = function(){
	       	     var XMLHttpReq = xhr2;
	       	     if (XMLHttpReq.readyState == 4) {
	       	         if (XMLHttpReq.status == 200) {
	       	        	var datas= eval('('+xhr2.responseText+')');
	       	        	if(datas.flag==-1){
	       	        		window.location.href='<%=basePath%>login/toMain.php';
	       	        	}
	       	     	}
	       	 	};
	       	 }
	       	xhr2.send(null);
		} --%>
    	function refresh(){
    		document.getElementById("random_img").src='<%=basePath%>random/code.php?r='+Math.random();
    	}
    	function load(){
    		var iframeSrc='http://i.tianqi.com/index.php?c=code&id=12&color=%23FFFFFF&icon=1&num=5';
    		document.getElementById('weather-con').setAttribute("src",iframeSrc);
    		delCookie('JSESSIONID');
      		delCookie('sid');
    	}
    	function delCookie (NameOfCookie){
    		document.cookie = NameOfCookie + "=" + "; expires=Thu, 01-Jan-70 00:00:01 GMT";
    	}
    	var _pwd=document.getElementById("pwd"),
    		_code=document.getElementById("code"),
    		_account=document.getElementById("account");
    	function accountDown(e){
    		var key = e.which;
    		if (key == 13) {
    			var p=_pwd.value;
  	        	var c = _code.value;
  	            e.preventDefault(); 
  	          	if(p=='' || p=='undefined' || p.length<1){
  	          		_pwd.focus();
	            }else if(c=='' || c=='undefined' || c.length<1){
	            	_code.focus();
	            }else{
	            	doLogin();
	            }
    		}
    		
    	}
    	function passwordDown(e){
    		var key = e.which;
    		if (key == 13) {
    			var a=_account.value;
  	        	var c = _code.value;
  	            e.preventDefault(); 
  	          	if(a=='' || a=='undefined' || a.length<1){
  	          		_account.focus();
	            }else if(c=='' || c=='undefined' || c.length<1){
	            	_code.focus();
	            }else{
	            	doLogin();
	            }
    		}
    		
    	}
    	function codeDown(e){
    		var key = e.which;
    		if (key == 13) {
    			var a=_account.value;
  	        	var p = _pwd.value;
  	            e.preventDefault(); 
  	          	if(a=='' || a=='undefined' || a.length<1){
  	          		_account.focus();
	            }else if(p=='' || p=='undefined' || p.length<1){
	            	_pwd.focus();
	            }else{
	            	doLogin();
	            }
    		}
    		
    	}
    	
      	function toUnicode(str) {
      		 var temp,i = 0,r = '',len = str.length;
      		 for (; i < len; i++) {
      			 temp = str.charCodeAt(i).toString(16);
      			 while ( temp.length < 4 ){
      				 temp = '0' + temp;
      			 }
      			 r += '\\u' + temp;
      		 }
      		 return r;
      	}
    	function doLogin(){
    	
    		var a=(document.getElementById('account').value).replace(/(^\s*)|(\s*$)/g,''),
    			p=(document.getElementById('pwd').value).replace(/(^\s*)|(\s*$)/g,''),
    			code =(document.getElementById('code').value).replace(/(^\s*)|(\s*$)/g,''),
    			_tip=document.getElementById('tip'),
    			_mess=document.getElementById('mess'),
    			_btnlogin=document.getElementById('btnlogin'),
    			_url="<%=basePath%>plat/login/tologin.php",
    			_data={};
        	if(a=='' || a=='undefined'){
        		_tip.innerHTML="请输入用户名";
        		_mess.style.display="block";
        		return;
        	}
        	if(p=='' || p=='undefined'){
        		_tip.innerHTML="请输入密码";
        		_mess.style.display="block";
        		return;
        	}
        	if(code=='' || code=='undefined'){
        		_tip.innerHTML="请输入验证码";
        		_mess.style.display="block";
        		return;
        	}
        	addClass(_btnlogin,'disabled');
        	_btnlogin.disabled=true;
        	_btnlogin.value="loading...";
        	_data={"account":toUnicode(a),"pwd":toUnicode(p),"code":code};
        	_data = (function(obj){ 
        	    var str = "";
        	    for(var prop in obj){
        	        str += prop + "=" + obj[prop] + "&"
        	    }
        	    return str;
        	})(_data);
        	_data=_data.substring(0,_data.length-1);
        	 var xhr = null;
        	 window.XMLHttpRequest ? xhr = new XMLHttpRequest() : xhr = new ActiveXObject("Microsoft.XMLHTTP");
        	 xhr.open("POST", _url, true);
        	 xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        	 xhr.onreadystatechange = function(){
        	     var XMLHttpReq = xhr;
        	     if (XMLHttpReq.readyState == 4) {
        	         if (XMLHttpReq.status == 200) {
        	        	var datas= eval('('+xhr.responseText+')');
        	        	 if(datas.flag==1){
     						window.location.href='<%=basePath%>plat/login/tomain.php';
     					}else if(datas.flag==0){
     						_tip.innerHTML="请填写正确密码";
     						_mess.style.display="block";
     						refresh();
     						document.getElementById('code').value="";
     					}else if(datas.flag==-4){
     						_tip.innerHTML="请填写正确的用户名和密码";
     						_mess.style.display="block";
     						refresh();
     						document.getElementById('code').value="";
     						
     					}else if(datas.flag==-3){
     						_tip.innerHTML="登录异常，请稍后重试";
     						_mess.style.display="block";
     						refresh();
     						document.getElementById('code').value="";
     					}else if(datas.flag==-2){
     						_tip.innerHTML="此账号不存在或还未分配角色，请重新输入";
     						_mess.style.display="block";
     						refresh();
     						document.getElementById('code').value="";
     					}else if(datas.flag==-1){
     						_tip.innerHTML="请填写正确的验证码";
     						_mess.style.display="block";
     						refresh();
     						document.getElementById('code').select();
     					} 
        	        	 removeClass(_btnlogin,'disabled');
        	 			_btnlogin.disabled=false;
        	 			_btnlogin.value="登录";
        	         }else{
        	        	 removeClass(_btnlogin,'disabled');
        	        	 _btnlogin.disabled=false;
        	        	 _btnlogin.value="登陆";
        	        	 refresh();
        	        	 _tip.innerHTML="登录异常，请稍后重试";
  						_mess.style.display="block";
        	         }
        	     }
        	 };
        	 xhr.send(_data);
    	}
    	function addClass(obj, cls){
    	    var obj_class = obj.className,
    	    blank = (obj_class != '') ? ' ' : '';
    	    added = obj_class + blank + cls;
    	    obj.className = added;
    	}
    	 
    	function removeClass(obj, cls){
    	    var obj_class = ' '+obj.className+' ';
    	    obj_class = obj_class.replace(/(\s+)/gi, ' '),
    	    removed = obj_class.replace(' '+cls+' ', ' ');
    	    removed = removed.replace(/(^\s+)|(\s+$)/g, '');
    	    obj.className = removed;
    	}
      	
    </script>
    
  <script id="vs" type="x-shader/x-vertex">
      varying vec2 vUv;
      void main() {
        vUv = uv;
        gl_Position = projectionMatrix * modelViewMatrix * vec4( position, 1.0 );
      }
    </script>
    <script id="fs" type="x-shader/x-fragment">
      uniform sampler2D map;
      uniform vec3 fogColor;
      uniform float fogNear;
      uniform float fogFar;
      varying vec2 vUv;
      void main() {
        float depth = gl_FragCoord.z / gl_FragCoord.w;
        float fogFactor = smoothstep( fogNear, fogFar, depth );
        gl_FragColor = texture2D( map, vUv );
        gl_FragColor.w *= pow( gl_FragCoord.z, 20.0 );
        gl_FragColor = mix( gl_FragColor, vec4( fogColor, gl_FragColor.w ), fogFactor );

      }
    </script>
<script type="text/javascript">
      if ( ! Detector.webgl ) Detector.addGetWebGLMessage();
      var canvas = document.createElement( 'canvas' );
      canvas.width = 32;
      canvas.height = window.innerHeight;
      var context = canvas.getContext( '2d' );
      var gradient = context.createLinearGradient( 0, 0, 0, canvas.height );
      gradient.addColorStop(0, "#1e4877");
      gradient.addColorStop(0.5, "#4584b4");
      context.fillStyle = gradient;
      context.fillRect(0, 0, canvas.width, canvas.height);
      document.body.style.background = 'url(' + canvas.toDataURL('image/png') + ')';
      var container;
      var camera, scene, renderer, sky, mesh, geometry, material,
      i, h, color, colors = [], sprite, size, x, y, z;
      var mouseX = -0.54, mouseY = -18.85;
      var start_time = new Date().getTime();
      var windowHalfX = window.innerWidth / 2;
      var windowHalfY = window.innerHeight / 2;
      init();
      animate();
      function init() {
        container = document.createElement( 'div' );
        document.body.appendChild( container );
        camera = new THREE.Camera( 30, window.innerWidth / window.innerHeight, 1, 3000 );
        camera.position.z = 6000;
        scene = new THREE.Scene();
        geometry = new THREE.Geometry();
        var texture = THREE.ImageUtils.loadTexture( '<%=basePath %>state/img/cloud10.png' );
        texture.magFilter = THREE.LinearMipMapLinearFilter;
        texture.minFilter = THREE.LinearMipMapLinearFilter;
        var fog = new THREE.Fog( 0x4584b4, - 100, 3000 );
        material = new THREE.MeshShaderMaterial( {
          uniforms: {

            "map": { type: "t", value:2, texture: texture },
            "fogColor" : { type: "c", value: fog.color },
            "fogNear" : { type: "f", value: fog.near },
            "fogFar" : { type: "f", value: fog.far },

          },
          vertexShader: document.getElementById( 'vs' ).textContent,
          fragmentShader: document.getElementById( 'fs' ).textContent,
          depthTest: false

        } );
        var plane = new THREE.Mesh( new THREE.Plane( 64, 64 ) );
        for ( i = 0; i < 8000; i++ ) {
          plane.position.x = Math.random() * 1000 - 500;
          plane.position.y = - Math.random() * Math.random() * 200 - 15;
          plane.position.z = i;
          plane.rotation.z = Math.random() * Math.PI;
          plane.scale.x = plane.scale.y = Math.random() * Math.random() * 1.5 + 0.5;
          GeometryUtils.merge( geometry, plane );
        }
        mesh = new THREE.Mesh( geometry, material );
        scene.addObject( mesh );

        mesh = new THREE.Mesh( geometry, material );
        mesh.position.z = - 8000;
        scene.addObject( mesh );

        renderer = new THREE.WebGLRenderer( { antialias: false } );
        renderer.setSize( window.innerWidth, window.innerHeight );
        container.appendChild( renderer.domElement );

       // document.addEventListener( 'mousemove', onDocumentMouseMove, false );
        window.addEventListener( 'resize', onWindowResize, false );

      }

      function onDocumentMouseMove( event ) {

        mouseX = ( event.clientX - windowHalfX ) * 0.25;
        mouseY = ( event.clientY - windowHalfY ) * 0.15;

      }

      function onWindowResize( event ) {

        camera.aspect = window.innerWidth / window.innerHeight;
        camera.updateProjectionMatrix();

        renderer.setSize( window.innerWidth, window.innerHeight );

      }

      function animate() {

        requestAnimationFrame( animate );
        render();

      }

      function render() {

        position = ( ( new Date().getTime() - start_time ) * 0.03 ) % 8000;

        camera.position.x += ( mouseX - camera.target.position.x ) * 0.01;
        camera.position.y += ( - mouseY - camera.target.position.y ) * 0.01;
        camera.position.z = - position + 8000;

        camera.target.position.x = camera.position.x;
        camera.target.position.y = camera.position.y;
        camera.target.position.z = camera.position.z - 1000;

        renderer.render( scene, camera );

      }

    </script>
   
 
    </body>
</html>
