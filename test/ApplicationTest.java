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

import models.Joueur1;
import models.Joueur2;

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

    void assert_pointj1(int point,int score){
        assertThat(new Joueur1(point).point()).isEqualTo(score);
    }

    void assert_pointj2(int point,int score){
        assertThat(new Joueur2(point).point()).isEqualTo(score);
    }

    @Test
    public void point_jeu(){
        assert_pointj1(1,15);
        assert_pointj1(2,30);
        assert_pointj1(3,40);
        assert_pointj2(1,15);
        assert_pointj2(2,30);
        assert_pointj2(3,40);
    }

}
