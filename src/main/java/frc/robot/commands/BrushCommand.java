// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Constants;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class BrushCommand extends CommandBase {
  /** Creates a new Input. */
  public BrushCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Brush);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_Brush.setspeed(RobotContainer.xbox.getRawAxis(Constants.RightTrigger)-RobotContainer.xbox.getRawAxis(Constants.LeftTrigger));
    //  boolean button = RobotContainer.xbox.getAButton();
    //  if(button = true){
    //    RobotContainer.m_Brush.setspeed(1);
    //  }
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
