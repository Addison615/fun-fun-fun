package frc.robot;
//may have to change to package frc.robot;
/* 
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel.ConfigParameter;
import com.revrobotics.CANSparkMaxLowLevel.ConfigParameterType;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
*/
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
//import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
    private final CANSparkMax i_motor; //= new CANSparkMax(IntakeConstants.INTAKE_MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
    public Intake() {
        /*i_motorConfig = new CANSparkMaxConfiguration();
        i_motorConfig
            .inverted(MOTOR_INVERTED)
            .idleMode(IdleMode.kBrake)
            .smartCurrentLimit(INTAKE_CURRENT_LIMIT);
        i_motor.configure(motorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }
        */
        i_motor = new CANSparkMax(IntakeConstants.INTAKE_MOTOR_ID, MotorType.kBrushless);
        i_motor.restoreFactoryDefaults();
        i_motor.setInverted(IntakeConstants.MOTOR_INVERTED);
        i_motor.setIdleMode(IdleMode.kBrake);
        i_motor.setSmartCurrentLimit(IntakeConstants.INTAKE_CURRENT_LIMIT);
    }
    public void setRollerVoltage(double voltage) {
        i_motor.setVoltage(voltage);
    }
   /*  @Override
    public Command runRollersCommand(){
        return Commands.startEnd(
            () -> setRollerVoltage(3),
            () -> setRollerVoltage(0))
            .withName("intake.runRollers");
       
    }

    @Override
    public Command reverseRollersCommand(){
        return Commands.startEnd(
            () -> setRollerVoltage(-12),
            () -> setRollerVoltage(0))
            .withName("intake.reverseRollers");
    }
}
*/
public void setSpeed(double speed) {
    i_motor.set(speed);
}

public void stop() {
    i_motor.set(0);
}
}
// Intake {
    

