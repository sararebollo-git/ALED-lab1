package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified channels from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractChannels implements Filter {
	private int[] validChannels;
	/**
	 * Builds the Filter. The use from an array of valid channels.
	 * 
	 * @param validChannels The channel numbers to be extracted, starting from 0.
	 */
	public FilterExtractChannels(int[] validChannels) {
		// TODO
		this.validChannels = validChannels;
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		// TODO
		EEGModel result= new EEGModel();
		for (Measurement measurement : eeg.getMeasurements()) {
			float[] channels = new float[validChannels.length];
			for (int i = 0; i < validChannels.length; i++) {
				channels[i] = measurement.getChannel(validChannels[i]);
			}
			result.addMeasurement(new Measurement(channels));
	}
	return result;
	}
}


