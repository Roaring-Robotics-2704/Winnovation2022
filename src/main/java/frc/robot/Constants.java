// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int RightTrigger = 2;
    public static final int LeftTrigger = 3;
	public static final double danceSpeed = 0.25;

    public static int c_joystick = 0;
    public static final int c_rightTrigger = 2;
    public static final int c_leftTigger = 3;

    
    public static int c_buttonX =3;
    public static int c_buttonY = 4;
    public static int c_buttonA = 1;
    public static int c_buttonB = 2;

    public static int c_leftDriveMotor = 2;
    public static int c_rightDriveMotor = 1;

    public static int c_leftJoystickAxis = 5;
    public static int c_rightJoystickAxis = 1;

    public static int c_brushMotor = 3;
    public static double c_constantIntakeSpeed = 0.5;

    public static int c_stopBrushMotor = 4;

    public static double c_lowOuttakeSpeed = -0.3;
    public static double c_mediumOuttakeSpeed = -0.6;
    public static double c_highOuttakeSpeed = -1.0;
}
