import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import models.Jeu;

/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Your new application is ready.");
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("Your new application is ready.");
    }

    @Test
    public void ScoreDebutDePartie() {
        Jeu jeu = new Jeu();
        String score = jeu.score();
        assertThat(score).isEqualTo("0-0");

    }

    @Test
    public void GainJoueur1(){
        Jeu jeu = new Jeu();
        assertThat(jeu.JoueurGagne("j1",1)).isEqualTo("15-0");
        assertThat(jeu.JoueurGagne("j1",2)).isEqualTo("30-0");
        assertThat(jeu.JoueurGagne("j1",3)).isEqualTo("40-0");
    }

}
