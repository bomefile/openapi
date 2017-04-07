<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav id="navbar" class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-inner" role="navigation" bs-navbar>
      <div class="navbar-header"></div>
      <a class="navbar-brand" href="#">BSpider</a>
      <ul class="nav navbar-nav">
        <li data-match-route="/$"><a href="#/">Home</a></li>
        <li data-match-route="/page-one"><a href="#/page-one">Page One</a></li>
        <li data-match-route="/page-two.*"><a href="#/page-two/sub-a">Page Two</a></li>
      </ul>
    </div>
  </div>
</nav>
<script>
	angular.module('index.app', [ 'mgcrea.ngStrap' ]);
</script>