import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.bolotdug.task2.reader.IpFileReader;
import ru.bolotdug.task2.register.IpRegistrer;

public class IpCounterTest {

  @Test
  public void testResult() {
    IpFileReader reader = new IpFileReader();
    reader.readFile("src/test/resources/testFile");
    Assertions.assertEquals(13L, IpRegistrer.counter);
  }
}
