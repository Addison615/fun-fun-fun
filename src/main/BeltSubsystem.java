package frc.robot.subsystems;
//may have to change to package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.BeltConstants;
import java.util.logging.Logger;
//import edu.wpi.first.wpilibj.SpeedController;

public class BeltSubsystem extends SubsystemBase {
    private final CANSparkMax b_motor = new CANSparkMax(BeltConstants.BELT_MOTOR_ID, MotorType.kBrushless);
    private static final Logger logger = Logger.getLogger(BeltSubsystem.class.getName());
    double b_backup;
    //double b_backup = BeltConstants.BELT_BACKUP_OFFSET;
    double initTime;
    //double speed = BeltConstants.BELT_MAX_SPEED;
    double speed;

    public BeltSubsystem(){
        b_motor.restoreFactoryDefaults();
        b_backup = BeltConstants.BELT_BACKUP_OFFSET;
        speed = BeltConstants.BELT_MOTOR_SPEED;
    }

    @Override
    public void periodic(){
        logger.info("Belt Motor Speed" + b_motor.get());
    }

    public void setSpeed(double speed){
        b_motor.set(speed);
    }
    public void backup(){
        initTime = Timer.getFPGATimestamp();
        while (Timer.getFPGATimestamp()- initTime <= b_backup){
            b_motor.set(-speed);
        }
   
    b_motor.set(0);
    }

    public void stop(){
        b_motor.stopMotor();
    }

   
}