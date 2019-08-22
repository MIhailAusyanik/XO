package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import game.DirectionHorizontal;
import game.DirectionVertical;
import game.Sign;

public class ConsoleIo implements Io{
	private static ConsoleIo instance;
	private BufferedReader reader;

	private ConsoleIo() {
		super();
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static ConsoleIo getInstance() {
		synchronized (ConsoleIo.class) {
			if (instance == null) {
				instance = new ConsoleIo();
			}
		}
		return instance;
	}
	
	@Override
	public void printMessage(String message) {
		System.out.println(message);
	}
	
	@Override
	public void showError(String error) {
		System.err.println(error);
	}

	@Override
	public String inputText() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			showError("input Error");
			return null;
		}
	}
	
	@Override
	public String inputText(String message) {
		printMessage(message);
		return inputText();
	}
	
	@Override
	public Integer inputIntegerNumber() {
		try {
			return Integer.parseInt(inputText());
		} catch (NumberFormatException e) {
			showError("input Error");
			return null;
		}
	}

	@Override
	public Integer inputIntegerNumber(String prompt) {
		printMessage(prompt);
		return inputIntegerNumber();
	}
	
	@Override
	public <T> T choiceFromArray(T[] list) {
		return choiceFromArray(list, null);
	}
	
	@Override
	public <T> T choiceFromArray(T[] list, String whatChoice) {
		if (list.length == 0) {
			showError("There's no choice there");
			return null;
		}
		if (whatChoice != null && whatChoice != "") {
			printMessage(String.format("Please select %s:", whatChoice));
		}
		for (int i = 0; i < list.length; i++) {
			printMessage(String.format("\t%s - %s", i + 1, list[i]));
		}
		Integer input = inputIntegerNumber();
		if (input == null || input > list.length || input < 1) {
			showError("Incorrect input");
			return null;
		} else {
			return list[input - 1];
		}
	}

	@Override
	public DirectionHorizontal inputDirectionHorizontal() {
		DirectionHorizontal[] directions = DirectionHorizontal.values();
		return choiceFromArray(directions, "horizontal direction");
	}

	@Override
	public DirectionVertical inputDirectionVertical() {
		DirectionVertical[] directions = DirectionVertical.values();
		return choiceFromArray(directions, "vertical direction");
	}

	@Override
	public void print(Sign[][] field) {
		System.out.println();
		for (int row = 0; row < field.length; row++) {
			for (int column = 0; column < field[row].length; column++) {
				System.out.printf(" %s ", field[row][column] == null ? " " : field[row][column]);
				if (column != field[row].length - 1) {
					System.out.print("|");
				}
			}
			System.out.println();
			if (row != field.length - 1) {
				System.out.println("———————————");
			}
		}
		System.out.println();
	}
	
}
