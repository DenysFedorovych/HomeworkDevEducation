import com.github.firsthomework.ToNumberConvert;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToNumberConvertTest {

    @Test
    public void convertTest(){
        ToNumberConvert example = new ToNumberConvert();
        Assert.assertEquals(150,example.convert("Сто пятьдесят"));
        Assert.assertEquals(327,example.convert("Триста двадцать семь"));
    }


}