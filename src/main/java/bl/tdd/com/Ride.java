package bl.tdd.com;

public class Ride {
	public final double distance;
	public final int time;

	public Ride (double distance, int time) {

		this.distance = distance;
		this.time = time;

	}

    public enum RideType {
        NORMAL,PREMIUM,RIDES
    }
}
