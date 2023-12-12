import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;

import static org.example.project.UnitTesting.ParameterizationTesting.PersonOfParameterizationTesting;
import static org.example.project.UnitTesting.ParameterizationTesting.capitalize;
import static org.junit.Assert.assertEquals;

/**
 * @参数化测试
 */
public class PersonOfParameterizationTestingTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testAbs(int x) {
        assertEquals(x, PersonOfParameterizationTesting(x));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void test1Abs(int x) {
        assertEquals(-x, PersonOfParameterizationTesting(x));
    }

    @ParameterizedTest
    @MethodSource
    void test2String(String input,String result){
        assertEquals(result,capitalize(input));
    }

    static List<Arguments> test2String() {
        return List.of( // arguments:
                Arguments.of("abc", "Abc"), //
                Arguments.of("APPLE", "Apple"), //
                Arguments.of("gooD", "Good"));
    }

    @ParameterizedTest
    @CsvSource({"abc,Abc","APPLE,Apple","gooD,Good"})
    // @CsvFileSource(resources = {"/test-...."})
    /*
    其中内容
    apple, Apple
    HELLO, Hello
    JUnit, Junit
    reSource, Resource
     */
    void test3String(String input,String result){
        assertEquals(result,capitalize(input));
    }

    @ParameterizedTest
    // JUnit只在classpath中查找指定的CSV文件，因此，test-capitalize.csv这个文件要放到test目录下，内容如下：
    @CsvFileSource(resources = {"/test-capitalize.csv"})
    void test4String(String input,String result){
        assertEquals(result,capitalize(input));
    }
}
