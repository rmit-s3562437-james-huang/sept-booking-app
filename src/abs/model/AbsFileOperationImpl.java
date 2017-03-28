package abs.model;

import java.util.ArrayList;
import java.util.Scanner;

import java.nio.file.*;
import java.awt.List;
import java.io.*;

import abs.model.interfaces.*;
import abs.model.users.Customer;
import abs.model.users.Owner;

import abs.model.data.*;

public class AbsFileOperationImpl implements FileOperation {

	public AbsFileOperationImpl() {

	}

	public void createFile(Path path) {

		System.out.println("A file is about to be created!");

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write("");
		} catch (IOException x) {
			System.err.println("ERROR: failed to create file");
		}
	}

	public ArrayList<String> readFromFile(Path path) {

		ArrayList<String> storeLines = new ArrayList<>();

		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String line;
			while ((line = reader.readLine()) != null) {
				storeLines.add(line);
			}

		} catch (IOException e) {
			System.err.println("ERROR: invalid file");
		}

		return storeLines;
	}

	public void primeCustomerFile(String FileWritePath) {

		try (FileWriter writer = new FileWriter(FileWritePath, false)) {
			// priming file
		} catch (IOException e) {
			System.out.println("ERROR: failed to prime");
		}
	}

	public void writeToCustomerFile(String FileWritePath, String toWrite, boolean newLine) {


		if (newLine == true) {
			try (FileWriter writer = new FileWriter(FileWritePath, true)) {
				writer.write(toWrite + System.lineSeparator());
			} catch (IOException e) {
				System.out.println("ERROR: failed to write");
			}
		} else {
			try (FileWriter writer = new FileWriter(FileWritePath, true)) {
				writer.write(toWrite);
			} catch (IOException e) {
				System.out.println("ERROR: failed to write");
			}
		}
	}

}
