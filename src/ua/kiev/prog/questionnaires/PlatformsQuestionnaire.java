package ua.kiev.prog.questionnaires;

import ua.kiev.prog.Question;
import ua.kiev.prog.Questionnaire;

/**
 * One of the implemented questionnaires.
 * Created by User on 07.07.2014.
 */
public final class PlatformsQuestionnaire extends Questionnaire {

    public PlatformsQuestionnaire() {
        super
        (
            new Question
            (
                "Какая ваша любимая мобильная платформа: ",
                "Android",
                "iOS",
                "Windows Phone",
                "Symbian",
                "Nokia Series 40",
                "bada",
                "Tizen",
                "BlackBerry",
                "другая"
            ),
            new Question
            (
                "Какая ваша любимая ОС: ",
                "Windows",
                "MacOS",
                "GNU/Linux"
            )
        );
    }
}
