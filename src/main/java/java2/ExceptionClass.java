package java2;

public class ExceptionClass{

    public static class MyArraySizeException extends RuntimeException{
        MyArraySizeException(String s){
            super(s);
        }}
    public static class MyArrayDataException extends RuntimeException{
        MyArrayDataException(String s){
            super(s);
        }
}
    public static void checkArray(String arr[][], int num1, int num2){
        if (num1 != 4 || num2 != 4){
            throw new MyArraySizeException("MyArraySizeException");
        }
    }
    public static int checkArrayData(String arr[][], int num1, int num2){
        Integer sum = 0;
        int m = 0, n = 0;
        try{
            for(int i = 0;i < arr.length;i++){
                for(int j = 0;j < arr[i].length;j++){
                    m = i; n = j;
                    sum += Integer.parseInt(arr[i][j]);
                    System.out.println(" = " + arr[i][j]);
                }
            }
        }
        catch (NumberFormatException e){
            String s = "MyArrayDataException по индексам [" + m + "][" + n +"]";
            throw new MyArrayDataException(s);
        }
        finally {
            return sum;
        }

    }
}