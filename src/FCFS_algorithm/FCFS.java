/**
 * 
 */
package FCFS_algorithm;

import java.util.*;

import FileInputer.fileFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.*;
import java.io.*;

/**
 * @author Saif_sust_2013331007
 *
 */
public class FCFS {

	/**
	 * @param args
	 */

	private static double CT[] = new double[2000];
	private static double TAT;
	private static double WT;

	public ObservableList<outputPair> FCFS_Algo(List<inputPair> inList) {
		out_list = FXCollections.observableArrayList();
		in_list = new ArrayList<inputPair>();
		out_list.clear();
		in_list.clear();
		Collections.sort(inList, new Comp());
		for (int i = 0; i < CT.length; i++) {
			CT[i] = 0.0;
		}
		/*
		 * Complication Time Calculation
		 */
		CT[0] = 0.0;
		for (int i = 1; i <= inList.size(); i++) {
			if (inList.get(i - 1).getArivalTime() > CT[i - 1]) {
				CT[i] = inList.get(i - 1).getArivalTime() + inList.get(i - 1).getBurstTime();
				TAT = CT[i] - inList.get(i - 1).getArivalTime();
				WT = TAT - inList.get(i - 1).getBurstTime();
				out_list.add(new outputPair(inList.get(i - 1).getProcess(), inList.get(i - 1).getArivalTime(),
						inList.get(i - 1).getBurstTime(), CT[i], TAT, WT));

			} else {
				CT[i] = CT[i - 1] + inList.get(i - 1).getBurstTime();
				TAT = CT[i] - inList.get(i - 1).getArivalTime();
				WT = TAT - inList.get(i - 1).getBurstTime();
				out_list.add(new outputPair(inList.get(i - 1).getProcess(), inList.get(i - 1).getArivalTime(),
						inList.get(i - 1).getBurstTime(), CT[i], TAT, WT));
			}
		}

		return out_list;
	}

	public static void main(String[] args) {

		in_list = new ArrayList<inputPair>();
		int num = scanner.nextInt();
		String str;
		double at, bt;
		for (int i = 0; i < num; i++) {
			str = scanner.next();
			at = scanner.nextDouble();
			bt = scanner.nextDouble();
			in_list.add(new inputPair(str, at, bt));

		}

		out_list = new FCFS().FCFS_Algo(in_list);
		for (int i = 0; i <= num; i++) {
			System.out.print(CT[i] + " ");
		}
		System.out.println();
		System.out.println("=====================");
		for (int i = 0; i < out_list.size(); i++) {
			System.out.println(out_list.get(i));
		}

	}

	private static ObservableList<outputPair> out_list;
	private static List<inputPair> in_list;
	private static Scanner scanner = fileFactory.scanner();
}
