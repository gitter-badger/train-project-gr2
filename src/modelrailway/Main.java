package modelrailway;

import modelrailway.railsystem.BaseFork;
import modelrailway.railsystem.CurveRail;
import modelrailway.railsystem.StraightRail;
import modelrailway.railsystem.StraightWithConnection;
import modelrailway.railsystem.Trafo;
import modelrailway.railsystem.RailRoad;
import modelrailway.vehicles.Train;
import modelrailway.vehicles.Locomotive;
import modelrailway.vehicles.Wagon;

/**
 * This is the main class. It handles this application.
 * 
 * @author Simon Styger
 * @version 1.0
 */
public class Main {

	/**
	 * Main Methode
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RailRoad railRoad = Main.createRailRoad();
			Train train = Main.createTrain();
			train.move(railRoad,'B');
		} catch(Exception e) {
			System.out.println("EXCEPTION " + e.getMessage());
		}
	}
	
	public static Train createTrain() {
		Train train = new Train(new Locomotive());
		train.addWagon(new Wagon("people",40,"red"));
		train.addWagon(new Wagon("people",40,"blue"));
		return train;
	}
	
	public static RailRoad createRailRoad() throws Exception{
		// CREATION
		// Bottom
		CurveRail bottomCurve1 = new CurveRail();
		CurveRail bottomCurve2 = new CurveRail();
		CurveRail bottomCurve3 = new CurveRail();
		CurveRail bottomCurve4 = new CurveRail();
		CurveRail bottomCurve5 = new CurveRail();
		CurveRail bottomCurve6 = new CurveRail();
		
		// Forks
		BaseFork leftFork = new BaseFork("left");
		BaseFork rightFork = new BaseFork("right");
		
		// Left Outer Side
		Trafo trafo = new Trafo();
		StraightWithConnection leftOuterStraightWithConnection = new StraightWithConnection(trafo);
		StraightRail leftOuterStraightRail = new StraightRail();
		CurveRail leftOuterCurve1 = new CurveRail();
		CurveRail leftOuterCurve2 = new CurveRail();
		CurveRail leftOuterCurve3 = new CurveRail();
		
		// Left Inner Side
		StraightRail leftInnerStraight = new StraightRail();
		CurveRail leftInnerCurve1 = new CurveRail();
		CurveRail leftInnerCurve2 = new CurveRail();
		CurveRail leftInnerCurve3 = new CurveRail();
		
		// Top Side
		StraightRail topStraightRail = new StraightRail();
		
		// Right Outer Side
		StraightRail rightOuterStraightRail = new StraightRail();
		rightOuterStraightRail.setLength(leftOuterStraightRail.getLength() + leftOuterStraightWithConnection.getLength());
		CurveRail rightOuterCurve1 = new CurveRail();
		CurveRail rightOuterCurve2 = new CurveRail();
		CurveRail rightOuterCurve3 = new CurveRail();
		
		// Right Inner Side
		StraightRail rightInnerStraight = new StraightRail();
		CurveRail rightInnerCurve1 = new CurveRail();
		CurveRail rightInnerCurve2 = new CurveRail();
		CurveRail rightInnerCurve3 = new CurveRail();
		
		// CONNECTIONS
		// Bottom
		bottomCurve1.connect(bottomCurve2);
		bottomCurve1.connect(leftFork);

		bottomCurve2.connect(bottomCurve3);
		bottomCurve2.connect(bottomCurve1);

		bottomCurve3.connect(bottomCurve4);
		bottomCurve3.connect(bottomCurve2);

		bottomCurve4.connect(bottomCurve5);
		bottomCurve4.connect(bottomCurve3);

		bottomCurve5.connect(bottomCurve6);
		bottomCurve5.connect(bottomCurve4);

		bottomCurve6.connect(rightFork);
		bottomCurve6.connect(bottomCurve5);
		
		// Forks
		leftFork.connect(bottomCurve1);
		leftFork.connect(leftInnerStraight);
		leftFork.connect(leftOuterStraightWithConnection); // curves last

		rightFork.connect(rightInnerStraight);
		rightFork.connect(bottomCurve6);
		rightFork.connect(rightOuterStraightRail); // curves last
		
		// Left Outer Side
		leftOuterStraightWithConnection.connect(leftFork);
		leftOuterStraightWithConnection.connect(leftOuterStraightRail);

		leftOuterStraightRail.connect(leftOuterStraightWithConnection);
		leftOuterStraightRail.connect(leftOuterCurve1);

		leftOuterCurve1.connect(leftOuterStraightRail);
		leftOuterCurve1.connect(leftOuterCurve2);

		leftOuterCurve2.connect(leftOuterCurve1);
		leftOuterCurve2.connect(leftOuterCurve3);
		
		leftOuterCurve3.connect(leftOuterCurve2);
		leftOuterCurve3.connect(topStraightRail);
		
		// Left Inner Side
		leftInnerStraight.connect(leftFork);
		leftInnerStraight.connect(leftInnerCurve1);

		leftInnerCurve1.connect(leftInnerStraight);
		leftInnerCurve1.connect(leftInnerCurve2);

		leftInnerCurve2.connect(leftInnerCurve1);
		leftInnerCurve2.connect(leftInnerCurve3);

		leftInnerCurve3.connect(leftInnerCurve2);
		leftInnerCurve3.connect(rightInnerCurve3);
		
		// Top Side
		topStraightRail.connect(leftOuterCurve3);
		topStraightRail.connect(rightOuterCurve3);
		
		// Right Outer Side
		rightOuterStraightRail.connect(rightFork);
		rightOuterStraightRail.connect(rightOuterCurve1);

		rightOuterCurve1.connect(rightOuterStraightRail);
		rightOuterCurve1.connect(rightOuterCurve2);

		rightOuterCurve2.connect(rightOuterCurve1);
		rightOuterCurve2.connect(rightOuterCurve3);
		
		rightOuterCurve3.connect(rightOuterCurve2);
		rightOuterCurve3.connect(topStraightRail);
		
		// Right Inner Side
		rightInnerStraight.connect(rightInnerCurve1);
		rightInnerStraight.connect(rightFork);

		rightInnerCurve1.connect(rightInnerCurve2);
		rightInnerCurve1.connect(rightInnerStraight);

		rightInnerCurve2.connect(rightInnerCurve3);
		rightInnerCurve2.connect(rightInnerCurve1);

		rightInnerCurve3.connect(leftInnerCurve3);
		rightInnerCurve3.connect(rightInnerCurve2);
		
		return new RailRoad(bottomCurve1,bottomCurve2);
	}

}