package Bootcamp.Arrays;

public class DutchNationalFlag {

    static void sortArray(char arr[]){
        int red=0;
        int blue=arr.length-1;

        for(int i=0; i<=blue; i++){
            if(red < blue){
                if(arr[i] == 'r'){
                    char tmp = arr[i];
                    arr[i] = arr[red];
                    arr[red] = tmp;
                    red++;
                }
                else if(arr[i] == 'b'){
                    char tmp = arr[i];
                    arr[i] = arr[blue];
                    arr[blue] = tmp;
                    blue--;
                    i--;
                }
            }
        }
    }


    public static void main(String args[]){
        char arr[] = {'g','b','r','r','b','g','b','r'};

        sortArray(arr);
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] +" ");
    }

}
