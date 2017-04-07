<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/base/base.jsp"%>
<!DOCTYPE html>
<html xmlns:ng="http://angularjs.org" ng-app lang="zh-CN">
<head>
<title>扎根</title>
<%@include file="/base/header.jsp"%>
</head>
<body>
  <%@include file="/base/navbar.jsp"%>
  <div class="container">
    <div class="modal bs-addoredit-modal-lg" data-backdrop="static" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header ">
            <h4 class="modal-title">添加抓取任务</h4>
          </div>
          <div class="modal-body">主要内容</div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">
              <span aria-hidden="true"><span class="glyphicon glyphicon-remove"></span>取消</span>
            </button>
            <button type="button" class="btn btn-default btn-sm">
              <span class="glyphicon glyphicon-floppy-disk"></span>提交
            </button>
          </div>
        </div>
      </div>
    </div>
    <button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target=".bs-addoredit-modal-lg" style="margin-bottom: 10px;">
      <span class="glyphicon glyphicon-plus"></span>添加
    </button>
    <div class="panel panel-info">
      <table class="table table-condensed table-striped table-hover table-bordered ">
        <thead>
          <tr>
            <th width="48">编号</th>
            <th>名称</th>
            <th width="72">监控</th>
            <th width="72">状态</th>
            <th width="192">操作</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td><small>Mark</small></td>
            <td><small>正在执行</small></td>
            <td><span class="glyphicon glyphicon-ok"></span>生效</td>
            <td>
              <button type="button" class="btn btn-default btn-xs">
                <span class="glyphicon glyphicon-forward"></span>抓取
              </button>
              <button type="button" class="btn btn-default btn-xs">
                <span class="glyphicon glyphicon-save"></span>入库
              </button>
            </td>
          </tr>
          <tr>
            <td>2</td>
            <td><small>Masdfsdfrk</small></td>
            <td><small>已经停止</small></td>
            <td><span class="glyphicon glyphicon-remove"></span>失效</td>
            <td>
              <button type="button" class="btn btn-default btn-xs">
                <span class="glyphicon glyphicon-stop"></span>停止
              </button>
            </td>
          </tr>
          <tr>
            <td>3</td>
            <td><small>Larry</small></td>
            <td><small>正在执行</small></td>
            <td><span class="glyphicon glyphicon-ok"></span>生效</td>
            <td>
              <button type="button" class="btn btn-default btn-xs">
                <span class="glyphicon glyphicon-forward"></span>抓取
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
  <div class="container text-center">
    <div class="center-block">
      <ul class="pagination pagination">
        <li class="disabled"><a href="#">&laquo;</a></li>
        <li class="active"><a href="#"> 1 </a></li>
        <li><a href="#"> 2 </a></li>
        <li><a href="#"> 3 </a></li>
        <li><a href="#"> 4 </a></li>
        <li><a href="#"> 5 </a></li>
        <li><a href="#"> 6 </a></li>
        <li><a href="#"> 7 </a></li>
        <li><a href="#"> 8 </a></li>
        <li><a href="#"> 9 </a></li>
        <li class="disabled"><a href="#">&raquo;</a></li>
      </ul>
    </div>
  </div>
</body>
</html>