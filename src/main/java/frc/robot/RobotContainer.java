// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Brush;

import frc.robot.commands.DriveRobot;
import frc.robot.commands.Intake;
import frc.robot.commands.Outtake;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //Subsystems
  public static Drivetrain m_Drivetrain = new Drivetrain();
  public static Brush m_Brush = new Brush();

  //Commands
  public static DriveRobot m_DriveRobot = new DriveRobot();
  public static Intake m_Intake = new Intake();
  public static Outtake m_Outake = new Outtake();

  //OI
  public static XboxController xbox  = new XboxController(Constants.c_joystick);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    //Are nessary, if don't have m_Drivetrain.setDefaultCommand(m_DriveRobot); will give error DifferntialDrive...Output not updated often enough"
    m_Drivetrain.setDefaultCommand(m_DriveRobot);
    m_Brush.setDefaultCommand(m_Intake);
    m_Brush.setDefaultCommand(m_Outake);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //is where you put stuff like buttonName.whenPressed(new Comman());


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
 
}
