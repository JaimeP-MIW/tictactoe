package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.types.Error;

class MachinePlayerView extends PlayerView {

	MachinePlayerView(PlayController playController) {
		super(playController);
	}

	@Override
	public int[] readCoordinateToPut() {
		int[] coordinate = new int[2];
		Error error;
		do {
			coordinate = this.playController.generateRandomCoordinate();
			error = controlErrorsPutCoordinate(coordinate[0], coordinate[1]);
		} while (error != null);
		return coordinate;
	}

	@Override
	public int[][] readCoordinatesToMove() {
		int[] originCoordinate = new int[2];
		Error error;
		do {
			originCoordinate = this.playController.generateRandomCoordinate();
			error = controlErrorsMoveOriginCoordinate(originCoordinate[0], originCoordinate[1]);
		} while (error != null);
		int[] targetCoordinate = new int[2];
		do {
			targetCoordinate = this.playController.generateRandomCoordinate();
			error = controlErrorsMoveTargetCoordinate(originCoordinate[0], originCoordinate[1], targetCoordinate[0],
					targetCoordinate[1]);
		} while (error != null);
		int[][] coordinates = new int[2][2];
		coordinates[0] = originCoordinate;
		coordinates[1] = targetCoordinate;
		return coordinates;
	}

}