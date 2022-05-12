package domain;

import java.io.Serializable;

public class DesktopComputer implements Serializable {

	private static final long serialVersionUID = 1L;

	private BaseComputer bc;
	private String gpuType;

	public static DesktopComputer getInstance(BaseComputer bc, String gpuType) {
		return new DesktopComputer(bc, gpuType);
	}

	private DesktopComputer(BaseComputer bc, String gpuType) {
		//new BaseComputer (bc.getCpuType(), bc.getRamSize(), bc.getDiskSize());
		this.bc = bc;
		this.gpuType = gpuType;
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

	public String getGpuType() {
		return gpuType;
	}
	@Override
	public String toString() {
		return "Type : DesktopComputer" + "\n" + "CPU : " + bc.getCpuType() + "\n" + "RAM :" + bc.getRamSize() + " GB"
				+ "\n" + "Disk : " + bc.getDiskSize() + " GB" + "\n" + "GPU : " + getGpuType() + "\n";
	}
}