// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Modules.TShirtCannon;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TShirtCannon extends SubsystemBase {

  Solenoid cannonValve, primerValve;
  TalonSRX jankySolenoid, light;
  public boolean lightStatus = false;

  /** Creates a new TShirtCannon. */
  public TShirtCannon() {
    this.light = new TalonSRX(Constants.MOTOR_FOR_LIGHT); //new Solenoid(PneumaticsModuleType.CTREPCM, Constants.PNEUMATIC_LIGHT);
    this.cannonValve = new Solenoid(PneumaticsModuleType.CTREPCM,Constants.T_SHIRT_CANNON_SOLENOID);
    this.primerValve = new Solenoid(PneumaticsModuleType.CTREPCM,Constants.PRIMER_CANNON_SOLENOID);
    this.jankySolenoid = new TalonSRX(Constants.MOTOR_FOR_PIM);

    primerValve.set(false);

  }

  public void setPower(double power) {
    jankySolenoid.set(ControlMode.PercentOutput, power);
  }

  public void setLight(boolean status) {
    if (status) {
      light.set(ControlMode.PercentOutput, 100);
      lightStatus = true;
    }else {
      light.set(ControlMode.PercentOutput, 0);
      lightStatus = false;
    }
  }

  

  public void toggle(int id) {

    if (Constants.PRIMER_CANNON_SOLENOID == id) {
      System.out.println("Toggling - 2");
      primerValve.toggle();
    } if (Constants.T_SHIRT_CANNON_SOLENOID == id) {
      System.out.println("Toggling - 0");
      cannonValve.toggle();
      }
    }
  

  @Override
  public void periodic() {}
}
