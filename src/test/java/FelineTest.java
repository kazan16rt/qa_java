import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Spy
    Feline feline = new Feline();
    @Test
    public void eatMeatReturnsPredatorsFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> actual = feline.eatMeat();

        assertEquals("Returns incorrect value", expected, actual);
    }

    @Test
    public void getFamilyReturnsCorrectValue() {
        Feline feline = new Feline();
        String expected = "Кошачьи";

        String actual = feline.getFamily();

        assertEquals("Returns incorrect value", expected, actual);
    }
}
