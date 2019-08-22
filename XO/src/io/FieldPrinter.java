package io;

import game.Sign;

@FunctionalInterface
public interface FieldPrinter {
	void print(Sign[][] field);
}
