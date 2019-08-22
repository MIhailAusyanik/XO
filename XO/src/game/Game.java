package game;

import field.errors.MoveException;
import io.ConsoleIo;
import io.FieldPrinter;

public class Game {
	private Sign[][] field;
	private Sign currentSign;

	public Game() {
		super();
		field = new Sign[3][3];
		currentSign = Sign.X;
	}

	public Sign makeMove(DirectionPair direction) throws MoveException {
		if (direction.getHorisontal() == null || direction.getVertical() == null) {
			throw new MoveException();
		}
		int row = direction.getHorisontal().getDirectionNumber();
		int column = direction.getVertical().getDirectionNumber();
		if (field[column][row] == null) {
			field[column][row] = nextSign();
			printField(ConsoleIo.getInstance());
			return checkStatus();
		} else {
			throw new MoveException();
		}
	}

	public void printField(FieldPrinter printer) {
		printer.print(field);
	}

	private Sign nextSign() {
		Sign sign = currentSign;
		currentSign = currentSign == Sign.X ? Sign.O : Sign.X;
		return sign;
	}
	
	private Sign checkStatus() {
		for (int i = 0; i < field.length; i++) {
			if (field[i][0] != null && field[i][0] == field[i][1] && field[i][0] == field[i][2]) {
				return field[i][0];
			} else if (field[0][i] != null && field[0][i] == field[1][i] && field[0][i] == field[2][i]) {
				return field[0][i];
			}
		}
		if ((field[0][0] != null && field[0][0] == field[1][1] && field[0][0] == field[2][2]) ||
				(field[0][2] != null && field[0][2] == field[1][1] && field[0][2] == field[2][0])) {
			return field[1][1];
		}
		return null;
	}

	public Sign getCurrentSign() {
		return currentSign;
	}	
}
