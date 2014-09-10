package ua.kiev.prog;

import java.util.Arrays;

/**
 * Question.
 *
 * Created by User on 07.07.2014.
 */
public class Question {
    private final String [] answers;
    private final String statement;

    public Question(String statement, String... answers) {
        this.answers = answers;
        this.statement = statement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question = (Question) o;

        return Arrays.equals(answers, question.answers) &&
                statement.equals(question.statement);

    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(answers);
        result = 31 * result + statement.hashCode();
        return result;
    }

    public final String getStatement() {
        return statement;
    }

    public final String[] getAnswers() {
        return answers;
    }
    
    public final int getAnswerCount() {
        return answers.length;
    }
}
