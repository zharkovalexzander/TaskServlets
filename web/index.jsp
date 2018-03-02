<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>TaskServlet</title>
      <style>
          body  {
              padding: 30px;
          }

          input[type="text"] {
              width: 20px;
          }

      </style>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/webServlet" method="post">
      <label>Parameters</label>
          <input type="text" name="A" placeholder="A" pattern="^[-]{0,1}([1-9]{1}\d{0,})|([0]{1})$"/>
          x
             +
          <input type="text" name="B" placeholder="B" pattern="^[-]{0,1}([1-9]{1}\d{0,})|([0]{1})$"/>
          y
             +
          <input type="text" name="C" placeholder="C" pattern="^[-]{0,1}([1-9]{1}\d{0,})|([0]{1})$"/>
      <hr/>
        <label>Max distance</label>
          <input type="text" name="distance" placeholder="1" pattern="^[0-9]*\.?[0-9]+$" />
      <hr/>
          <input type="submit" name="submit" value="submit" />
  </form>
  </body>
</html>
