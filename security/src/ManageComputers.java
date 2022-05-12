import java.io.*;
import java.util.*;
import domain.BaseComputer;
import domain.DesktopComputer;
import domain.LaptopComputer;

public class ManageComputers {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Object> mc = new ArrayList<Object>();

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		
		int numChoice = 0;

		do {
			System.out.println("====MENU====");
			System.out.println("1. Load");
			System.out.println("2. Save");
			System.out.println("3. List");
			System.out.println("4. Add");
			System.out.println("5. Delete");
			System.out.println("6. Edit");
			System.out.println("0. Exit");

			System.out.print("Enter selection: ");
			numChoice = Integer.parseInt(br.readLine());

			System.out.println();

			if (numChoice < 0 || numChoice > 6) {
				System.out.println("Invalid Input!");
				continue;
			}

			switch (numChoice) {
			case 1:
				loadComputer();
				break;
			case 2:
				saveComputer(mc);
				break;
			case 3:
				listComputer(mc);
				break;
			case 4:
				addComputer(mc);
				break;
			case 5:
				deleteComputer(mc);
				break;
			case 6:
				editComputer(mc);
				break;
			case 0:
				exitProgram(mc);
				break;
			}

		} while (numChoice != 0);

	}

	private static ArrayList<Object> loadComputer() throws IOException, ClassNotFoundException {

		File f = new File("assign1Data/");
		File[] files = f.listFiles();

		for (File file : files) {
			String filename = file.getName();

			//Object o = deserializeObject(filename);
			mc=  (ArrayList<Object>) deserializeObject(filename);
			//mc.add(o);
		}
		return mc;
	}

	private static Object deserializeObject(String filename)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		Object o = null;
		FileInputStream fis = new FileInputStream("assign1Data/" + filename);
		ObjectInputStream in = new ObjectInputStream(fis);
		o = in.readObject();
		in.close();
		fis.close();

		return o;
	}
	
	private static void saveComputer(ArrayList<Object> mc) throws FileNotFoundException, IOException {
		File f = new File("assign1Data/");
		File[] files = f.listFiles();
		for (File file : files) {
			file.delete();
		}
		for (int i = 0; i < mc.size(); i++) {
			serializeObject(mc);
		}
	}

	private static void serializeObject(ArrayList<Object> mc) throws FileNotFoundException, IOException {

		for (int i = 0; i < mc.size(); i++) {
			FileOutputStream fout = new FileOutputStream("assign1Data/" + (i + 1) + ".txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(mc);
			oos.close();
		}
	}

	private static void listComputer(ArrayList<Object> mc) {

		if (mc.size() == 0) {
			return;
		}

		for (int i = 0; i < mc.size(); i++) {
			System.out.println("--------------");
			System.out.println("COMPUTER #" + (i + 1));

			if (mc.contains("intel")|| mc.contains("amd") || mc.contains("nvida")|| mc.contains("DesktopComputer")) {
				System.out.println(mc.get(i) +"hi");
			} else {
				System.out.println(mc.get(i));
			}
		}
	}

	private static void addComputer(ArrayList<Object> mc) throws IOException, NullPointerException {

		int numChoice, screenSize;
		String cpuType = null;
		String gpuType;
		int ramSize = 0;
		int diskSize = 0;

		BaseComputer b = BaseComputer.getInstance(null, 0, 0);

		System.out.println("ADD NEW COMPUTER");
		System.out.println("1. Add new LaptopComputer");
		System.out.println("2. Add new DesktopComputer");
		System.out.println("3. Back to main menu");

		numChoice = Integer.parseInt(br.readLine());

		switch (numChoice) {

		case 1:
			System.out.println("Enter CPU type (i5/i7) :");
			cpuType = br.readLine();
			if(cpuType.equals("i5") || cpuType.equals("i6") || cpuType.equals("i7")) {
			b.setCpuType(cpuType);
			}
			else {
				System.out.println("Enter Valid Entry");
				break;
			}
			System.out.println("Enter RAM size (8/16) :");
			ramSize =  Integer.parseInt(br.readLine());
			if(ramSize == 8 || ramSize == 16) {
				b.setRamSize(ramSize);
				}
				else {
					System.out.println("Enter Valid Entry");
					break;
				}
			System.out.println("Enter disk size (250/500) :");
			diskSize = Integer.parseInt(br.readLine());
		
			if(diskSize == 250 || diskSize == 500) {
				b.setDiskSize(diskSize);
				}
				else {
					System.out.println("Enter Valid Entry");
					break;
				}
			System.out.println("Enter screen size (13/15) :");
			screenSize = Integer.parseInt(br.readLine());
			if(screenSize == 13 || screenSize == 15) {
				}
				else {
					screenSize = 0;
					System.out.println("Enter Valid Entry");
					break;
				}
			LaptopComputer laptop = LaptopComputer.getInstance(b, screenSize);
			mc.add(laptop);
			break;

		case 2:
			System.out.println("Enter CPU type (i5/i7) :");
			cpuType = br.readLine();
			if(cpuType.equals("i5") || cpuType.equals("i6") || cpuType.equals("i7")) {
			b.setCpuType(cpuType);
			}
			else {
				System.out.println("Enter Valid Entry");
				break;
			}
			System.out.println("Enter RAM size (8/16) :");
			ramSize =  Integer.parseInt(br.readLine());
			if(ramSize == 8 || ramSize == 16) {
				b.setRamSize(ramSize);
				}
				else {
					System.out.println("Enter Valid Entry");
					break;
				}
			System.out.println("Enter disk size (250/500) :");
			diskSize = Integer.parseInt(br.readLine());
			if(diskSize == 250 || diskSize == 500) {
				b.setDiskSize(diskSize);
				}
				else {
					System.out.println("Enter Valid Entry");
					break;
				}
			System.out.println("Enter GPU (intel/amd/nvidia) :");
			gpuType = br.readLine();
			if(gpuType.equals("intel") || gpuType.equals("amd") || gpuType.equals("nvidia")) {
			}
			else {
				gpuType = null;
				System.out.println("Enter Valid Entry");
				break;
			}
			DesktopComputer desktop = DesktopComputer.getInstance(b, gpuType);
			mc.add(desktop);
			break;

		case 3:
			break;
		}
	}

	private static void deleteComputer(ArrayList<Object> mc) throws FileNotFoundException, IOException {
		int count;
		System.out.print("DELETE COMPUTER");
		System.out.print("Enter number of computer to delete: ");
		count = Integer.parseInt(br.readLine());

		if (count <= 0) {
			throw new IllegalArgumentException("***ERROR : Invalid computer number entered ***");
		}

		
			if (count<=mc.size()) {
				mc.remove(count-1);
			} else {
				throw new IllegalArgumentException("***ERROR : Invalid computer number entered ***");
			}
	}

	private static void editComputer(ArrayList<Object> mc) throws FileNotFoundException, IOException {
		int count;
		//int numChoice;
		String cpuType= null;
		int ramSize = 0 ;
		int diskSize;
		String gpuType;
		int screenSize;
		BaseComputer b = BaseComputer.getInstance(null, 0, 0);
		System.out.println("EDIT COMPUTER");
		System.out.println("Enter number of computer to edit: ");
		count = Integer.parseInt(br.readLine());
		
			if (count <= mc.size()) {
				for (int i = 0; i < mc.size(); i++) {
					if(i == (count-1)) {
				if (mc.contains("intel") || mc.contains("amd") || mc.contains("nvida")) {
					System.out.println("Enter CPU type (i5/i7) :");
					cpuType = br.readLine();
					if(cpuType.equals("i5") || cpuType.equals("i6") || cpuType.equals("i7")) {
					b.setCpuType(cpuType);
					}
					else {
						System.out.println("Enter Valid Entry");
						break;
					}
					System.out.println("Enter RAM size (8/16) :");
					if(ramSize == 8 || ramSize == 16) {
						ramSize =  Integer.parseInt(br.readLine());
						b.setRamSize(ramSize);
						}
						else {
							System.out.println("Enter Valid Entry");
							break;
						}
					
					System.out.println("Enter disk size (250/500) :");
					diskSize = Integer.parseInt(br.readLine());
					if(diskSize == 250 || diskSize == 500) {
						b.setDiskSize(diskSize);
						}
						else {
							System.out.println("Enter Valid Entry");
							break;
						}
					System.out.println("Enter GPU (intel/amd/nvidia) :");
					gpuType = br.readLine();
					if(gpuType.equals("intel") || gpuType.equals("amd") || gpuType.equals("nvidia")) {
					}
					else {
						gpuType = null;
						System.out.println("Enter Valid Entry");
						break;
					}
					DesktopComputer desktop = DesktopComputer.getInstance(b, gpuType);
					mc.add(i,desktop);
					mc.remove(i+1);
					break;
				} 
				else {
					System.out.println("Enter CPU type (i5/i7) :");
					cpuType = br.readLine();
					if(cpuType.equals("i5") || cpuType.equals("i6") || cpuType.equals("i7")) {
					b.setCpuType(cpuType);
					}
					else {
						System.out.println("Enter Valid Entry");
						break;
					}
					
					System.out.println("Enter RAM size (8/16) :");
					ramSize =  Integer.parseInt(br.readLine());
					if(ramSize == 8 || ramSize == 16) {
						b.setRamSize(ramSize);
						}
						else {
							System.out.println("Enter Valid Entry");
							break;
						}
					
					System.out.println("Enter disk size (250/500) :");
					diskSize = Integer.parseInt(br.readLine());
					if(diskSize == 250 || diskSize == 500) {
						b.setDiskSize(diskSize);
						}
						else {
							System.out.println("Enter Valid Entry");
							break;
						}
					System.out.println("Enter screen size (13/15) :");
					screenSize = Integer.parseInt(br.readLine());
					if(screenSize == 13 || screenSize == 15) {
						}
						else {
							screenSize = 0;
							System.out.println("Enter Valid Entry");
							break;
						}
					LaptopComputer laptop = LaptopComputer.getInstance(b, screenSize);
					mc.add(i,laptop);
					mc.remove(i+1);
					break;
				}
			}
				}
			}else {
				throw new IllegalArgumentException("***ERROR : Invalid computer number entered ***");
			}
		}
	

	private static void exitProgram(ArrayList<Object> mc) throws IOException {
		
		return;
	}
}