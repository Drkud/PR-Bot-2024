package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Modules.FrisbeeLauncher.FrisbeeLauncher;

public class SetFeederSpeed extends Command {

  FrisbeeLauncher frisbeeLauncher;
  double speed = 0.2;

  public SetFeederSpeed(FrisbeeLauncher frisbeeLauncher) {
    this.frisbeeLauncher = frisbeeLauncher;
    addRequirements(frisbeeLauncher);
  }

  public SetFeederSpeed(FrisbeeLauncher frisbeeLauncher, double speed) {
    this.frisbeeLauncher = frisbeeLauncher;
    this.speed = speed;
    addRequirements(frisbeeLauncher);
  }

  @Override
  public void initialize() {
    
  }

  @Override
  public void execute() {
    frisbeeLauncher.setFeederPower(speed);
  }

  @Override
  public void end(boolean interrupted) {
    frisbeeLauncher.setFeederPower(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
