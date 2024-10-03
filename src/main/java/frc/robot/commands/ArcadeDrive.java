// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.controller.Xbox;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends Command {
  Drivetrain drivepain;
  Xbox controller;
  /** Creates a new Drive. */
  public ArcadeDrive(Drivetrain drivepain, Xbox controller) {
    this.drivepain = drivepain;
    this.controller = controller;
    addRequirements(drivepain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivepain.setLeftPower((controller.getRightStickY() - controller.getRightStickX()) * 0.8);
    drivepain.setRightPower((controller.getRightStickY() + controller.getRightStickX()) * 0.85);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivepain.setRightPower(0);
    drivepain.setLeftPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
