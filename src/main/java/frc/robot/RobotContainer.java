package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
// import frc.robot.commands.FlywheelSpeed;
import frc.robot.commands.Prime;
import frc.robot.commands.SetFeederSpeed;
import frc.robot.commands.SetFlyWheelSpeed;
import frc.robot.commands.TShirtShootMotor;
import frc.robot.commands.TankDrive;
import frc.robot.commands.TiltCanon;
import frc.robot.commands.TiltMotor;
import frc.robot.commands.ToggleSolenoid;
import frc.robot.controller.Xbox;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Modules.FrisbeeLauncher.FrisbeeLauncher;
import frc.robot.subsystems.Modules.TShirtCannon.TShirtCannon;

public class RobotContainer {
  
  public final Drivetrain drivepain = new Drivetrain();
   private final TShirtCannon tShirtCannon = new TShirtCannon();
  //private final FrisbeeLauncher frisbeeLauncher = new FrisbeeLauncher();
   private final TiltMotor tiltMotor = new TiltMotor();
  private final Xbox driverController = new Xbox(Constants.DRIVER_CONTROLLER_PORT);

  public RobotContainer() {
    configureButtonBindings();

    drivepain.setDefaultCommand(new TankDrive(drivepain, driverController));
    //rivepain.setDefaultCommand(new ArcadeDrive(drivepain, driverController));

     tiltMotor.setDefaultCommand(new TiltCanon(driverController, tiltMotor));

     ToggleSolenoid command = new ToggleSolenoid(tShirtCannon, Constants.PRIMER_CANNON_SOLENOID);

//    frisbeeLauncher.setDefaultCommand(new FlywheelSpeed(driverController));
    // frisbeeLauncher.setDefaultCommand(new SetFlyWheelSpeed(frisbeeLauncher, driverController));
  }

  private void configureButtonBindings() {

    /* ---------- T-Shirt Cannon ---------- */

      driverController.getButton(Xbox.A)
       .onTrue(new Prime(tShirtCannon));


       
      driverController.getButton(Xbox.B)
       .onTrue(new TShirtShootMotor(tShirtCannon));

    
    
    /* ---------- Frisbee Launcher ---------- */
    // THIS CODE WAS DONE ON JUNE 2 LOL
    // Blue tape -> Feeder Wheel

   //driverController.getButton(Xbox.Y)
     //   .whenPressed(new SetFeederSpeed(frisbeeLauncher, 0.3))
       // .whenReleased(new SetFeederSpeed(frisbeeLauncher, 0.0));

   //    driverController.getButton(Xbox.Y)
     //   .whenPressed(() -> frisbeeLauncher.setFeederPower(0.3))
       // .whenReleased(() -> frisbeeLauncher.setFeederPower(0.0));

      //driverController.getButton(Xbox.A)
      //.whenPressed(() -> frisbeeLauncher.setLauncherPower(-0.5))
     //.whenReleased(() -> frisbeeLauncher.setLauncherPower(0.0));

  }

  public Command getAutonomousCommand() {
    return null;
  }
}
