//package edu.wpi.first.wpilibj;
package frc.robot;
public interface SpeedController {
    void set(double speed);
    double get();
    void setInverted(boolean isInverted);
    boolean getInverted();
    void disable();
    void stopMotor();
}