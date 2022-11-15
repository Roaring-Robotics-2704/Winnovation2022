// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  //Drive Train Motors
  private WPI_VictorSPX m_rightMotor = new WPI_VictorSPX(Constants.c_rightDriveMotor);
  private WPI_VictorSPX m_leftMotor = new WPI_VictorSPX(Constants.c_leftDriveMotor);

  private DifferentialDrive drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  public Drivetrain() {
  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
