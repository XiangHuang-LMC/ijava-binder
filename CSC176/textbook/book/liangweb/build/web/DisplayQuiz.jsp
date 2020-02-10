<!-- DisplayQuiz.jsp -->
<%@ page import = "chapter42Quiz.QuizWebService" %>
<%@ page import = "chapter42Quiz.QuizService" %>
<jsp:useBean id = "quizWebService" scope = "session" 
  class = "chapter42Quiz.QuizWebService">
</jsp:useBean>

<html>
<body>
  <%
  QuizService proxy = quizWebService.getQuizServicePort();
  proxy.generateQuiz();
  java.util.List<String> questions = 
    (java.util.ArrayList<String>)(proxy.getQuestions());
  %>  
  <form method = "post" action = "GradeQuiz.jsp">
  <table>
    <% for (int i = 0; i < questions.size(); i++) {%>
    <tr>
    <td>
      <label><%= questions.get(i) %></label>
    </td>
    <td>
      <input type = "radio" name = <%= "question" + i%> 
        value = "True" /> True 
    </td>
    <td>
      <input type = "radio" name = <%= "question" + i%> 
        value = "False" /> False
    </td> 
    </tr>
    <%}%>
  </table>
  <p><input type = "submit" name = "Submit" value = "Submit">
    <input type = "reset" value = "Reset">
  </p>
  </form>
</body>
</html> 
