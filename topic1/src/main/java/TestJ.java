import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJ {

    @Test
    public void test() {
        String str = "It is working!";
        assertEquals("It is working!", str);
    }
}
