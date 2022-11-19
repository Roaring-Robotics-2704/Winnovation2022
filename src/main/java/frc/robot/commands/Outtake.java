// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.swing.text.StyleContext.SmallAttributeSet;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Outtake extends CommandBase {
  /** Creates a new Outtake. */
  public Outtake() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Brush);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.xbox.getRawButton(Constants.c_buttonX) == true){
      RobotContainer.m_Brush.setspeed(Constants.c_lowOuttakeSpeed);
    }
    else if(RobotContainer.xbox.getRawButton(Constants.c_buttonA) == true){
      RobotContainer.m_Brush.setspeed(Constants.c_mediumOuttakeSpeed);
    }
    else if(RobotContainer.xbox.getRawButton(Constants.c_buttonB) == true){
      RobotContainer.m_Brush.setspeed(Constants.c_highOuttakeSpeed);
    }
    else{
      RobotContainer.m_Brush.setspeed(0);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
