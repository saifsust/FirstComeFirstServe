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
public class processScheduling {

	private processScheduling(String process, Double startTime, Double finishTime) {
		this.process.setValue(process);
		this.startTime.setValue(startTime);
		this.finishTime.setValue(finishTime);
	}

	/**
	 * @return the process
	 */
	public String getProcess() {
		return process.getValue();
	}

	/**
	 * @param process
	 *            the process to set
	 */
	public void setProcess(String process) {
		this.process.setValue(process);
	}

	/**
	 * @return the startTime
	 */
	public Double getStartTime() {
		return startTime.getValue();
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Double startTime) {
		this.startTime.setValue(startTime);
		;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "processScheduling [process=" + process + ", startTime=" + startTime + ", finishTime=" + finishTime
				+ "]";
	}

	/**
	 * @return the finishTime
	 */
	public Double getFinishTime() {
		return finishTime.getValue();
	}

	/**
	 * @param finishTime
	 *            the finishTime to set
	 */
	public void setFinishTime(Double finishTime) {
		this.finishTime.setValue(finishTime);
	}

	private StringProperty process = new SimpleStringProperty();
	private DoubleProperty startTime = new SimpleDoubleProperty();
	private DoubleProperty finishTime = new SimpleDoubleProperty();
}
