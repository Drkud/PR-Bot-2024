// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.controller.Xbox;

public class TiltCanon extends Command {
  /** Creates a new TiltCanon. */
  private Xbox driver;
  private TiltMotor motor;

  private double motorPower = 0.5;

  public TiltCanon(Xbox driver, TiltMotor motor) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(motor);
    this.driver = driver;
    this.motor = motor;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (driver.getState() == Xbox.DPAD.UP) {
      motor.setPower(motorPower);
    } else if (driver.getState() == Xbox.DPAD.DOWN) {
      motor.setPower(-motorPower);
    } else {
      motor.setPower(0.0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    motor.setPower(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
