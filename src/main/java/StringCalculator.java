import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class StringCalculator {

  public int cal (String text){

    if(text == null || text.isEmpty()) return 0;

    Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

    if(matcher.find()){
      String customDelimeter = matcher.group(1);
      String[] tokens = matcher.group(2).split(customDelimeter);
      return add(tokens);
    }

    String[] numbers = text.split(",|:");

    return add(numbers);

  }

  private int add(String[] numbers){
    int result = 0;
    for(String num : numbers){
      result+=toPositive(num);
    }
    if(result<0){
      throw new RuntimeException();
    }
    return result;
  }

  private int toPositive(String num){
    int number = Integer.parseInt(num);
    if(number<0){
      throw new RuntimeException();
    }
    return number;
  }
}
