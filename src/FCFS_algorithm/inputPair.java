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
public class inputPair {

	inputPair(String process, Double arivalTime, Double burstTime) {
		this.process.setValue(process);
		this.arivalTime.setValue(arivalTime);
		this.burstTime.setValue(burstTime);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "inputPair [process=" + process + ", arivalTime=" + arivalTime + ", burstTime=" + burstTime + "]";
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

	private StringProperty process = new SimpleStringProperty();
	private DoubleProperty arivalTime = new SimpleDoubleProperty();
	private DoubleProperty burstTime = new SimpleDoubleProperty();
}
