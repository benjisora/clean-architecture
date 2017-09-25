package amiltone.bsaugues.td_niveau1;

import org.junit.Test;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;

import static org.assertj.core.api.Assertions.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

        ComicEntity comicEntity = new ComicEntity();
        comicEntity.setTitle("test");

        assertThat(comicEntity.getTitle()).isEqualTo("test");
    }
}