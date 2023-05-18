<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕 나는 메뉴바야</title>
<style>
    .login-area a{
        text-decoration: none;
        font-size : 12px;
        color : black;

    }

    .nav-area{
        background-color : lightpink;
        height : 50px;
        color : rgb(47, 114, 77)
    }

    .menu{
        display: table-cell;
        width: 250px;
        height: 50px;
        vertical-align: middle;
        font-size: 20px;
        font-weight: bold;
    }

    .menu:hover{
        cursor: pointer;
        color:aquea;
    }

    .outer{
        width : 900px;
        background-color : lightpink;
        color : white;
        margin : auto;
        margin-top: 20px;
    }

</style>
</head>
<body>

	<h1 align="center">C클래스</h1>

    <br>

    <div class="login-area" align="right">
    
    	<c:choose>
    	<c:when test="${ empty loginUser }" >
    	
	        <!-- 로그인 전 -->
	        <form action="login.me" method="post">
	            <table>
	                <tr> 
	                    <td>아이디</td>
	                    <td><input type="text" name="userId" required></td>
	                    <td rowspan="2"><button style="height:60px;" type="submit">로그인</button></td>
	                </tr>
	                <tr>
	                    <td>비밀번호</td>
	                    <td><input type="password" name="userPwd" required></td>
	                </tr>
	                <tr>
	                    <td colspan="3">
	                        <a href="enrollForm.me">회원가입</a>
	                    </td>
	                </tr>
	            </table>
	        </form>
        </c:when>
        
        <c:otherwise>
        <!-- 로그인 후 -->
        <div>
            <table>
                <tr>
                    <td colspan="2">
                        <h3>${ sessionScope.loginUser.userName }님 환영합니다 ~ </h3>
                    </td>
                </tr>
                <tr>
                    <td><a href="#">마이페이지</a></td>
                    <td><a href="#">로그아웃</a></td>
                </tr>
            </table>
        </div>
        
        </c:otherwise>
        
        
    	</c:choose>

    </div>

    <br>

    <div class="nav-area" align="center">
        <div class="menu">HOME</div>
        <div class="menu">공지사항</div>
        <div class="menu" onclick="location.href='list.bo?currentPage=1'">게시판</div>
        <div class="menu">ETC</div>
    </div>














	
</body>
</html>