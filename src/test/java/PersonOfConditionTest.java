import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import static org.example.project.UnitTesting.ConditionTesting.personOfConditionTest;
import static org.junit.Assert.assertEquals;

public class PersonOfConditionTest {
    @Disabled
    @Test
    public void ConditionTest(){
        assertEquals(100,personOfConditionTest(true));
    }

    @Test
    public void ConditionTest2(){
        assertEquals(100,personOfConditionTest(true));
    }
}
