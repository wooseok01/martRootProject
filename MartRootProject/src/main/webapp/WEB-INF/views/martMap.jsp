<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/3.0.3/normalize.css">
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="resources/css/map.css">
  <title>${floor}층 정보</title>
</head>
<body>
  <header>
    <input type="hidden" id="floor" value="${floor}">
    <input type="hidden" id="totalCount" value="${totalCount}">
    <ul id="headerLi">
      <li><p id="secondF">2F</p></li>
      <li><p id="thirdF">3F</p></li>
    </ul>
    <div id="showList">현재 층 물품 확인</div>
  </header>
  
  <div id="content">
    <input type="hidden" id="maxWidth" value="${maxWidth}">
    <input type="hidden" id="maxHeight" value="${maxHeight}">
  </div>
  
  <!-- <div id="list"></div> -->
  
  <div id="description">
  
  </div>
    
  <footer>
    <ul>
      <li id="prevBtn">이전</li>
      <li id="nextBtn">다음</li>
    </ul>
  </footer>
  <script src="https://code.jquery.com/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.17/d3.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.17/d3.min.js"></script>
  <script type="text/javascript" src="resources/script/d3BasicFunction.js"></script>
  <script type="text/javascript" src="resources/script/jquery-blink.js"></script>
  <script type="text/javascript" src="resources/script/map.js"></script>
</body>
</html>