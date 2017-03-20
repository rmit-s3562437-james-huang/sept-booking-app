package abs.model;

import java.util.Scanner;

import java.nio.file.*;
import java.io.*;

import abs.model.interfaces.*;
import abs.model.users.Customer;
import abs.model.users.Owner;

import abs.model.data.*;

public class AbsFileOperationImpl implements FileOperation {
	
	private String filePath;
	private String fileName;
	
	public AbsFileOperationImpl(String filePath, String fileName){
		
		this.filePath = filePath;
		this.fileName = fileName;
		
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void createFile() {
		
		System.out.println("A file is about to be created!");
		
		String path = this.getFilePath() + this.getFileName() + ".txt";
		
		Path file = Paths.get(path);
		
		try(BufferedWriter writer = Files.newBufferedWriter(file)) {
				writer.write("");
		}
		catch (IOException x)
		{
			System.err.println("Create fucked up man.");
		}
	}
	
	public void writeToFile() {
		
		String path = this.getFilePath() + this.getFileName() + ".txt";
	
		String input;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("You are about to type into file!");
		System.out.println("Type 'end' to end the session!");
		
		Boolean end = false;
		while(end == false)
		{
			try(FileWriter writer = new FileWriter(path, true))
			{
				input = scanner.nextLine();
				if(input.equals("end"))
				{
					end = true;
				}
				else
				{
					writer.write(input + System.lineSeparator());
				}
			}
			catch(IOException e)
			{
				System.err.println("Write fucked up splendidly.");
			}
		}
	}
	
	public void readFromFile() {
		
		String path = this.getFilePath() + this.getFileName() + ".txt";
		Path file = Paths.get(path);
		
		try(BufferedReader reader = Files.newBufferedReader(file)){
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch(IOException e)
		{
			System.err.println("How come reading can fuck up?");
		}
	}
	
	public Owner readFromOwner() {
		
		Owner owner = null;
		String path = this.getFilePath() + this.getFileName() +  ".txt";
		Path file = Paths.get(path);
		
		try (BufferedReader reader = Files.newBufferedReader(file)) {
			String line = null;
			line = reader.readLine();
			String[] data = line.split("\\,\\ "); 
			owner = new Owner(data[0].toString(), data[1].toString(), data[2].toString(),
					data[3].toString(), data[4].toString(), data[5].toString(), data[6].toString());
		} catch(IOException e) {
			System.err.println("HAH IT FUCKED UP!");
		}
		
		return owner;
	}
	
	public Customer readFromCustomer() {
		
		Customer customer = null;
		String path = this.getFilePath() + this.getFileName() +  ".txt";
		Path file = Paths.get(path);
		
		try (BufferedReader reader = Files.newBufferedReader(file)) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split("\\,\\ "); 
				customer = new Customer(data[0].toString(), data[1].toString(), data[2].toString(),
						data[3].toString(), data[4].toString());
				
			}
			
		} catch(IOException e) {
			System.err.println("HAH IT FUCKED UP!");
		}
		
		return customer;
	}
	
	public void primeCustomerFile() {
		
		AbstractData data = new CustomerData();
		String path = data.PATH + data.CUSTOMERFILE + ".txt";
		
		try(FileWriter writer = new FileWriter(path, false)) {
			//priming file
		}
		catch(IOException e) {
			System.out.println("failed priming");
		}
	}
	
	public void writeToCustomerFile(String toWrite, boolean newLine) {
		
		AbstractData data = new CustomerData();
		String path = data.PATH + data.CUSTOMERFILE + ".txt";
		
		if(newLine == true) {
			try(FileWriter writer = new FileWriter(path, true)) {
				writer.write(toWrite + System.lineSeparator());
			}
			catch(IOException e) {
				System.out.println("fucked up");
			}
		}
		else {
			try(FileWriter writer = new FileWriter(path, true)) {
				writer.write(toWrite);
			}
			catch(IOException e) {
				System.out.println("fucked up");
			}
		}
	}
	
	/*public void writeToCustomerFile(String toWrite, Boolean newLine) {
		
		AbstractData data = new CustomerData();
		String name, userName, password, address, phoneNumber;
		String delim = ", ";
		String customerString;
		int count = 0;
		
		String path = data.PATH + data.CUSTOMERFILE + ".txt";
		
		for(Customer customer : data.getCustomerMap().values()) {
			try(FileWriter writer = new FileWriter(path, true)) {
				
				name = customer.getName();
				userName = customer.getUserName();
				password = customer.getUserPassword();
				address = customer.getUserAddress();
				phoneNumber = customer.getUserPhoneNumber();
				
				count++;
				System.out.println(count);
				customerString = name + delim + userName + delim + 
						password + delim + address + 
						delim + phoneNumber;
				writer.write(customerString);
				
				
				if(count < data.getCustomerMap().size())
				{
					writer.write(System.lineSeparator());
				}
			}
			catch(IOException e) {
				System.out.println("Fucked up again!");
			}
		}
		
		try(FileWriter writer = new FileWriter(path, false)) {
			for(Customer customer : data.getCustomerMap().values()) {
				name = customer.getName();
				userName = customer.getUserName();
				password = customer.getUserPassword();
				address = customer.getUserAddress();
				phoneNumber = customer.getUserPhoneNumber();
				
				count++;
				System.out.println(count);
				customerString = name + delim + userName + delim + 
						password + delim + address + 
						delim + phoneNumber;
				writer.write(customerString);
				
				
				if(count < data.getCustomerMap().size())
				{
					writer.write(System.lineSeparator());
				}
			}
			
		}
		catch(IOException e) {
			System.err.println("Write fucked up splendidly.");
		}
		
		for(Customer customer : data.getCustomerMap().values()) {
			try(BufferedWriter writer = Files.newBufferedWriter(file))
				{
					name = customer.getName();
					userName = customer.getUserName();
					password = customer.getUserPassword();
					address = customer.getUserAddress();
					phoneNumber = customer.getUserPhoneNumber();
					
					customerString = name + delim + userName + delim + 
							password + delim + address + 
							delim + phoneNumber;
					writer.write(customerString);
					
					count++;
					
					if(count != data.getCustomerMap().size())
					{
						writer.write(System.lineSeparator());
					}
				}
				catch(IOException e)
				{
					System.err.println("Write fucked up splendidly.");
				}
			}
		
	}*/
}
