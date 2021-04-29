package ua.com.foxminded;

import java.util.List;
import java.util.ArrayList;

public class IntegerDivision {


   public List<Integer> numbersLongDivision(int dividendNumber, int divisor) throws IllegalArgumentException{

       if(dividendNumber == 0 || divisor == 0){
           throw new IllegalArgumentException("Input parameters contain 0");
       }

       Integer result = dividendNumber / divisor; //Result of division needs to calculate mid-flight results

       List<Integer> dividendNumberList = numbersToList(dividendNumber);
       List<Integer> resultNumberList = numbersToList(result);

       List<Integer> resultList = new ArrayList<>();

       if(dividendNumber < divisor){
           throw new IllegalArgumentException("Dividend is less than divisor");
       }

       if(divisor == 1){
           resultList.add(dividendNumber);
           return resultList;
       }

       //Concatenate numbers if first grade less than divisor to prepare for the first iteration of division
       for (int i = 0; i < dividendNumberList.size();) {
           if(dividendNumberList.get(0) < divisor){
               dividendNumberList.set(0, Integer.parseInt(Integer.toString(dividendNumberList.get(0)) + Integer.toString(dividendNumberList.get(i+1))));
               dividendNumberList.remove(i + 1);
           } else{
               break;
           }
       }

       int gradeDividendNumber = dividendNumberList.get(0); // The first grade of dividend
       int largestWholeNumber = 0;
       int reminder = 0;

       System.out.println(dividendNumber);

       for(int i = 0; i < dividendNumberList.size(); i++){

           largestWholeNumber = resultNumberList.get(i) * divisor;
           reminder = gradeDividendNumber - largestWholeNumber;

           if(i < dividendNumberList.size() - 1) {
               gradeDividendNumber = concatenateNumbers(reminder, dividendNumberList.get(i + 1));
           } else{
               gradeDividendNumber = reminder;
           }

           System.out.println(largestWholeNumber);
           System.out.println(gradeDividendNumber);

           resultList.add(largestWholeNumber);
           resultList.add(gradeDividendNumber);

       }

       return resultList;
   }

   protected int concatenateNumbers(int remainder, int nextInt){

        int catNum = Integer.parseInt(Integer.toString(remainder) + Integer.toString(nextInt));

        return catNum;
    }

     protected  List numbersToList(int number){

        String tempNumberString = Integer.toString(number);
        char[] tempNumberCharArray = new char[tempNumberString.length()];
        tempNumberCharArray = tempNumberString.toCharArray();
        List<Integer> numberList = new ArrayList<Integer>(tempNumberCharArray.length);

        for ( char numberAsChar : tempNumberCharArray) {
            numberList.add(Integer.parseInt(String.valueOf(numberAsChar)));
        }

        return numberList;
    }

}
