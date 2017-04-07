<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/base/base.jsp"%>
<!DOCTYPE html>
<html xmlns:ng="http://angularjs.org" ng-app="index.app" lang="zh-cn">
<head>
<title>扎根</title>
<%@include file="/base/header.jsp"%>
</head>
<body>
	<%@include file="/base/navbar.jsp"%>
	<angular-table model="listOfNumbers" default-sort-column="id" class="demoTable" style="padding-bottom: 1px;"> <header-row> <header-column sortable="true" sort-field-name="id" class="demoHeaderColumn">
	<div class="demoHeaderText">Id</div>
	<sort-arrow-ascending></sort-arrow-ascending> <sort-arrow-descending></sort-arrow-descending> </header-column> <header-column sortable="false" sort-field-name="name" class="demoHeaderColumn">Name</header-column> <header-column sortable="true" sort-field-name="street" class="demoHeaderColumn">
	<div class="demoHeaderText">Street</div>
	<sort-arrow-ascending></sort-arrow-ascending> <sort-arrow-descending></sort-arrow-descending> </header-column> </header-row> <row on-selected="handleRowSelection(row)" selected-color="#87cefa" even-color="#ffffff" odd-color="#eeeeee"> <column>{{ row.id }}</column> <column>{{ row.name }}</column> <column>{{ row.street }}</column> </row> </angular-table>
	<div class="container text-center">
		<div class="center-block">
			<ul class="pagination pagination-sm">
				<li class="disabled"><a href="#">&laquo;</a></li>
				<li class="active"><a href="#"> 1 </a></li>
				<li><a href="#"> 2 </a></li>
				<li><a href="#"> 3 </a></li>
				<li><a href="#"> 4 </a></li>
				<li><a href="#"> 5 </a></li>
				<li><a href="#"> 6 </a></li>
				<li><a href="#"> 7 </a></li>
				<li><a href="#"> 8 </a></li>
				<li><a href="#">9</a></li>
				<li class="disabled"><a href="#">&raquo;</a></li>
			</ul>
		</div>
	</div>
</body>
</html>