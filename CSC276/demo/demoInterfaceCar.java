/* Pretend we are building software for an autonomous car */
public interface demoInterfaceCar
{
	public static final double TOO_FAST_MPH = 100.0;
	public static final double TOO_FAST_KPH = 160.9;

	//Methods in an interface are abstract WITHOUT using the keyword.
	public boolean slowDown(double amount, double distance);
	public boolean speedUp(double amount, double distance);
	public boolean turn(boolean left, double degrees, double distance);
	public boolean park(boolean parallel);
}