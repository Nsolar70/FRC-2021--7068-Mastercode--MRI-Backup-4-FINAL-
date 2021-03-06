/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

//import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.StopperMotor;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ManualyShoot extends SequentialCommandGroup {
  /**
   * Creates a new ManualyShoot.
   */
  public ManualyShoot(FlyWheel m_flyWheel, Indexer m_indexer, StopperMotor m_stopperMotor) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();
    super(
        new RunFlyWheel(m_flyWheel,false).withTimeout(1),
        parallel(
        new RunFlyWheel(m_flyWheel,true),
        new autoShootIndexer(m_indexer),
        new RunStopperMotor (m_stopperMotor)
        )
    );

    
  }
}
