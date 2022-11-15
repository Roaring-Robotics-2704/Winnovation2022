// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Intake extends CommandBase {
  /** Creates a new Input. */
  public Intake() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Brush);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double rightTrigger = RobotContainer.xbox.getRawAxis(Constants.c_rightTrigger);
    double leftTrigger = RobotContainer.xbox.getRawAxis(Constants.c_leftTigger);
    double triggerValue = (rightTrigger + leftTrigger)/2;

    if(triggerValue == 0){
      RobotContainer.m_Brush.setspeed(Constants.c_constantIntakeSpeed);
    }
    else if(triggerValue > 0 && triggerValue <= Constants.c_constantIntakeSpeed){
      RobotContainer.m_Brush.setspeed(Constants.c_constantIntakeSpeed);
    }
    else{
      RobotContainer.m_Brush.setspeed(triggerValue);
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
