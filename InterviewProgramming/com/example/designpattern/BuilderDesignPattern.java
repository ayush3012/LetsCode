package com.example.designpattern;

//This is creational design pattern
//It is used when there are too many parameter and some are optional
class VehicleObj{
	
	String engine;
	int wheel;
	boolean airbag;
	public VehicleObj(VehicleBuilder vb) {
		this.engine = vb.engine;
		this.wheel = vb.wheel;
		this.airbag = vb.airbag;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public int getWheel() {
		return wheel;
	}
	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	public boolean isAirbag() {
		return airbag;
	}
	public void setAirbag(boolean airbag) {
		this.airbag = airbag;
	}
	static class VehicleBuilder{
		String engine;
		int wheel;
		boolean airbag;
		public VehicleBuilder(String engine, int wheel) {
			this.engine = engine;
			this.wheel = wheel;
		}
		public VehicleBuilder setAirbag(boolean b)
		{
			this.airbag=b;
			return this;
		}
		public VehicleObj build()
		{
			return new VehicleObj(this);
		}
	}
}
public class BuilderDesignPattern {

	public static void main(String[] args) {
		
		VehicleObj car=new VehicleObj.VehicleBuilder("2200cc", 4).setAirbag(true).build();
		VehicleObj bike=new VehicleObj.VehicleBuilder("1500cc", 2).build();
		System.out.println("car: "+car.getEngine()+" "+car.getWheel()+" "+car.isAirbag());
		System.out.println("bike: "+bike.getEngine()+" "+bike.getWheel()+" "+bike.isAirbag());
	}

}
