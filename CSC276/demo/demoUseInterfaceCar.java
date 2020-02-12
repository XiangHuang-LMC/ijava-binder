public class demoUseInterfaceCar implements demoInterfaceCar
{
	//Define class and instance variables
	private int numberPassengers;

	public demoUseInterfaceCar(int numberPassengers)
	{
		this.numberPassengers = numberPassengers;
	}

	//Implement the methods declared in demoInterfaceCar
	public boolean slowDown(double amount, double distance)
	{
		System.out.println("slowDown amount:" + amount + " distance:" + distance);
		return true;
	}
	public boolean speedUp(double amount, double distance)
	{
		System.out.println("speedUp amount:" + amount + " distance:" + distance);
		return true;
	}
	public boolean turn(boolean left, double degrees, double distance)
	{
		System.out.println("turn left:" + left + " degrees:" + degrees + " distance:" + distance);
		return true;
	}
	public boolean park(boolean parallel)
	{
		System.out.println("park parallel:" + parallel);
		return true;
	}

	//Define other methods
	public int getNumberPassengers()
	{
		System.out.println(demoInterfaceCar.TOO_FAST_MPH);
		return numberPassengers;
	}
	public void setNumberPassengers(int numberPassengers)
	{
		this.numberPassengers = numberPassengers;
	}
}
