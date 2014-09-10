<%@ page import="ua.kiev.prog.Questionnaire" %>
<%@ page import="ua.kiev.prog.questionnaires.PlatformsQuestionnaire" %>
<%@ page import="ua.kiev.prog.Question" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.07.2014
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! private final Questionnaire questionnaire = new ua.kiev.prog.questionnaires.PlatformsQuestionnaire();%>

<html>
  <head>
      <title>Анкета</title>

      <style type="text/css">
          span {
              color: red;
          }
          input,textarea,select {
              border: 1px solid #227AFF;
              color: #6B6B6B;
              padding: 3px;
          }
      </style>
  </head>

  <body>
    <h2 style="color: rgba(255, 18, 24, 0.80)" align="center">Анкета</h2>
    <form action="${pageContext.request.contextPath}/statistics" method="POST">
        <fieldset>
        <legend>Персональная информация</legend>
            <label>
                Имя<br>
                <input type="text" name="firstName" pattern="\D+" required>
            </label>
            <br><br>
            <label>
                Фамилия<br>
                <input type="text" name="lastName" pattern="\D+" required>
            </label>
            <br><br>
            <label>
                Возраст<br>
                <input type="number" name="age" pattern="1?\\d{0,2}" required>
            </label>
        </fieldset><br><br>

        <fieldset>
            <legend>Опрос</legend>
            <%
                int i = 1;
                for (Question question : questionnaire) {
            %>
            <b><%=question.getStatement()%></b>
            <br>
            <% for (String answer : question.getAnswers()) { %>
            <label>
                <input type="radio" name="answer<%=i%>" value=<%=answer%>>
            </label><%=answer%>
            <%  }
                i++;
            %>
            <br><br>
            <%  } %>
        </fieldset>
        <button>Ответить</button>
    </form>
  </body>
</html>