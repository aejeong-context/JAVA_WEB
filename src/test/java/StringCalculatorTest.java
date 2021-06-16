import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setUp(){
        stringCalculator = new StringCalculator();
    }


    @Test
    @DisplayName(value="빈문자열 계산하는 메서드")
    void 빈문자열_계산(){
        assertEquals(0,stringCalculator.cal(""));
        assertEquals(0,stringCalculator.cal(null));
    }

    @Test
    @DisplayName(value ="구분자를 포함한 문자열을 계산하는 메서드")
    void 구분자_계산(){
        String number = "1:2:3,4";
        String number2 = "1,2,3:4";
        assertEquals(10,stringCalculator.cal(number));
        assertEquals(10,stringCalculator.cal(number2));
    }

    @Test
    @DisplayName(value = "커스텀 구분자를 이용해 문자열을 계산하는 메서드")
    void 커스텀_계산(){
        String customNumber = "//%\n1%2%3%";
        assertEquals(6,stringCalculator.cal(customNumber));
    }

    @Test
    @DisplayName(value = "음수일 때 에러")
    void 음수_계산(){
        String negative ="-1:-1:-1";
        assertThrows(RuntimeException.class,()->stringCalculator.cal(negative));
    }




}