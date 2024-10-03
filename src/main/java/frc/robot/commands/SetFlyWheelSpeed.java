package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.controller.Xbox;
import frc.robot.subsystems.Modules.FrisbeeLauncher.FrisbeeLauncher;

public class SetFlyWheelSpeed extends Command {
  FrisbeeLauncher frisbeeLauncher;
  Xbox driver;

  public SetFlyWheelSpeed(FrisbeeLauncher frisbeeLauncher, Xbox driver) {
    this.frisbeeLauncher = frisbeeLauncher;
    this.driver = driver;
    addRequirements(frisbeeLauncher);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    if (driver.getRawAxis(Xbox.RT) > 0.1) {
      frisbeeLauncher.setLauncherPower(0.6);
      // frisbeeLauncher.setLauncherPower(frisbeeLauncher.globalFlywheelSpeed);
    } else {
      frisbeeLauncher.setLauncherPower(0.0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    frisbeeLauncher.setLauncherPower(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
