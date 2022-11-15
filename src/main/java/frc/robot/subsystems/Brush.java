// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class Brush extends SubsystemBase {
  /** Creates a new Brush. */
  public Brush() {}

  private WPI_VictorSPX m_brushMotor = new WPI_VictorSPX(Constants.c_brushMotor);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setspeed(double speed) {
    m_brushMotor.set(speed);
  }
  
}
