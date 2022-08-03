import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Test
    public void getSoundReturnsCorrectSound() {
        Cat cat = new Cat(new Feline());
        String expected = "Мяу";

        String actual = cat.getSound();

        assertEquals("Resault is not 'Мяу'", expected, actual);
    }

    @Mock
    private Feline feline;

    @Test
    public void getFoodReturnsPredatorsFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> actual = cat.getFood();

        assertEquals("Returns incorrect food", expected, actual);
    }

}
