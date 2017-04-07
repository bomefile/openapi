<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar-inverse navbar-fixed-left">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">ZUI &nbsp; <small class="text-muted version-current">v1.1.0</small></a>
	</div>
	<div class="nav navbar-nav">
		<ul class="collapsed">
			<li><i class="glyphicon glyphicon-chevron-right"></i>开始</li>
			<li><a href="#">说明</a></li>
			<li><a href="#">约定</a></li>
			<li><a href="#">文件目录结构</a></li>
			<li><a href="#">关于简洁版</a></li>
			<li><a href="#">编译及定制</a></li>
			<li><a href="#">受支持的平台</a></li>
		</ul>
		<ul class="collapsed">
			<li><i class="glyphicon glyphicon-chevron-right"></i>基础</li>
			<li><a href="#">Hello world</a></li>
			<li><a href="#">全局样式表</a></li>
			<li><a href="#">兼容IE浏览器</a></li>
			<li><a href="#">响应式设计</a></li>
			<li><a href="#">栅格系统</a></li>
			<li><a href="#">文字排版</a></li>
			<li><a href="#">辅助类</a></li>
			<li><a href="#">滚动条</a></li>
			<li><a href="#">配色</a></li>
			<li><a href="#">主题</a></li>
		</ul>
		<ul class="collapsed">
			<li><i class="glyphicon glyphicon-chevron-right"></i>控件</li>
			<li><a href="#">图标</a></li>
			<li><a href="#">按钮</a></li>
			<li><a href="#">进度条</a></li>
			<li><a href="#">标签</a></li>
			<li><a href="#">文本框</a></li>
			<li><a href="#">面包屑</a></li>
			<li><a href="#">图片</a></li>
			<li><a href="#">标题</a></li>
			<li><a href="#">分隔</a></li>
		</ul>
		<ul class="collapsed">
			<li><i class="glyphicon glyphicon-chevron-right"></i>组件</li>
			<li><a href="#">消息框</a></li>
			<li><a href="#">代码</a></li>
			<li><a href="#">输入组</a></li>
			<li><a href="#">列表组</a></li>
			<li><a href="#">导航</a></li>
			<li><a href="#">导航条</a></li>
			<li><a href="#">分页器</a></li>
			<li><a href="#">面板</a></li>
			<li><a href="#">表格</a></li>
			<li><a href="#">按钮组</a></li>
		</ul>
		<ul class="collapsed">
			<li><i class="glyphicon glyphicon-chevron-right"></i>JS插件</li>
			<li><a href="#">本地存储</a></li>
			<li><a href="#">模态框</a></li>
			<li><a href="#">下拉菜单</a></li>
			<li><a href="#">标签页</a></li>
			<li><a href="#">提示消息</a></li>
			<li><a href="#">弹出框</a></li>
			<li><a href="#">折叠</a></li>
			<li><a href="#">轮播</a></li>
			<li><a href="#">日期选择</a></li>
			<li><a href="#">Chosen</a></li>
			<li><a href="#">富文本编辑器</a></li>
			<li><a href="#">拖放</a></li>
			<li><a href="#">自动触发器</a></li>
		</ul>
		<ul class="collapsed">
			<li><i class="glyphicon glyphicon-chevron-right"></i>视图</li>
			<li><a href="#">数据表格</a></li>
			<li><a href="#">日历</a></li>
			<li><a href="#">表单</a></li>
			<li><a href="#">文章</a></li>
			<li><a href="#">卡片</a></li>
			<li><a href="#">列表</a></li>
			<li><a href="#">评论</a></li>
			<li><a href="#">仪表盘</a></li>
			<li><a href="#">看板</a></li>
		</ul>
		<ul class="collapsed">
			<li><i class="glyphicon glyphicon-chevron-right"></i>探索</li>
			<li><a href="#">下载源码</a></li>
			<li><a href="#">这些网站在使用</a></li>
		</ul>
	</div>
</nav>
<script>
	$(".navbar-fixed-left .navbar-nav ul li:first-child").click(function() {
		var _parent = $(this).parent();
		_parent.toggleClass("collapsed").toggleClass("uncollapsed");
		_parent.find("li:first-child>i")//
		.toggleClass("glyphicon-chevron-right") //
		.toggleClass("glyphicon-chevron-down");
	}).siblings().click(function() {
		$(".navbar-fixed-left .navbar-nav li.actived").removeClass("actived");
		$(this).addClass("actived");
	});
</script>