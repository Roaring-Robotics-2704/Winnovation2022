// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import frc.robot.RobotContainer;

public class Brush extends SubsystemBase {
  /** Creates a new Brush. */
  public Brush() {}

  private WPI_VictorSPX m_brushMotor = new WPI_VictorSPX(Constants.c_brushMotor);

  //double rightTrigger = RobotContainer.xbox.getRawAxis(Constants.RightTrigger);
  public double rightTrigger;
  public double leftTrigger;
  //double leftTrigger = RobotContainer.xbox.getRawAxis(Constants.LeftTrigger);
  public double triggerValue;


  // currently works as a press-and-hold Y button to stop the brush motor, will fix to be a toggle later


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
   
   
  }

  public void spinbrush() {

    System.out.println("print me");
    
    rightTrigger = RobotContainer.xbox.getRawAxis(Constants.RightTrigger);
    leftTrigger = RobotContainer.xbox.getRawAxis(Constants.LeftTrigger);
    triggerValue = (rightTrigger + leftTrigger)/2;

    if(triggerValue == 0){
      m_brushMotor.set(Constants.c_constantIntakeSpeed);
      System.out.println("constant 0");
   }
     else if(triggerValue > 0 && triggerValue <= Constants.c_constantIntakeSpeed){
     m_brushMotor.set(Constants.c_constantIntakeSpeed);
     System.out.println("case 1");
   }
    else{
     m_brushMotor.set(triggerValue);
     System.out.println("case 2");
   }
  }

  public void setspeed(double speed) {
    m_brushMotor.set(speed);
  }

  public void outtakeSlow() {
    m_brushMotor.set(Constants.c_lowOuttakeSpeed);
  }

  public void outtakeMedium() {
    m_brushMotor.set(Constants.c_mediumOuttakeSpeed);
  }

  public void outtakeFast() {
    m_brushMotor.set(Constants.c_highOuttakeSpeed);
  }




  public void stopbrush() {
    m_brushMotor.set(0);
  }


}
