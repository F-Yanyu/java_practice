import org.example.project.UnitTesting.ExceptionTesting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactExceptionTest {
    @Test
    public void testNegative() {
        assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                ExceptionTesting.fact(-1);
            }
        });
    }

    // 以上代码可以简写为
    /*
    @Test
    void testNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.fact(-1);
        });
    }
     */
}
