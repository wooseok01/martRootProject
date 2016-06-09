<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/3.0.3/normalize.css">
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="resources/css/category.css">
  <title>물품 선택</title>
</head>
<body>
  <div id="header" class="">
    <h1>원하는 물품을 클릭하세요!</h1>
    <div id="searchArea">
      <input type="text" id="search" placeholder="물품 검색">
      <input type="button" id ="searchBtn" class="btn btn-primary" value="검색">
    </div>
    <div id="selectList">
      선택 목록 확인하기 &or;
    </div>
  </div>
  
  <div id="contents">
    <c:forEach var="big" items="${bigList}">
      <div class="first category" id="first${big.bId}">
        ${big.bName} &nbsp;&nbsp;>
      </div>
      <c:forEach var="second" items="${secondList}">
        <c:if test="${second.bId == big.bId}">
          <div class="second category" id="second${second.sId}">
            <input type="hidden" class="s${second.bId}">
            <span>${second.sName} &nbsp;&nbsp;></span>
          </div>
          <c:forEach var="third" items="${thirdList}">
            <c:if test="${second.sId == third.sId}">
              <div class="third category" id="third${third.tId}">
                <input type="hidden" class="t${third.sId}">
                <span>${third.tName}</span>
              </div>
            </c:if>
          </c:forEach>
        </c:if>
      </c:forEach>
    </c:forEach>
  </div>
  
  <div id="footer">
    <form action="./martRoot" method="post">
      <input type="hidden" name="floor" value="2">
      <input type="submit" id="submitBtn" value="다음으로 ->">
    </form>
  </div>
  <script src="//code.jquery.com/jquery.min.js"></script>
  <script type="text/javascript" src="resources/script/category.js"></script>
</body>
</html>