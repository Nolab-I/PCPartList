import java.io.File;

public class Commands
{
	public static boolean readCommand(String command)
	{
		int argc = 0;
		for (int i = 0; i < command.length(); i++)
		{
			if (command.charAt(i) == ' ')
			{
				argc++;
			}
		}
		String[] argv = command.split(" ", argc);

		switch (argv[0])
		{
			case "open":
				if (argv.length >= 2)
				{
					open(argv[1]);
				}
				break;

			case "close":
				//exit program
				return false;

			case "add":
				//add part
				break;

			case "rm":
				//remove part
				break;

			case "purchase":
				//purchase part
				break;

			case "new":
				if (argv.length >= 2)
				{
					newFile(argv[1]);
				}
				break;

			case "del":
				//delete list
				break;
		}
		return true;
	}

	private static void open(String filename)
	{
		String finalFilename = "/lists/" + filename + ".lst";
		File tester = new File(finalFilename);
		if (tester.exists())
		{
			Storage.openFile(finalFilename);
		}
		else
		{
			System.out.println("File: " + filename + ", does not exist");
		}
	}

	private static void newFile(String filename)
	{
		String finalFilename = "/lists/" + filename + ".lst";
		File tester = new File(finalFilename);
		if (tester.exists())
		{
			System.out.println("File: " + filename + "already exists.");
		}
		else
		{
			Storage.openFile(finalFilename);
		}
	}

}