// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Modules.TShirtCannon.TShirtCannon;

public class LightToggle extends Command {
  private TShirtCannon cannon;
  private boolean status;
  public LightToggle(TShirtCannon cannon, boolean status) {
    this.cannon = cannon;
    this.status = status;
    addRequirements(cannon);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    cannon.setLight(status);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
