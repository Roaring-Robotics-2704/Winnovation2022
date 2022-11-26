// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Accel extends SubsystemBase {

  private Accelerometer accelerometer = new BuiltInAccelerometer();

  /** Creates a new CollisionDetection. */
  public Accel() {}
  double prevXAccel = 0;
  double prevYAccel = 0;
  double prevZAccel = 0;
  double sumJerk = 0;

  @Override
  public void periodic() {
    double xAccel = accelerometer.getX();
    double yAccel = accelerometer.getY();
    double zAccel = accelerometer.getZ();
    
    // Calculates the jerk in the X and Y directions
    // Divides by .02 because default loop timing is 20ms
    double xJerk = (xAccel - prevXAccel)/.02;
    double yJerk = (yAccel - prevYAccel)/.02;
    double zJerk = (zAccel - prevZAccel)/.02;

    prevXAccel = xAccel;
    prevYAccel = yAccel;
    prevZAccel = zAccel;

    sumJerk = Math.cbrt(xJerk*xJerk + yJerk*yJerk + zJerk*zJerk);//c=sqrt(a^2+b^2)
    RobotContainer.xbox.setRumble(RumbleType.kLeftRumble, sumJerk);
    RobotContainer.xbox.setRumble(RumbleType.kRightRumble, sumJerk);
    
  }

  public double getJerk(){
    return sumJerk;
  }
}
