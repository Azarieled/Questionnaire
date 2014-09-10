package ua.kiev.prog;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Questionnaire.
 *
 * Created by User on 07.07.2014.
 */
public class Questionnaire implements Iterable<Question> {

    public Questionnaire(Question... questions) {
        this.questions = questions;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public int getQuestionCount() {
        return questions.length;
    }

    @Override
    public Iterator<Question> iterator() {
        return new Iterator<Question>() {
            /**
             * Returns {@code true} if the iteration has more elements.
             * (In other words, returns {@code true} if {@link #next} would
             * return an element rather than throwing an exception.)
             *
             * @return {@code true} if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                return nextIndex < questions.length;
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws java.util.NoSuchElementException if the iteration has no more elements
             */
            @Override
            public Question next() {
                return questions[nextIndex++];
            }

            private int nextIndex = 0;
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Questionnaire)) return false;

        Questionnaire questions1 = (Questionnaire) o;

        return Arrays.equals(questions, questions1.questions);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(questions);
    }

    private final Question[] questions;
}
