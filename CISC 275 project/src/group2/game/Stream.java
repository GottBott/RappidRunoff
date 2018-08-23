package group2.game;

public class Stream extends River {

	
	
	public Stream(int stream_number) {
		water_identifier = stream_number;
		position = new Position(
				(stream_number * 2.0 / 11 + (stream_number - 1) * 1.0 / 11),
				(1.0 / 5));
		position.width = (1.0 / 11);
		position.height = (6.0 / 10);
	}

}
