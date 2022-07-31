package D25;

/**
 * @author zjy
 * @version 1.0
 */

public class I2 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] anal = new int[1001];
        for(int numb : arr1){
            anal[numb]++;
        }
        int index = 0;
        for(int numb : arr2){
            for(int i = 0; i < anal[numb]; i++){
                arr1[index++] = numb;
            }
            anal[numb] = 0;
        }
        for(int i = 0; i < anal.length; i++){
            for(int j = 0; j < anal[i]; j++){
                arr1[index++] = i;
            }
        }
        return arr1;
    }
}
