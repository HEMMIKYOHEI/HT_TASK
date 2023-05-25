package scrtest;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

    private App s;

    @Before
    public void setUp() throws Exception {
        s = new Score();
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
