// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ActuatorConstants;

public class StopperMotor extends SubsystemBase {

  private final WPI_VictorSPX stopperMotor = new WPI_VictorSPX(ActuatorConstants.kStopperMotor);

  private double setSpeed;
  final String shootSpeed = "Shoot Speed";
  final double SpeedShoot = 0.2;
  
  /** Creates a new StopperMotor. */
  public StopperMotor() {

    stopperMotor.setInverted(true);
    stopperMotor.setNeutralMode(NeutralMode.Brake);

   
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  private void RunMotors(double speed) {
    stopperMotor.set(speed);

   }

   // Run
  public void RunStopper() {
    //Stop indexer motion
    double backup = SpeedShoot;
    setSpeed = getPreferencesDouble(shootSpeed, backup);
    setSpeed = setSpeed * 1;
    stopperMotor.set(setSpeed);

  }

   public void StopMotion() {
    stopperMotor.set(0.0);
}
private static double getPreferencesDouble(final String key, final double backup) {
  final Preferences preferences = Preferences.getInstance();
  if(!preferences.containsKey(key)) {
    preferences.putDouble(key, backup);
  }
  return preferences.getDouble(key, backup);
  }
}