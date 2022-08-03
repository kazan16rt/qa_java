import com.example.Feline;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
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

    @Test
    @Parameters({
            "0, 0",
            "1, 1",
            "10, 10"
    })
    public void getKittensReturnsNumberOfKitten(int input, int expected) {
        Mockito.when(feline.getKittens(Mockito.anyInt())).thenReturn(input);

        int actual = feline.getKittens();

        assertEquals("Number of kittens is wrong", expected, actual);
    }

    @Test
    @Parameters({
            "0, 0",
            "1, 1",
            "10, 10"
    })
    public void getKittensReturnsCurrentNumberOfKittens(int input, int expected) {
        Feline feline = new Feline();

        int actual = feline.getKittens(input);

        assertEquals("Number of kittens is wrong", expected, actual);
    }
}
