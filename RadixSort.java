import java.util.Scanner;
public class RadixSort {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in); //create scanner
        Queue<Integer> myQueue; //create queue
        boolean stop = false; //create stop loop break condition

        do { //loop until broken
            System.out.print("\n\n\nHow many inputs are there: "); //get input number
            int maxInputs = myScanner.nextInt();
            int[] inputs = new int[maxInputs]; //create input array

            for (int a = 0; a < maxInputs; a++) { //get all inputs
                System.out.print("\nEnter input " + (a + 1) + ": ");
                inputs[a] = myScanner.nextInt(); //add each input to array
            }

            System.out.print("Inputs: ");
            for (int a = 0; a < maxInputs; a++) { //display inputs
                if (a == 0) System.out.print(inputs[a]);
                else System.out.print(", " + inputs[a]);
            }


            //begin Radix sort
            System.out.println("\n\nRunning Radix Sort, please wait...");

            //Step 1: find the highest digit count
            int mostDigits = 0; // find the highest amount of digits in the array
            for (int a = 0; a < maxInputs; a++) {
                int aDigits = CountDigits(inputs[a]);
                if (aDigits > mostDigits) mostDigits = aDigits;
            }
            System.out.println("Highest digit count: " + mostDigits);


            Queue<Integer> bucket0 = new Queue<>(); //create buckets
            Queue<Integer> bucket1 = new Queue<>();
            Queue<Integer> bucket2 = new Queue<>();
            Queue<Integer> bucket3 = new Queue<>();
            Queue<Integer> bucket4 = new Queue<>();
            Queue<Integer> bucket5 = new Queue<>();
            Queue<Integer> bucket6 = new Queue<>();
            Queue<Integer> bucket7 = new Queue<>();
            Queue<Integer> bucket8 = new Queue<>();
            Queue<Integer> bucket9 = new Queue<>();


            //Step 2: foreach digit
            for (int b = 0; b < mostDigits; b++) {
                myQueue = new Queue<>(); //create empty queue
                for (int a = 0; a < maxInputs; a++) { //populate queue
                    myQueue.Enqueue(inputs[a]);
                }
                System.out.println("Queue before digit " + b + ": " + myQueue.PrintList(myQueue.head));

                //Step 3: sort queue into buckets
                for (int c = 0; c < maxInputs; c++){
                    int temp = myQueue.Dequeue();
                    switch (ExtractDigit(temp, b)){
                        case 0:
                            bucket0.Enqueue(temp);
                            break;
                        case 1:
                            bucket1.Enqueue(temp);
                            break;
                        case 2:
                            bucket2.Enqueue(temp);
                            break;
                        case 3:
                            bucket3.Enqueue(temp);
                            break;
                        case 4:
                            bucket4.Enqueue(temp);
                            break;
                        case 5:
                            bucket5.Enqueue(temp);
                            break;
                        case 6:
                            bucket6.Enqueue(temp);
                            break;
                        case 7:
                            bucket7.Enqueue(temp);
                            break;
                        case 8:
                            bucket8.Enqueue(temp);
                            break;
                        case 9:
                            bucket9.Enqueue(temp);
                            break;
                    }
                }

                //Step 4: dump buckets
                for (int a = 0; a < maxInputs; a++){
                    if (!bucket0.IsEmpty()) inputs[a] = bucket0.Dequeue();
                    else if (!bucket1.IsEmpty()) inputs[a] = bucket1.Dequeue();
                    else if (!bucket2.IsEmpty()) inputs[a] = bucket2.Dequeue();
                    else if (!bucket3.IsEmpty()) inputs[a] = bucket3.Dequeue();
                    else if (!bucket4.IsEmpty()) inputs[a] = bucket4.Dequeue();
                    else if (!bucket5.IsEmpty()) inputs[a] = bucket5.Dequeue();
                    else if (!bucket6.IsEmpty()) inputs[a] = bucket6.Dequeue();
                    else if (!bucket7.IsEmpty()) inputs[a] = bucket7.Dequeue();
                    else if (!bucket8.IsEmpty()) inputs[a] = bucket8.Dequeue();
                    else if (!bucket9.IsEmpty()) inputs[a] = bucket9.Dequeue();
                }
            }

            System.out.print("Sorting finished...\nSorted array: ");
            for (int a = 0; a < maxInputs; a++){
                System.out.print(inputs[a] + " ");
            }

            myScanner = new Scanner(System.in); //clear scanner
            System.out.print("\n\nWould you like to rerun program? (Y/N): "); //ask to repeat
            String quitResponse = myScanner.nextLine(); //read input
            System.out.println("*" + quitResponse + "*");
            if (quitResponse.charAt(0) == 'y' || quitResponse.charAt(0) == 'Y'){ //if yes, dont loop
                stop = false;
                System.out.println("Rerunning...\n");
            }
            else { //otherwise break loop
                System.out.println("Stopping program...");
                stop = true;
            }

        } while (!stop);
    }

    static private int ExtractDigit(int input, int index) { //returns digit at given index

        int digit = 0; //declare return value
        int tempIndex = 0; //declare temp index for reference
        int tempNum = input; //declare temp input for reference
        boolean stop = false; //declare break condition
        while (!stop) { //loop on !stop
            if (tempIndex == index) {
                digit = tempNum % 10; //if at right index, set digit and break loop
                stop = true;
            }
            else { //otherwise increase index and move tempnum to tempindex
                tempIndex++;
                tempNum = tempNum / 10;
            }
        }
        return digit; //return the counted digit
    }

    static private int CountDigits(int input){
        int count = 0; //initialize count
        int temp = 1; //initialize temp number for reference

        while (temp <= input){ //while input is bigger than temp number
            count++; //increase count
            temp *= 10; //multiply temp by 10 to add a digit
        }
        return count;
    }
}
