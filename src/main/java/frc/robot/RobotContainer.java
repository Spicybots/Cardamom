/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public static WPI_VictorSPX frontRight = new WPI_VictorSPX(3);
  public static WPI_VictorSPX frontLeft = new WPI_VictorSPX(2);
  public static WPI_VictorSPX backRight = new WPI_VictorSPX(1);
  public static WPI_VictorSPX backLeft = new WPI_VictorSPX(0);

  public static SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);
  public static SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);

  public static DifferentialDrive diffDrive = new DifferentialDrive(left, right);

  public static Compressor compressor = new Compressor(0);

  public static WPI_VictorSPX shootwheel = new WPI_VictorSPX(63);

  public static Joystick ogey = new Joystick(0);
  public static JoystickButton da = new JoystickButton(ogey, 1);
  public static JoystickButton db = new JoystickButton(ogey, 2);
  public static JoystickButton dx = new JoystickButton(ogey, 3);
  public static JoystickButton dy = new JoystickButton(ogey, 4);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    Robot.spinMotorSub.setDefaultCommand(new RunCommand(() -> Robot.spinMotorSub.spinMotor(1), Robot.spinMotorSub));
    Robot.drivesub.setDefaultCommand(new RunCommand(() -> Robot.drivesub.vroom(ogey.getRawAxis(1),ogey.getRawAxis(4)), Robot.drivesub));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
;   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
