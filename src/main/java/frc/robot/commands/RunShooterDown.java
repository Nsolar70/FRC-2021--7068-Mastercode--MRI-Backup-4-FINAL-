// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.StopperMotor;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class RunShooterDown extends ParallelCommandGroup {
  /** Creates a new RunShooterDown. */
  public RunShooterDown(StopperMotor m_stopperMotor, FlyWheel m_flyWheel) {
   
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();
    super( new RunStopperMotor( m_stopperMotor),
           new RunFlyWheel(m_flyWheel, true));  
  }
}
