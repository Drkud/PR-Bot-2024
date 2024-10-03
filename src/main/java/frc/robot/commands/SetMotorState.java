// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Modules.TShirtCannon.TShirtCannon;

public class SetMotorState extends Command {
  private TShirtCannon tShirtCannon;
  private boolean state;
  /** Creates a new SetMotorState. */
  public SetMotorState(TShirtCannon tShirtCannon, boolean state) {
    this.tShirtCannon = tShirtCannon;
    this.state = state;
    addRequirements(tShirtCannon);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (state) {
      tShirtCannon.setPower(1);
    } else {
      tShirtCannon.setPower(0);
    }
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
