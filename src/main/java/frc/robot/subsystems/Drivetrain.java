// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  Driveside leftSide, rightSide;
  private AHRS navx;

  public Drivetrain() {
    this.leftSide = new Driveside(Constants.LEFT_LEAD, Constants.LEFT_FOLLOWER);
    this.rightSide = new Driveside(Constants.RIGHT_LEAD, Constants.RIGHT_FOLLOWER);
    this.navx = new AHRS(SPI.Port.kMXP);

  }

  public class Driveside {

    TalonSRX lead;
    VictorSPX follower;
    
    public Driveside(int MotorIDLead, int MotorIDFollower) {
      this.lead = new TalonSRX(MotorIDLead);
      this.follower = new VictorSPX(MotorIDFollower);
      follower.follow(lead);
      lead.setInverted(true);
      lead.setNeutralMode(NeutralMode.Brake);
      
      follower.setInverted(true);
      lead.setNeutralMode(NeutralMode.Brake);
    }
    
    public void setPower(double power){
      lead.set(ControlMode.PercentOutput, power);
      follower.set(ControlMode.PercentOutput, power);
    }
    
    // 7/28
    public void setPower(double front, double back) {
      lead.set(ControlMode.PercentOutput, front);
      follower.set(ControlMode.PercentOutput, back);
    }
  }

  public void setLeftPower(double power){
    leftSide.setPower(power);
  }

  public void setRightPower(double power){
    rightSide.setPower(-power);
  }

  public double getAccelMag() {
    return Math.sqrt(Math.pow(navx.getRawAccelX(), 2) + Math.pow(navx.getRawAccelY(), 2));
  }

  @Override
  public void periodic() {
  }
} 