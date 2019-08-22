package io;

import game.DirectionHorizontal;
import game.DirectionVertical;

public interface Io extends FieldPrinter{
	void printMessage(String message);

	void showError(String error);

	String inputText();

	String inputText(String message);
	
	Integer inputIntegerNumber();
	
	Integer inputIntegerNumber(String message);
	
	<T> T choiceFromArray(T[] list);
	
	<T> T choiceFromArray(T[] list, String whatChoice);
	
	DirectionHorizontal inputDirectionHorizontal();
	
	DirectionVertical inputDirectionVertical();
}
