/**
 * 
 */
package FCFS_algorithm;

import java.util.Comparator;

/**
 * @author Saif_sust_2013331007
 *
 */
public class Comp implements Comparator<inputPair> {

	@Override
	public int compare(inputPair first, inputPair second) {
		return (int) (first.getArivalTime() - second.getArivalTime());
	}

}
