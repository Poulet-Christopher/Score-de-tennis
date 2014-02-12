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
        String score = jeu.score_point();
        assertThat(score).isEqualTo("0-0");

    }

    @Test
    public void GainJoueur1(){
        Jeu jeu = new Jeu();
        assertThat(jeu.JoueurGagne("j1",1)).isEqualTo("15-0");
        assertThat(jeu.JoueurGagne("j2",1)).isEqualTo("15-15");
        assertThat(jeu.JoueurGagne("j2",2)).isEqualTo("15-30");
        assertThat(jeu.JoueurGagne("j2",3)).isEqualTo("15-40");
        //assertThat(jeu.JoueurGagne("j1",2)).isEqualTo("30-0");
        //assertThat(jeu.JoueurGagne("j1",2)).isEqualTo("30-15");
        //assertThat(jeu.JoueurGagne("j1",2)).isEqualTo("30-30");
        assertThat(jeu.JoueurGagne("j1",2)).isEqualTo("30-40");
        //assertThat(jeu.JoueurGagne("j1",3)).isEqualTo("40-0");
        //assertThat(jeu.JoueurGagne("j1",3)).isEqualTo("40-15");
        //assertThat(jeu.JoueurGagne("j1",3)).isEqualTo("40-30");
        assertThat(jeu.JoueurGagne("j1",3)).isEqualTo("40-40");
    }

    @Test
    public void GainJoueur2(){
        Jeu jeu = new Jeu();
        assertThat(jeu.JoueurGagne("j2",1)).isEqualTo("0-15");
        assertThat(jeu.JoueurGagne("j2",2)).isEqualTo("0-30");
        assertThat(jeu.JoueurGagne("j2",3)).isEqualTo("0-40");
    }

    @Test
    public void AvantageJ1(){
        Jeu jeu = new Jeu();
        jeu.JoueurGagne("j1",3);
        jeu.JoueurGagne("j2",3);
        assertThat(jeu.JoueurGagne("j1",4)).isEqualTo("Av-40");

        //retour a 40-40
        assertThat(jeu.JoueurGagne("j2",4)).isEqualTo("40-40");
    }

    @Test
    public void AvantageJ2(){
        Jeu jeu = new Jeu();
        jeu.JoueurGagne("j1",3);
        jeu.JoueurGagne("j2",3);
        assertThat(jeu.JoueurGagne("j2",4)).isEqualTo("40-Av");

        //retour a 40-40
        assertThat(jeu.JoueurGagne("j1",4)).isEqualTo("40-40");
    }

    @Test
    public void JeuJ1(){
        Jeu jeu = new Jeu();
        assertThat(jeu.JoueurGagne("j1",4)).isEqualTo("jeuj1");
        //RAZ du score
        assertThat(jeu.score_point()).isEqualTo("0-0");
        assertThat(jeu.gainJeu("j1",1)).isEqualTo("1/0");
    }

}
