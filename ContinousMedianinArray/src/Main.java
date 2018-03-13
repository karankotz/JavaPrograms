import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


        public class Main {

            public static double[] getMedian(int[] array )
            {

                //Min Heap for storing the upper half of the elements
                PriorityQueue<Integer> higher = new PriorityQueue<Integer>();
                //Max heap for storing the lower half of the elements
                PriorityQueue<Integer> lower = new PriorityQueue<Integer>(new Comparator<Integer>() {
                    
                    public int compare(Integer o1, Integer o2) {
                        return -1 * o1.compareTo(o2);
                    }
                });
                    double[] medians = new double[array.length];
                    for(int i=0; i< array.length; i++)
                    {
                        int number = array[i];
                        //Add the number respectively into the heap, it may be added in the higher or the lower
                        addNumber(number, higher, lower);
                        //Re-balance both the heaps
                        rebalance(lower, higher);
                        //Get the median of the array
                        medians[i] = getmedian(lower, higher);

                    }
                    return medians;

            }
            //Re-balance method that will be able to rebalance the lower and the higher halfs in order to keep them in the
            //appropriate proportion
            public static void rebalance(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher)
            {
                //Logic to find the bigger and the smallerheap of the two heaps that have been declared
                PriorityQueue<Integer> biggerheap = higher.size() > lower.size() ? higher:lower;
                PriorityQueue<Integer> smallerheap = higher.size() > lower.size() ? lower:higher;
                //remove one of the elements from the biggerheap and add it to the smallerheap
                if((biggerheap.size() - smallerheap.size()) >= 2)
                {
                        smallerheap.add(biggerheap.poll());
                }
            }

            //Method to add the number into the heap
            private static void addNumber(int number, PriorityQueue<Integer> higher, PriorityQueue<Integer> lower)
            {
                //lower.peek() returns the head element of the queue
                if(lower.size() == 0 || number < lower.peek())
                {
                    lower.add(number);
                }

                else
                {
                    higher.add(number);
                }

            }

            public static double getmedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher)
            {
                PriorityQueue<Integer> biggerheap = higher.size() > lower.size() ? higher:lower;
                PriorityQueue<Integer> smallerheap = higher.size() > lower.size() ? lower:higher;

                if(biggerheap.size() == smallerheap.size())
                {
                   return ((double)(biggerheap.peek() + smallerheap.peek())/2);
                }
                else
                {
                    return biggerheap.peek();
                }

            }

            public static void main(String[] args)

            {
                int[] test = {12,4,5,3,8,7};
               double test1[] =  getMedian(test);
               System.out.println(Arrays.toString(test1));
            }
    }
