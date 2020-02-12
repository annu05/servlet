import com.parse.Parser;
import org.junit.Test;
import java.io.File;


import static org.junit.Assert.*;


public class UnitTest {


    @Test
    public void testjson(){


        File file = new File("src/test/resources/test.json");
        Parser parser = new Parser();
        String b = parser.par(file);
        assertEquals("https://vpp.itunes.apple.com/mdm/getVPPAssetsSrv",b);

    }
}
