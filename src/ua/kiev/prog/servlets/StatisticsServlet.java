package ua.kiev.prog.servlets;

import ua.kiev.prog.*;
import ua.kiev.prog.questionnaires.PlatformsQuestionnaire;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class StatisticsServlet extends HttpServlet {

    public StatisticsServlet() {
        super();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        super.service(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Respondent respondent = newRespondent(request);
        if (results.add(respondent)) {
            builder.append("<fieldset><h4 style=\"color: blue\">Добро пожаловать, ");
            builder.append(respondent.getFirstName());
            builder.append(" ");
            builder.append(respondent.getLastName());
            builder.append("</h4></fieldset>");
        } else {
            builder.append("<fieldset><h4 style=\"color: rgba(255, 18, 24, 0.80)\" align=\"center\">" +
                    "Вы уже голосовали в этом опросе!</h4></fieldset>");
        }
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        for (Question question : questionnaire) {
            builder.append("<fieldset><legend>");
            builder.append(question.getStatement());
            builder.append("</legend>");
            for (String s : question.getAnswers()) {
                builder.append(s).append(": ");
                builder.append(results.get(question, s));
                builder.append("<br>");
            }
            builder.append("</fieldset><br><br>");
        }
        response.getWriter().printf(HTML, builder);
        builder = new StringBuilder();
    }

    private Respondent newRespondent(HttpServletRequest request)
    {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = parseInt(request.getParameter("age"));
        String answer1 = request.getParameter("answer1");
        String answer2 = request.getParameter("answer2");
        return new Respondent(firstName, lastName, age,
                questionnaire, answer1, answer2);
    }

    private Questionnaire questionnaire = new PlatformsQuestionnaire();
    private QuestionnaireResults results = new QuestionnaireResults(questionnaire);
    private StringBuilder builder = new StringBuilder();
    private static final String HTML = "<html>" +
            "<head><title>Статистика опроса</title></head>" +
            "<body>%s</body>" +
            "</html>";
}
