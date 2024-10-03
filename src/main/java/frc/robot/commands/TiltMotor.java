// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//This is a part of the t-shirt cannon, but it is implemented as a separate subsystem.
//Probably should be refactored to be a part of the TShirtCannon subsystem
public class TiltMotor extends SubsystemBase {
  //The motor isn't actually a talon, but it uses the talonSRX motor controller
  //Its called a window motor because the motor was originally used to move windows in cars
  
  private TalonSRX windowMotor;

  /** Creates a new tiltMotor. */
  public TiltMotor() {
    this.windowMotor = new TalonSRX(Constants.TILT_MOTOR);

    windowMotor.setNeutralMode(NeutralMode.Coast);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setPower(double power) {
    windowMotor.set(ControlMode.PercentOutput, power);
  }
}
