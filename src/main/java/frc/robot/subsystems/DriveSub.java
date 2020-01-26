/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class DriveSub extends SubsystemBase {
  /**
   * Creates a new DriveSub.
   */
  public DriveSub() {

  }

  public void vroom(double speed, double rotation){

    if(RobotContainer.da.get()){
      RobotContainer.frontLeft.set(0.5);
    }else if(RobotContainer.db.get()){
      RobotContainer.frontRight.set(0.5);
    }else if(RobotContainer.dx.get()){
      RobotContainer.backLeft.set(0.5);
    }else if(RobotContainer.dy.get()){
      RobotContainer.backRight.set(0.5);
    }else{
      RobotContainer.diffDrive.arcadeDrive(speed, rotation);
    }
    //Math.sqrt(speed), Math.sqrt(rotation);
    // RobotContainer.diffDrive.arcadeDrive(speed, rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
