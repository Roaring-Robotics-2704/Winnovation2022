// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;


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
    SmartDashboard.setDefaultBoolean("Enable Dance Mode", true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double joystickLeft = RobotContainer.xbox.getRawAxis(1);
    double joystickRight = RobotContainer.xbox.getRawAxis(5);

    double joystickTotal = Math.abs(joystickLeft)+Math.abs(joystickRight);
    SmartDashboard.putNumber("joystickTotal",joystickTotal);

    double timerValue = danceTime.get();
    SmartDashboard.putNumber("timerValue",timerValue);

    double timerRemainder = Math.IEEEremainder(timerValue,1);
    SmartDashboard.putNumber("timerRemainder",timerRemainder);


    /*if(joystickTotal<0.05 && RobotContainer.xbox.getRawButton(Constants.c_leftBumper)) {
      if(timerRemainder<0){ //every half a second, switch modes
        joystickLeft = Constants.danceSpeed;
        joystickRight = -Constants.danceSpeed;
      }
      else{
        joystickLeft = -Constants.danceSpeed;
        joystickRight = Constants.danceSpeed;
      }

    }*/

    if(joystickTotal<0.05&&RobotContainer.danceChooser.getSelected()){//if joysticks not used and not disabled in smartDashboard
      if(timerRemainder<0){ //every half a second, switch modes
        joystickLeft = Constants.danceSpeed;
        joystickRight = -Constants.danceSpeed;
      }
      else{
        joystickLeft = -Constants.danceSpeed;
        joystickRight = Constants.danceSpeed;
      }
    }
    SmartDashboard.putNumber("joystickLeft", joystickLeft);
    SmartDashboard.putNumber("joystickRight", joystickRight);

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
