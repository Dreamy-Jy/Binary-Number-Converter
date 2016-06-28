import java.util.Scanner;

class BinaryConverter{
  
  
  
  //method 1
  public static int[] convertToBinary(int b){
    int [] binyNum = new int [8];
    int testBy = 128;
    
    for (int i = 0; i <= 7; i++){
      if (b >= testBy){
        b -= testBy;
        binyNum[i] = 1;
      }else{
        binyNum[i] = 0;
      }
      testBy /= 2;
    }
    
    return binyNum;   
  }
  
  
  
  //method 2
  public static void printBin(int [] b){
    if (b.length == 9){
      if (b[0] == 1){System.out.println("Error: overflow");}
      for (int i = 1;i < 9; i++){
        System.out.print(b[i] + " ");
      }
    }else{
      for (int i = 0;i < 8; i++){
        System.out.print(b[i] + " ");
      }
    }
    System.out.println("\n");
  }
  
  
  
  //method 3
  public static int [] addBin(int [] a , int [] b) {
    int [] sumBin = new int[9];
    int sum = 0;
    int chck = 128;
    
    for (int i = 0; i < a.length; i++){
      if (a[i] == 1){sum += chck;}
      chck /= 2;
    }  
    chck = 128;
    for (int i = 0; i < b.length; i++){
      if (b[i] == 1){sum += chck;}
      chck /= 2;
    }
    chck = 256;
    for (int i = 0; i <= 8; i++){
      if (sum >= chck){
        sum -= chck;
        sumBin[i] = 1;
      }else{
        sumBin[i] = 0;
      }
      chck /= 2;
    }
    
    return sumBin;
  }
  
    
  
  public static void main(String[] args){
    int num1 = 0;
    int num2 = 0;
    int [] base21 = new int [8];
    int [] base22 = new int [8];
    int [] added = new int [9];
    Scanner scan = new Scanner(System.in);
    
    System.out.println("This a Binary convert enter 2 Binary number and this program shows you them as binary numbers and shows you their binary sum");

    System.out.println("Enter a base ten number between 0 and 255, inclusive.");
    num1 = scan.nextInt();
    base21 = convertToBinary(num1);
    
    System.out.println("Enter a base ten number between 0 and 255, inclusive.");
    num2 = scan.nextInt();
    base22 = convertToBinary(num2);
    
  
    System.out.println("\nFirst binary number:");
    printBin(base21);
    System.out.println("Second binary number:");
    printBin(base22);
    
    System.out.println("Added:");
    added = addBin(base21, base22);
    printBin(added);
  
  }
}