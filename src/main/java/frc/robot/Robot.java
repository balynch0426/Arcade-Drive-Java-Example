/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//imports are done automatically or with the yellow lightbulb

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the DifferentialDrive class.
 * Runs the motors with arcade steering.
 */
public class Robot extends TimedRobot {

  /**
   * The WPI_TalonFX class comes from the Phoenix Framework and is used to declare
   * TalonFX motor controllers by using CAN instead of PWM. The number inside
   * the parentheses is the CAN id that you set earlier. 
   * 
   * It does not have to be WPI_TalonFX's, they can be any motor controller
   * class, so long as it is imported.
   * 
   * The numbers can change to be any value within 0-63, just make sure you set
   * the device to have that ID in the tuner
   */
  private final WPI_TalonFX frontLeftDrive = new WPI_TalonFX(1); //the front left motor
  private final WPI_TalonFX backLeftDrive = new WPI_TalonFX(2); //the back left motor
  private final WPI_TalonFX frontRightDrive = new WPI_TalonFX(3); //the front right motor
  private final WPI_TalonFX backRightDrive = new WPI_TalonFX(4); //the back right motor
  /**
   * The SpeedController group class works with all motor controller types
   * and is used to group together multiple motors into a single left or right side
   * 
   * This allows for all the motors to be put into the Drive Train, not just 2.
   */
  private final SpeedController leftDrive = new SpeedControllerGroup(frontLeftDrive, backLeftDrive);
  private final SpeedController rightDrive = new SpeedControllerGroup(frontRightDrive, backRightDrive);
  /**
   * DifferentialDrive is a method that basically holds all the motors together so they can
   * be activated in unison. 
   */
  private final DifferentialDrive driveTrain = new DifferentialDrive(leftDrive, rightDrive);
  /**
   * Joystick is a class that represents an Xbox Controller. The number refers to the
   * USB port it is plugged in on the driver station
   */
  private final Joystick drivingController = new Joystick(0);

  @Override
  public void teleopPeriodic() {
    /**
     * Drive with arcade drive.
     * That means that the Y axis drives forward
     * and backward, and the X turns left and right.
     * Y is negative because down is +1, but we want down to be -1
     */
    driveTrain.arcadeDrive(-drivingController.getY(Hand.kRight), drivingController.getX(Hand.kLeft));
  }
}
