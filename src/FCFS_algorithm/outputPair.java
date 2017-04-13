/**
 * 
 */
package FCFS_algorithm;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Saif_sust_2013331007
 *
 */
public class outputPair {

	outputPair(String process, Double arivalTime, Double burstTime, Double complicationTime, Double turnArroundTime,
			Double waitingTime) {
		this.process.setValue(process);
		this.arivalTime.setValue(arivalTime);
		this.burstTime.setValue(burstTime);
		this.complictionTime.setValue(complicationTime);
		this.turnArroundTime.setValue(turnArroundTime);
		this.waitingTime.setValue(waitingTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[process=" + process.getValue() + ", arivalTime=" + arivalTime.getValue() + ", burstTime="
				+ burstTime.getValue() + ", complictionTime=" + complictionTime.getValue() + ", turnArroundTime="
				+ turnArroundTime.getValue() + ", waitingTime=" + waitingTime.getValue() + "]";
	}

	public String getProcess() {
		return process.getValue();
	}

	public void setProcess(String process) {
		this.process.setValue(process);
	}

	public Double getArivalTime() {
		return arivalTime.getValue();
	}

	public void setArivalTime(Double arivalTime) {
		this.arivalTime.setValue(arivalTime);
	}

	public Double getBurstTime() {
		return burstTime.getValue();
	}

	public void setBurstTime(Double burstTime) {
		this.burstTime.setValue(burstTime);
	}

	/**
	 * @return the complictionTime
	 */
	public Double getComplictionTime() {
		return complictionTime.getValue();
	}

	/**
	 * @param complictionTime
	 *            the complictionTime to set
	 */
	public void setComplictionTime(Double complictionTime) {
		this.complictionTime.setValue(complictionTime);
	}

	/**
	 * @return the turnArroundTime
	 */
	public Double getTurnArroundTime() {
		return turnArroundTime.getValue();
	}

	/**
	 * @param turnArroundTime
	 *            the turnArroundTime to set
	 */
	public void setTurnArroundTime(Double turnArroundTime) {
		this.turnArroundTime.setValue(turnArroundTime);
	}

	/**
	 * @return the waitingTime
	 */
	public Double getWaitingTime() {
		return waitingTime.getValue();
	}

	/**
	 * @param waitingTime
	 *            the waitingTime to set
	 */
	public void setWaitingTime(Double waitingTime) {
		this.waitingTime.setValue(waitingTime);
	}

	private StringProperty process = new SimpleStringProperty();
	private DoubleProperty arivalTime = new SimpleDoubleProperty();
	private DoubleProperty burstTime = new SimpleDoubleProperty();
	private DoubleProperty complictionTime = new SimpleDoubleProperty();
	private DoubleProperty turnArroundTime = new SimpleDoubleProperty();
	private DoubleProperty waitingTime = new SimpleDoubleProperty();
}
