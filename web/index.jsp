<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <form action="http://localhost:8080/web_war_exploded/calc" METHOD="GET">

  <input type="text" name="firstNumber" value="${f}"/>

  <input type="text" name="secondNumber" value="${s}"/>


  <input type="submit" name="operation" value="+"/>


  <input type="submit" name="operation" value="-"/>

  <input type="submit" name="operation" value="*"/>

  <input type="submit" name="operation" value="/"/>
    </form>
  <br>

  <br>
  <p>Result = ${res}</p>
  </body>
</html>