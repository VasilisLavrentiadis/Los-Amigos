/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package losamigos;

/**
 *
 * @author vasilislavrentiadis
 */
public class LosAmigos {
    
    //Question 1
    
    private static void printQuestion(int questionNumber){
        System.out.println("\n---------------------- Question " + questionNumber + " ----------------------");
    }
    
    private static void printPlayer(String[] names, int[] ages, int[] points, int index, int start){
        switch (start) {
            case 0:
                System.out.println("Name: " + names[index] + ", Age: " + ages[index] + ", Points: " + points[index]);
                break;
            case 1:
                System.out.println("Age: " + ages[index] + ", Name: " + names[index] + ", Points: " + points[index]);
                break;
            case 2:
                System.out.println("Points: " + points[index] + ", Name: " + names[index] + ", Age: " + ages[index]);
                break;
            default:
                break;
        }
    }
    
    private static int max(int[] array){
        int indexMax = 0;
        for (int i = 0 ; i < array.length ; i++){
            if (array[i] > array[indexMax]){
                indexMax = i;
            }
        }
        
        return indexMax;
    }
    
    
    //Question 2
    
    private static int min(int[] array){
        int indexMin = 0;
        for (int i = 0 ; i < array.length ; i++){
            if (array[i] < array[indexMin]){
                indexMin = i;
            }
        }
        
        return indexMin;
    }
    
    
    //Question 3
    
