// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveRobot extends CommandBase {
  /** Creates a new DriveRobot. */
  public DriveRobot() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Drivetrain);
  }
  Timer danceTime = new Timer();
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    danceTime.reset();
    danceTime.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double joystickLeft = RobotContainer.xbox.getRawAxis(1);
    double joystickRight = RobotContainer.xbox.getRawAxis(5);

    //For Dance Mode
    double joystickTotal = Math.abs(joystickLeft)+Math.abs(joystickRight);
    SmartDashboard.putNumber("joystickTotal",joystickTotal);

    double timerValue = danceTime.get();
    SmartDashboard.putNumber("timerValue",timerValue);

    double timerRemainder = Math.IEEEremainder(timerValue,1);
    SmartDashboard.putNumber("timerRemainder",timerRemainder);

    double danceSpeed = 0.5;
    if(joystickTotal<0.05){
      if(timerRemainder<0){ //every half a second, switch modes
        joystickLeft = danceSpeed;
        joystickRight = -danceSpeed;
      }
      else{
        joystickLeft = -danceSpeed;
        joystickRight = danceSpeed;
      }
    }
    SmartDashboard.putNumber("joystickLeft", joystickLeft);
    SmartDashboard.putNumber("joystickRight", joystickRight);

    //For Tank Drive
    RobotContainer.m_Drivetrain.tankDrive(joystickLeft, joystickRight);

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
