package javaFinaProj;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LockedMe {
	
	static final String projectFilesPath="D:\\Java Working\\workspace\\LockedMe";

	public static void displayMenu()
	{
		System.out.println("=====================================================");
		System.out.println("\t Welcome to LockedMe.com Secure app");
		System.out.println("\t Developed By Keerthana R");
		System.out.println("=====================================================");
		System.out.println("\t1. Display all files in folder");
		System.out.println("\t2. Add a file");
		System.out.println("\t3. Delete a file");
		System.out.println("\t4. Search a file");
		System.out.println("\t5. Exit");
	}

	
	public static void getAllFiles()
	{
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		
		if (listOfFiles.length>0)
		{
			System.out.println("FILES LIST IS BELOW\n");
		for(var l:listOfFiles)
		{
			System.out.println(l.getName());
		}
		}
		else
		{
			System.out.println("The folder is empty");
		}
	}

	
public static void createFiles()
	{
		try {
		Scanner obj = new Scanner(System.in);
		String fileName;
		System.out.println("Enter the File name:");
		fileName=obj.nextLine();
		
		int linesCount;
		System.out.println("Enter how many lines");
		linesCount=Integer.parseInt(obj.nextLine());
		
		FileWriter fw = new  FileWriter(projectFilesPath+"\\"+fileName+".txt");
		
		//Read line by line from user
		for(int i=1; i<=linesCount; i++ )
		{
			System.out.println("Enter file lines:");
			fw.write(obj.nextLine()+"\n");
		}
		System.out.println("File Created Successfully");
		fw.close();
		}
		catch(Exception Ex)
		{
			
		}
		
	}
	

	public static boolean checkFileExsits(String fileName)
	{
		ArrayList<String> allFileNames = new ArrayList<String>();
		File folder = new File(projectFilesPath);	
	   File[] listOfFiles = folder.listFiles();
		
		if (listOfFiles.length>0)
		{
		for(var l:listOfFiles)
		{
			allFileNames.add(l.getName());
		}
		}
		return allFileNames.contains(fileName);
	}
	
	
	public static void deleteFiles()
	{
		try {
		Scanner obj = new Scanner(System.in);
		String fileName;
		System.out.println("Enter the File name to be Deleted:");
		fileName=obj.nextLine();
		File f = new File(projectFilesPath+"\\"+fileName);
		
			if (checkFileExsits(fileName))
		{
			f.delete();
			System.out.println("File Deleted Successfully");
		}
		else
		{
			System.out.println("File not exists");
		}
		}
		catch(Exception Ex)
		{
			System.out.println("Prompt: Unable to process the request delete kindly contact : admin@simplilearnStuden.com");
		}
	}
	
	
	public static void searchFiles()
	{
		Scanner obj = new Scanner(System.in);
		String fileName;
		System.out.println("Enter the file name to be searched:");
		fileName=obj.nextLine();
			
				if(checkFileExsits(fileName))
				{
					System.out.println("File is available");
				}
				else
				{
					System.out.println("File is not available");
				}

	}
	
}
