package frc.robot;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Wrist;


public class PIDWrist extends Command {
    private final Wrist wrist;
    private final double targetPosition;


    public PIDWrist(Wrist wrist, double position) {
        this.wrist = wrist;
        this.targetPosition = position;


        addRequirements(wrist); // Fixed typo
    }


    @Override
    public void initialize() {
        // No initialization needed
    }


    @Override
    public void execute() {
        wrist.PIDmoveWrist(targetPosition);
    }


    @Override
    public void end(boolean interrupted) {
        wrist.ManualMoveWrist(0); // Stop the wrist when command ends
    }


    @Override
    public boolean isFinished() {
        return false; // Runs indefinitely unless interrupted
    }
}
