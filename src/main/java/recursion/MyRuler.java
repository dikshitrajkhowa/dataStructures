package recursion;

//Without recursion
public class MyRuler {

	StringBuilder ticks = new StringBuilder();
	StringBuilder ticksToLabels = new StringBuilder();
	StringBuilder labels = new StringBuilder();

	int millimetersPerCentimeter = 10;

	String drawRuler(int centimeters) {
		// append the first tick, tick to label, and label
		ticks.append("| ");
		ticksToLabels.append("| ");
		labels.append(0);

		for (int i = 0; i < centimeters; i++) {
			for (int j = 0; j < millimetersPerCentimeter; j++) {
				if (j == millimetersPerCentimeter - 1) {
					ticksToLabels.append("| ");
					labels.append(" " + (i + 1));
				} else {
					ticksToLabels.append("  ");
					labels.append("  ");
				}
				ticks.append("| ");
			}
		}
		ticks.append("\n" + ticksToLabels.toString() + "\n" + labels.toString());
		return ticks.toString();
	}

	public static void main(String[] args) {
		MyRuler ruler = new MyRuler();
		System.out.println(ruler.drawRuler(2));
	}
}

/**
 * Ok, so the basic idea is to separate each row of ticks or labels as it's own
 * String like:
 * 
 * String1 = | | | | | | | | | | | | | | | | | | | | | | | ... // regular ticks
 * String2 = | | | ... // ticks to labels String3 = 0 1 2 // labels
 **/
