package com.ankit.data.structures.queue;

/**
 * Generate Binary numbers for numbers - 1 to given number 'n' using a Queue.
 * 
 * @author ankit
 *
 */
public class FindBinChallenge {
	/**
	 * 
	 * Time Complexity : O(n) as the queue is iterated once;
	 * 
	 * 1.Start with Enqueuing 1.
	 * 
	 * 2.Dequeue a number from queue and append 0 to it and enqueue it back to
	 * queue.
	 * 
	 * 3.Perform step 2 but with appending 1 to the original number and enqueue back
	 * to queue.
	 * 
	 * Size of Queue should be 1 more than number because for a single number we're
	 * enqueuing two.
	 * 
	 * @param number
	 * @return
	 */
	public static String[] findBin(int number) {
		String[] result = new String[number];
		Queue<String> queue = new Queue<String>(number + 1);

		queue.enqueue("1");

		for (int i = 0; i < number; i++) {
			result[i] = queue.dequeue();
			queue.enqueue(result[i] + "0");
			queue.enqueue(result[i] + "1");
		}
		return result;
	}

	public static void main(String args[]) {

		String[] output = findBin(3);
		for (int i = 0; i < 3; i++)
			System.out.print(output[i] + " ");
	}
}
