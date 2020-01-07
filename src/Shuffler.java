package src;


/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;

	/**
	 * The number of values to shuffle.
	 */
	private static final int VALUE_COUNT = 52;

	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
//		System.out.println("Results of " + SHUFFLE_COUNT +
//				" consecutive perfect shuffles:");
//		long startTime = System.currentTimeMillis();
//		int[] values1 = new int[VALUE_COUNT];
//		for (int i = 0; i < values1.length; i++) {
//			values1[i] = i;
//		}
//		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
//			perfectShuffle(values1);
//			System.out.print("  " + j + ":");
//			for (int k = 0; k < 100; k++) {
//				System.out.print(" " + values1[k]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//		long endTime = System.currentTimeMillis();
//		System.out.println("Elapsed time: " + (endTime - startTime));
//		System.out.println("Results of " + SHUFFLE_COUNT +
//				" consecutive efficient selection shuffles:");
//		startTime = System.currentTimeMillis();
//		int[] values2 = new int[VALUE_COUNT];
//		for (int i = 0; i < values2.length; i++) {
//			values2[i] = i;
//		}
//		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
//			selectionShuffle(values2);
//			System.out.print("  " + j + ":");
//			for (int k = 0; k < 100; k++) {
//				System.out.print(" " + values2[k]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//		endTime = System.currentTimeMillis();
//		System.out.println("Elapsed time: " + (endTime - startTime));
//		//System.out.println(headstails());
	int[] arr1 = {1, 1, 1, 2};
	int[] arr2 = {2, 1, 1, 1};
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		int shuffled[] = new int[values.length];
		int k=0;
		for(int i = 0; i < shuffled.length/2; i++) {
			shuffled[k] = values[i];
			k += 2;
		}
		k=1;
		for(int i =shuffled.length/2 ; i < shuffled.length; i++) {
			shuffled[k] = values[i];
			k += 2;
		}
		for(int i = 0; i< shuffled.length; i++) {
			values[i] = shuffled[i];
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		for(int k = values.length-1; k >=0; k--) {
			int j = (int) (Math.random() * k);
			int tmp = values[k];
			values[k] = values[j];
			values[j] = tmp;
		}
	}

	public static void quickShuffle(int arr[], int start, int end) {
		if(start < end) {
			int partition = (int) (Math.random()*(end-start) + start);
			int tmp = arr[start];
			arr[start] = arr[partition];
			arr[partition] = tmp;
			if(partition-1 > start && partition-1 > 0) {
				quickShuffle(arr, start, partition-1);
			}
			if(partition+1 < end && partition+1 < arr.length-1) {
				quickShuffle(arr, partition+1, end);
			}
		}

	}

	//questions
	public static String headstails() {
		int num = (int) (Math.random()*3);
		System.out.println(num);
		if(num == 0) {
			return("tails");
		}else {
			return "heads";
		}
	}
	
	
	public static boolean arePremunitions(int arr1[], int arr2[]) {
		int i = 0;
		boolean isfound = false;
		while(i < arr1.length) {
			for(int k = 0; k < arr2.length; k++) {
				if(arr1[i] == arr2[k]) {
					i++;
					isfound = true;
				}
			}
		}
		return true;
	}
	




}
