package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wrist extends SubsystemBase {
    private final Encoder wristEncoder;
    public Wrist() {
        // Constructor
        wristEncoder = new Encoder(0, 1);
    }
    public void ManualMoveWrist(double speed) {
        // Move the wrist manually
    }
    public void PIDmoveWrist(double position) {
        // Move the wrist to
    
}
    public double getWristEncoder(){
        return wristEncoder.getDistance();
    }
}