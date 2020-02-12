public class demoUseAbstractCar extends demoAbstractCar
{
	//Define class and instance variables
	private int numberPassengers;

	public demoUseAbstractCar(int numberPassengers)
	{
		this.numberPassengers = numberPassengers;
	}

	//Implement the abstract methods declared in demoAbstractCar
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
		System.out.println(demoAbstractCar.getTooFastMPH());
		return numberPassengers;
	}
	public void setNumberPassengers(int numberPassengers)
	{
		this.numberPassengers = numberPassengers;
	}
}
