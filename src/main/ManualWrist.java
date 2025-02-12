package frc.robot;


//import static edu.wpi.first.units.Units.Degrees;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Wrist;


public class ManualWrist extends Command {
    private final Wrist wrist;
    private final DoubleSupplier speedSupplier;
    private double lastPosition;
   
    private static final double POSITION_TOLERANCE = 3.0;  // Degrees
    private static final double SPEED_DEADBAND = 0.05;      // Minimum input threshold
    private static final double ENCODER_TO_DEGREES = 1.0;   // Conversion factor


    public ManualWrist(Wrist wrist, DoubleSupplier speedSupplier) {
        this.wrist = wrist;
        this.speedSupplier = speedSupplier;


        addRequirements(wrist);
    }


    @Override
    public void initialize() {
        lastPosition = getWristPosition();
    }


    @Override
    public void execute() {
        double currentPosition = getWristPosition();
        double speed = speedSupplier.getAsDouble();


        // Update last known position if movement exceeds the tolerance
        if (Math.abs(lastPosition - currentPosition) > POSITION_TOLERANCE) {
            lastPosition = currentPosition;
        }


        // Control wrist movement based on speed input
        if (Math.abs(speed) > SPEED_DEADBAND) {
            wrist.ManualMoveWrist(speed);
        } else {
            wrist.PIDmoveWrist(lastPosition); // Hold position if no movement input
        }
    }


    @Override
    public void end(boolean interrupted) {
        wrist.ManualMoveWrist(0); // Stop movement when command ends
    }


    @Override
    public boolean isFinished() {
        return false; // Runs indefinitely unless interrupted
    }


    /**
     * Helper method to get the wrist position in degrees.
     */
    private double getWristPosition() {
        return wrist.getWristEncoder() * ENCODER_TO_DEGREES;
    }
}