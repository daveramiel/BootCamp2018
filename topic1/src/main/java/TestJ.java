import org.testng.annotations.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJ {

    @org.testng.annotations.Test
    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine", str);
    }
}
