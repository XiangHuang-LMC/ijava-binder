/* Pretend we are building software for an autonomous car */
public abstract class demoAbstractCar
{
	private double speed;

	private static final double TOO_FAST_MPH = 100.0;
	private static final double TOO_FAST_KPH = 160.9;
	
	//Abstract methods must be defined using the keyword.
	public abstract boolean slowDown(double amount, double distance);
	public abstract boolean speedUp(double amount, double distance);
	public abstract boolean turn(boolean left, double degrees, double distance);
	public abstract boolean park(boolean parallel);

	//Instance methods in an  abstract class.
	public double getSpeed()
	{
		return speed;
	}
	public void setSpeed(double speed)
	{
		this.speed = speed;
	}

	//Class methods in an abstract class.
	public static double getTooFastMPH()
	{
		return TOO_FAST_MPH;
	}
	public static double getTooFastKPH()
	{
		return TOO_FAST_KPH;
	}
}
