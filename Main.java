import java.io.IOException;
import java.util.Scanner;

public class Main
{
	public static void clearScreen(){
    //Clears Screen in java
    try 
		{
				//windows clear screen
        if (System.getProperty("os.name").contains("Windows"))
				{
					//hope this works
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				}
        else
				{
					//Linux\Unix clear screen (probably the best idea)
					System.out.print("\033[H\033[2J");  
   				System.out.flush();  
				} 
    } 
		catch (IOException | InterruptedException ex) 
		{
			ex.printStackTrace();
		}
	}

  public static void main(String[] args)
  {
		//testing
    Computer comp = new Computer();
    Part cpu = new Part("Xeon e5 2690 v3", 54.24f, 180.0f);		
		Part gpu = new Part("GTX 680", 200.0f, 195.0f, "https://www.ebay.com/itm/185251093760", true);
		Part psu = new Part("Corsair CX750", 80.0f, 0.0f);

    comp.addPartToList(cpu);
		comp.addPartToList(gpu);
		comp.addPartToList(psu);
		comp.setName("comp");

		Storage.openFile("mySickBuild.lst");
		Storage.writeFile(comp);

		System.out.println(Storage.readFile());

		//clearScreen();
		//interface loop
		Scanner readCommand = new Scanner(System.in);
		readCommand.useDelimiter(System.lineSeparator());
		boolean isRunning = true;
		String currentCommand = "";
		while (isRunning)
		{
			System.out.print("User@PCPartList: ");
			currentCommand = readCommand.next();

			isRunning = Commands.readCommand(currentCommand);
		}
		readCommand.close();
  }
}
