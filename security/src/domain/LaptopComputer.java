package domain;

import java.io.Serializable;
import java.util.ArrayList;

public class LaptopComputer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private BaseComputer bc;
	private int screenSize;
	
	public static LaptopComputer getInstance(BaseComputer bc, int screenSize) {
		
		return new LaptopComputer(bc, screenSize);
	}

	private LaptopComputer(BaseComputer bc, int screenSize) {
		//new BaseComputer (bc.getCpuType(), bc.getRamSize(), bc.getDiskSize());
		//bc = BaseComputer.getInstance(getCpuType(), getRamSize(), getDiskSize());
		this.bc = bc;
		this.screenSize = screenSize;
	}
	
	public String getCpuType() {
		return bc.getCpuType();
	}

	public int getRamSize() {
		return bc.getRamSize();
	}

	public int getDiskSize() {
		return bc.getDiskSize();
	}

	public int getScreenSize() {
		return screenSize;
	}

	@Override
	public String toString() {
		return "Type : LaptopComputer" + "\n" + "CPU : " + bc.getCpuType() + "\n" + "RAM :" + bc.getRamSize() + " GB"
				+ "\n" + "Disk : " + bc.getDiskSize() + " GB"  + "\n" +"Screen Size : " + getScreenSize() + " inches" + "\n";
	}
}