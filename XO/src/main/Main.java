package main;

import field.errors.MoveException;
import game.DirectionHorizontal;
import game.DirectionPair;
import game.DirectionVertical;
import game.Game;
import game.Sign;
import io.ConsoleIo;
import io.Io;

public class Main {
	Io io = ConsoleIo.getInstance();

	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}

	public void start() {
		io.printMessage("Welcome to XO game");
		Game game = new Game();
		game.printField(io);
		while (true) {
			io.printMessage(String.format("Move of the %s player", game.getCurrentSign()));
			DirectionHorizontal horizontal = io.inputDirectionHorizontal();
			if (horizontal == null) {
				io.showError("exit from the game");
				return;
			}
			DirectionVertical vertical = io.inputDirectionVertical();
			if (vertical == null) {
				io.showError("exit from the game");
				return;
			}
			try {
				Sign status = game.makeMove(new DirectionPair(horizontal, vertical));
				if (status != null) {
					io.printMessage(String.format("%s win! Game over", status));
					return;
				}
			} catch (MoveException e) {
				io.showError("incorrect move, exit from the game");
				return;
			}
		}
	}

}