    private static int pointRange(int[] points){
        int indexMinimum = min(points);
        int indexMaximum = max(points);
      
        return (points[indexMaximum] - points[indexMinimum]);
        
    }
    
    
    //Question 4
    
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static void swap(String[] arr, int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(String[] arr1, int i, String[] arr2, int j){
        String temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
    
    private static void swap(int[] arr1, int i, int[] arr2, int j){
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
    
    private static void bubbleSortDescending(String[] names, int[] ages, int[] points){
        int l = names.length;
        
        for (int i = l - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (ages[j] < ages[j + 1]){
                    swap(ages, j, j + 1);
                    swap(names, j, j + 1);
                    swap(points, j, j + 1);
                }
            }
        }
    }
    
    //Question 5

    private static float average(int[] array){
        float sum = 0;
        
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        
        float average = sum / array.length;
        return average;
        
    }
    
    private static void swapWorstPlayer(String[] names, int[] ages, int[] points, String[] NAMES_RESERVES, int[] AGE_RESERVES, int[] POINTS_RESERVES){
        int indexLowestStart = min(points);
        int indexHighestReserve = max(POINTS_RESERVES);
        
        swap(names, indexLowestStart, NAMES_RESERVES, indexHighestReserve);
        swap(ages, indexLowestStart, AGE_RESERVES, indexHighestReserve);
        swap(points, indexLowestStart, POINTS_RESERVES, indexHighestReserve);
    }
    
    private static void swapOlderPlayers(String[] names, int[] ages, int[] points, String[] NAMES_RESERVES, int[] AGE_RESERVES, int[] POINTS_RESERVES){
        
        float averageAge = average(ages);
        
        for (int i = 0; i < names.length; i++){
            if (ages[i] > averageAge){
                int indexBestReserve = findBestYoungerReserve(AGE_RESERVES, POINTS_RESERVES, averageAge);
                
                if (indexBestReserve != -1){
                    System.out.println("Replacing " + names[i] + " with " + NAMES_RESERVES[indexBestReserve]);
                    swap(names, i, NAMES_RESERVES, indexBestReserve);
                    swap(ages, i, AGE_RESERVES, indexBestReserve);
                    swap(points, i, POINTS_RESERVES, indexBestReserve);
                }
                
            }
        }
    }
    
    private static int findBestYoungerReserve(int[] AGE_RESERVES, int[] POINTS_RESERVES, float averageAge){
        int bestIndex = -1;
        for (int i = 0; i < POINTS_RESERVES.length; i++){
            if (AGE_RESERVES[i] < averageAge && (bestIndex == -1 || POINTS_RESERVES[i] > POINTS_RESERVES[bestIndex])){
                bestIndex = i;
            }
        }
        return bestIndex;
    }
        
    private static Object[] unitedSquads(String[] names, int[] ages, int[] points, String[] NAMES_RESERVES, int[] AGES_RESERVES, int[] POINTS_RESERVES){
        int totalLength = names.length + NAMES_RESERVES.length;
        
        String[] NAMES_UNITED = new String[totalLength];
        int[] AGES_UNITED = new int[totalLength];
        int[] POINTS_UNITED = new int[totalLength];
        
        for (int i = 0; i < names.length; i++){
            NAMES_UNITED[i] = names[i];
            AGES_UNITED[i] = ages[i];
            POINTS_UNITED[i] = points[i];
        }
        
        for (int i = 0; i < NAMES_RESERVES.length; i++){
            NAMES_UNITED[names.length + i] = NAMES_RESERVES[i];
            AGES_UNITED[names.length + i] = AGES_RESERVES[i];
            POINTS_UNITED[names.length + i] = POINTS_RESERVES[i];
        }
        
        Object[] unitedSquad = new Object[]{NAMES_UNITED, AGES_UNITED, POINTS_UNITED};

        return unitedSquad;

    }
    
    private static int binarySearch(int[] points, int target){
        int left = 0;
        int right = points.length - 1;
        
        while (left <= right){
            int mid = left + ((right - left) / 2);
            if (points[mid] == target){
                return mid;
            } else if (points[mid] < target){
                left = mid + 1;
            } else if (points[mid] > target){
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    private static void replaceRetiredPlayer(String[] UNITED_NAMES, int[] UNITED_AGES, int[] UNITED_POINTS, int retiringPlayerPoints, String newName, int newAge, int newPoints){
        int retiringPlayerIndex = binarySearch(UNITED_POINTS, retiringPlayerPoints);
        
        if (retiringPlayerIndex != -1){
            System.out.println("Player " + UNITED_NAMES[retiringPlayerIndex] + " found and will be replaced by " + newName);
            
            for (int i = retiringPlayerIndex; i < UNITED_NAMES.length - 1; i++){
                UNITED_NAMES[i] = UNITED_NAMES[i + 1];
                UNITED_AGES[i] = UNITED_AGES[i + 1];
                UNITED_POINTS[i] = UNITED_POINTS[i + 1];
            }
            
            UNITED_NAMES[UNITED_NAMES.length - 1] = newName;
            UNITED_AGES[UNITED_AGES.length - 1] = newAge;
            UNITED_POINTS[UNITED_POINTS.length - 1] = newPoints;
            
            System.out.println("Updated squad after replacing retiring player with " + UNITED_NAMES[UNITED_NAMES.length - 1] + " :");
            
            bubbleSortDescending(UNITED_NAMES, UNITED_AGES, UNITED_POINTS);
            
            for (int i = 0; i < UNITED_NAMES.length; i++){
                printPlayer(UNITED_NAMES, UNITED_AGES, UNITED_POINTS, i, 2);
            }
        } else{
            System.out.println("Player with " + retiringPlayerPoints + " points not found!");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] names = {"BOSS", "BLOCK", "BRAWN", "BRAYNT", "CLORKSAN"};
        int[] ages = {30, 24, 23, 37, 23};
        int[] points = {473, 133, 115, 1161, 1225};
        
        String[] NAMES_RESERVES = {"HEBBIRT", "HEURTAS", "KYLLE", "NENCA", "RENDLA"};
        int[] AGE_RESERVES = {29, 32, 25, 23, 21};
        int[] POINTS_RESERVES = {481, 237, 152, 349, 919};
        
        
        //Question 1
        
        printQuestion(1);
        int indexOldest = max(ages);
        System.out.println("The oldest member is: ");
        printPlayer(names, ages, points, indexOldest, 0);
        
        //Question 2
        
        printQuestion(2);
        int indexYoungest = min(ages);
        System.out.println("The youngest member is: ");
        printPlayer(names, ages, points, indexYoungest, 0);
        
        //Question 3
        
        printQuestion(3);
        System.out.println("The point range between the members is " + pointRange(points));
        
        
        //Question 4
        
        printQuestion(4);
        bubbleSortDescending(names, ages, points);
        System.out.println("Sorted by age in descending order:");
        for(int i = 0; i < names.length; i++){
            printPlayer(names, ages, points, i, 1);
        }
        
       
        //Question 5
        
        printQuestion(5);
        System.out.println("The average age of the team is " + average(ages));
        
        
        //Question 6
        
        printQuestion(6);
        System.out.println("The average points of the team is " + average(points));
        
     
        
        //Question 7
        
        printQuestion(7);
        swapWorstPlayer(names, ages, points, NAMES_RESERVES, AGE_RESERVES, POINTS_RESERVES);
        System.out.println("Players of the new starting squad: ");
        for(int i = 0; i < names.length; i++){
            System.out.println("Name: " + names[i]);
        }
        
        
        //Question 8
        
        printQuestion(8);
        System.out.println("The average points of the new starting squad is " + average(points));
        
        
        //Question 9
        
        printQuestion(9);
        swapOlderPlayers(names, ages, points, NAMES_RESERVES, AGE_RESERVES, POINTS_RESERVES);
        
        
        //Question 10
        
        printQuestion(10);
        Object[] unitedSquad = unitedSquads(names, ages, points, NAMES_RESERVES, AGE_RESERVES, POINTS_RESERVES);
        
        String[] NAMES_UNITED = (String[]) unitedSquad[0];
        int[] AGES_UNITED = (int[]) unitedSquad[1];
        int[] POINTS_UNITED = (int[]) unitedSquad[2];
        
        System.out.println("United Squad (Starting Squad + Reserve Squad):");
        
        for (int i = 0; i < AGES_UNITED.length; i++){
            printPlayer(NAMES_UNITED, AGES_UNITED, POINTS_UNITED, i, 0);
        }
        
        
        //Question 11
        
        printQuestion(11);
        bubbleSortDescending(NAMES_UNITED, POINTS_UNITED, AGES_UNITED);
        System.out.println("Sorted by points in descending order:");
        for(int i = 0; i < NAMES_UNITED.length; i++){
            printPlayer(NAMES_UNITED, AGES_UNITED, POINTS_UNITED, i, 2);
        }
        
        
        //Question 12
        
        printQuestion(12);
        int retiringPlayerPoints = 1161;
        String newcomerName = "BRYANT_JR";
        int newcomerAge = 18;
        int newcomerPoints = 0;
        
        replaceRetiredPlayer(NAMES_UNITED, AGES_UNITED, POINTS_UNITED, retiringPlayerPoints, newcomerName, newcomerAge, newcomerPoints);
        
    }
    
}