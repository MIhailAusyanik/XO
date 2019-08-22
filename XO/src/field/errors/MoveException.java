package field.errors;

public class MoveException extends Exception{

	@Override
	public String getMessage() {
		return "Unable to perform action";
	}
	
}
