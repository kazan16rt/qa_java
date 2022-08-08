import com.example.Feline;
import com.example.Lion;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class LionTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Parameters({
            "Самец, true",
            "Самка, false"
    })
    public void lionConstructorClassSetCorrectHasMane(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(sex, new Feline());

        boolean actual = lion.doesHaveMane();

        assertEquals("Boolean hasMan have incorrect value", expected, actual);
    }

    @Test
    public void lionConstructorClassExceptionCheck() {
        String actual = "Exception is gone";
        try {
            Lion lion = new Lion("Другой", new Feline());
        } catch (Exception thrown) {
            actual = thrown.getMessage();
        }
        assertEquals("Exception is not returns or not equals expected","Используйте допустимые значения пола животного - самец или самка", actual);
    }

    @Mock
    Feline feline = new Feline();
    @Test
    public void getKittensReturnsCorrectNumbersOfKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expected = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);

        int actual = lion.getKittens();

        assertEquals("Expected number of kittens is not equals expected", expected, actual);
    }

    @Spy
    Feline felinePredator = new Feline();
    @Test
    public void getFoodReturnsPredatorsFood() throws Exception {
        Lion lion = new Lion("Самка", felinePredator);
        Mockito.when(felinePredator.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        List<String> actual = lion.getFood();

        assertEquals("Returns food is not for predators", expected, actual);
    }

}


