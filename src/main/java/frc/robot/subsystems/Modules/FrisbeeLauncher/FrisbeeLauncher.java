// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Modules.FrisbeeLauncher;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FrisbeeLauncher extends SubsystemBase {
  private TalonSRX launcher, feeder;
  public static double globalFlywheelSpeed;

  /** Creates a new FrisbeeLauncherPOG. */
  public FrisbeeLauncher() {
    this.launcher = new TalonSRX(Constants.FRISBEE_LAUNCHER);
    this.feeder = new TalonSRX(Constants.FRISBEE_FEEDER);
    launcher.setNeutralMode(NeutralMode.Coast);
    feeder.setNeutralMode(NeutralMode.Coast);
  }

  // uhh i was just looking around the code and there were problems in the other two files bc it looked like
  // these methods weren't names right... so i just went ahead and changed them

  // 7/28
  public void setLauncherPower(double power){
    launcher.set(ControlMode.PercentOutput, -power);
  }

  public void setFeederPower(double power){
    feeder.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void periodic() {}
}
