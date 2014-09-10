package ua.kiev.prog;

import java.util.HashMap;
import java.util.HashSet;

/**
 * The class, that keeps the statistics of the
 * Questionnaire
 * 
 * Created by User on 07.07.2014.
 */
public class QuestionnaireResults {
    public QuestionnaireResults(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
        int questionCount = questionnaire.getQuestionCount();
        map = new HashMap<Question, HashMap<String, Integer>>(questionCount);
        
        for (Question question : questionnaire) {
            HashMap<String, Integer> answerCounts =
                    new HashMap<String, Integer>(question.getAnswerCount());
            
            // init new answer map
            for (String answer : question.getAnswers()) {
                answerCounts.put(answer, 0);
            }
            
            // put the answer map to question
            map.put(question, answerCounts);
        }
    }

    public boolean add(Respondent respondent) {
        if (respondents.contains(respondent) ||
                !respondent.getQuestionnaire().equals(questionnaire)) {
            return false;
        }

        int i = 0; // current question number
        for (Question question : questionnaire) {
            String answer = respondent.getAnswers()[i++];
            HashMap<String, Integer> answerCounters = map.get(question);

            // incrementing
            int oldValue = answerCounters.get(answer);
            answerCounters.put(answer, oldValue + 1);
        }
        
        return respondents.add(respondent);
    }
    
    public int get(Question question, String answer) {
        return map.get(question).get(answer);
    }

    private final Questionnaire questionnaire;
    private final HashMap<Question, HashMap<String, Integer>> map;
    private final HashSet<Respondent> respondents = new HashSet<Respondent>();
}
