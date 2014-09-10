package ua.kiev.prog;

/**
 * Class represents respondent.
 *
 * Created by User on 07.07.2014.
 */
public class Respondent {

    public Respondent(String firstName, String lastName, int age,
                      Questionnaire questionnaire, String... answers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.answers = answers;
        this.questionnaire = questionnaire;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String[] getAnswers() {
        return answers;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Respondent)) return false;

        Respondent that = (Respondent) o;

        if (age != that.age) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age;
        return result;
    }

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String[] answers;
    private final Questionnaire questionnaire;
}
