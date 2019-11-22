package com.first1444.dashboard.shuffleboard.types

/**
 * The types of the widgets bundled with Shuffleboard.
 *
 *
 * For example, setting a number to be displayed with a slider:
 * <pre>`NetworkTableEntry example = Shuffleboard.getTab("My Tab")
 * .add("My Number", 0)
 * .withWidget(BuiltInWidgets.kNumberSlider)
 * .withProperties(Map.of("min", 0, "max", 1))
 * .getEntry();
`</pre> *
 *
 *
 * Each value in this enum goes into detail on what data types that widget can support, as well
 * as the custom properties that widget uses.
 */
enum class BuiltInWidgets (override val widgetName: String) : WidgetType {
    /**
     * Displays a value with a simple text field.
     * <br></br>Supported types:
     *
     *  * String
     *  * Number
     *  * Boolean
     *
     * <br></br>This widget has no custom properties.
     */
    TEXT_VIEW("Text View"),
    /**
     * Displays a number with a controllable slider.
     * <br></br>Supported types:
     *
     *  * Number
     *
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Min</td><td>Number</td><td>-1.0</td><td>The minimum value of the slider</td></tr>
     * <tr><td>Max</td><td>Number</td><td>1.0</td><td>The maximum value of the slider</td></tr>
     * <tr><td>Block increment</td><td>Number</td><td>0.0625</td>
     * <td>How much to move the slider by with the arrow keys</td></tr>
    </table> *
     */
    NUMBER_SLIDER("Number Slider"),
    /**
     * Displays a number with a view-only bar.
     * <br></br>Supported types:
     *
     *  * Number
     *
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Min</td><td>Number</td><td>-1.0</td><td>The minimum value of the bar</td></tr>
     * <tr><td>Max</td><td>Number</td><td>1.0</td><td>The maximum value of the bar</td></tr>
     * <tr><td>Center</td><td>Number</td><td>0</td><td>The center ("zero") value of the bar</td></tr>
    </table> *
     */
    NUMBER_BAR("Number Bar"),
    /**
     * Displays a number with a view-only dial. Displayed values are rounded to the nearest integer.
     * <br></br>Supported types:
     *
     *  * Number
     *
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Min</td><td>Number</td><td>0</td><td>The minimum value of the dial</td></tr>
     * <tr><td>Max</td><td>Number</td><td>100</td><td>The maximum value of the dial</td></tr>
     * <tr><td>Show value</td><td>Boolean</td><td>true</td>
     * <td>Whether or not to show the value as text</td></tr>
    </table> *
     */
    DIAL("Simple Dial"),
    /**
     * Displays a number with a graph. **NOTE:** graphs can be taxing on the computer
     * running the dashboard. Keep the number of visible data points to a minimum. Making the widget
     * smaller also helps with performance, but may cause the graph to become difficult to read.
     * <br></br>Supported types:
     *
     *  * Number
     *  * Number array
     *
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Visible time</td><td>Number</td><td>30</td>
     * <td>How long, in seconds, should past data be visible for</td></tr>
    </table> *
     */
    GRAPH("Graph"),
    /**
     * Displays a boolean value as a large colored box.
     * <br></br>Supported types:
     *
     *  * Boolean
     *
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Color when true</td><td>Color</td><td>"green"</td>
     * <td>Can be specified as a string (`"#00FF00"`) or a rgba integer (`0x00FF0000`)
    </td></tr> *
     * <tr><td>Color when false</td><td>Color</td><td>"red"</td>
     * <td>Can be specified as a string or a number</td></tr>
    </table> *
     */
    BOOLEAN_BOX("Boolean Box"),
    /**
     * Displays a boolean with a large interactive toggle button.
     * <br></br>Supported types:
     *
     *  * Boolean
     *
     * <br></br>This widget has no custom properties.
     */
    TOGGLE_BUTTON("Toggle Button"),
    /**
     * Displays a boolean with a fixed-size toggle switch.
     * <br></br>Supported types:
     *
     *  * Boolean
     *
     * <br></br>This widget has no custom properties.
     */
    TOGGLE_SWITCH("Toggle Switch"),
    /**
     * Displays an analog input or a raw number with a number bar.
     * <br></br>Supported types:
     *
     *  * Number
     *  * [edu.wpi.first.wpilibj.AnalogInput]
     *
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Min</td><td>Number</td><td>0</td><td>The minimum value of the bar</td></tr>
     * <tr><td>Max</td><td>Number</td><td>5</td><td>The maximum value of the bar</td></tr>
     * <tr><td>Center</td><td>Number</td><td>0</td><td>The center ("zero") value of the bar</td></tr>
     * <tr><td>Orientation</td><td>String</td><td>"HORIZONTAL"</td>
     * <td>The orientation of the bar. One of `["HORIZONTAL", "VERTICAL"]`</td></tr>
     * <tr><td>Number of tick marks</td><td>Number</td><td>5</td>
     * <td>The number of discrete ticks on the bar</td></tr>
    </table> *
     */
    VOLTAGE_VIEW("Voltage View"),
    /**
     * Displays a [PowerDistributionPanel][edu.wpi.first.wpilibj.PowerDistributionPanel].
     * <br></br>Supported types:
     *
     *  * [edu.wpi.first.wpilibj.PowerDistributionPanel]
     *
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Show voltage and current values</td><td>Boolean</td><td>true</td>
     * <td>Whether or not to display the voltage and current draw</td></tr>
    </table> *
     */
    POWER_DISTRIBUTION_PANEL("PDP"),
    /**
     * Displays a [SendableChooser][edu.wpi.first.wpilibj.smartdashboard.SendableChooser] with
     * a dropdown combo box with a list of options.
     * <br></br>Supported types:
     *
     *  * [edu.wpi.first.wpilibj.smartdashboard.SendableChooser]
     *
     * <br></br>This widget has no custom properties.
     */
    COMBO_BOX_CHOOSER("ComboBox Chooser"),
    /**
     * Displays a [SendableChooser][edu.wpi.first.wpilibj.smartdashboard.SendableChooser] with
     * a toggle button for each available option.
     * <br></br>Supported types:
     *
     *  * [edu.wpi.first.wpilibj.smartdashboard.SendableChooser]
     *
     * <br></br>This widget has no custom properties.
     */
    SPLIT_BUTTON_CHOOSER("Split Button Chooser"),
    /**
     * Displays an [edu.wpi.first.wpilibj.Encoder] displaying its speed, total travelled
     * distance, and its distance per tick.
     * <br></br>Supported types:
     *
     *  * [edu.wpi.first.wpilibj.Encoder]
     *
     * <br></br>This widget has no custom properties.
     */
    ENCODER("Encoder"),
    /**
     * Displays a [SpeedController][edu.wpi.first.wpilibj.SpeedController]. The speed controller
     * will be controllable from the dashboard when test mode is enabled, but will otherwise be
     * view-only.
     * <br></br>Supported types:
     *
     *  * [edu.wpi.first.wpilibj.PWMSpeedController]
     *  * [edu.wpi.first.wpilibj.DMC60]
     *  * [edu.wpi.first.wpilibj.Jaguar]
     *  * [edu.wpi.first.wpilibj.PWMTalonSRX]
     *  * [edu.wpi.first.wpilibj.PWMVictorSPX]
     *  * [edu.wpi.first.wpilibj.SD540]
     *  * [edu.wpi.first.wpilibj.Spark]
     *  * [edu.wpi.first.wpilibj.Talon]
     *  * [edu.wpi.first.wpilibj.Victor]
     *  * [edu.wpi.first.wpilibj.VictorSP]
     *  * [edu.wpi.first.wpilibj.SpeedControllerGroup]
     *
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Orientation</td><td>String</td><td>"HORIZONTAL"</td>
     * <td>One of `["HORIZONTAL", "VERTICAL"]`</td></tr>
    </table> *
     */
    SPEED_CONTROLLER("Speed Controller"),
    /**
     * Displays a command with a toggle button. Pressing the button will start the command, and the
     * button will automatically release when the command completes.
     * <br></br>Supported types:
     *
     *  * [edu.wpi.first.wpilibj.command.Command]
     *  * [edu.wpi.first.wpilibj.command.CommandGroup]
     *  * Any custom subclass of `Command` or `CommandGroup`
     *
     * <br></br>This widget has no custom properties.
     */
    COMMAND("Command"),
    /**
     * Displays a PID command with a checkbox and an editor for the PIDF constants. Selecting the
     * checkbox will start the command, and the checkbox will automatically deselect when the command
     * completes.
     * <br></br>Supported types:
     *
     *  * [edu.wpi.first.wpilibj.command.PIDCommand]
     *  * Any custom subclass of `PIDCommand`
     *
     * <br></br>This widget has no custom properties.
     */
    PID_COMMAND("PID Command"),
    /**
     * Displays a PID controller with an editor for the PIDF constants and a toggle switch for
     * enabling and disabling the controller.
     * <br></br>Supported types:
     *
     *  * [edu.wpi.first.wpilibj.PIDController]
     *
     * <br></br>This widget has no custom properties.
     */
    PID_CONTROLLER("PID Controller"),
    /**
     * Displays an accelerometer with a number bar displaying the magnitude of the acceleration and
     * text displaying the exact value.
     * <br></br>Supported types:
     *
     *  * [edu.wpi.first.wpilibj.AnalogAccelerometer]
     *
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Min</td><td>Number</td><td>-1</td>
     * <td>The minimum acceleration value to display</td></tr>
     * <tr><td>Max</td><td>Number</td><td>1</td>
     * <td>The maximum acceleration value to display</td></tr>
     * <tr><td>Show text</td><td>Boolean</td><td>true</td>
     * <td>Show or hide the acceleration values</td></tr>
     * <tr><td>Precision</td><td>Number</td><td>2</td>
     * <td>How many numbers to display after the decimal point</td></tr>
     * <tr><td>Show tick marks</td><td>Boolean</td><td>false</td>
     * <td>Show or hide the tick marks on the number bars</td></tr>
    </table> *
     */
    kAccelerometer("Accelerometer"),
    /**
     * Displays a 3-axis accelerometer with a number bar for each axis' accleration.
     * <br></br>Supported types:
     *
     *  * [edu.wpi.first.wpilibj.ADXL345_I2C]
     *  * [edu.wpi.first.wpilibj.ADXL345_SPI]
     *  * [edu.wpi.first.wpilibj.ADXL362]
     *
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Range</td><td>[Range]</td><td>k16G</td><td>The accelerometer range</td></tr>
     * <tr><td>Show value</td><td>Boolean</td><td>true</td>
     * <td>Show or hide the acceleration values</td></tr>
     * <tr><td>Precision</td><td>Number</td><td>2</td>
     * <td>How many numbers to display after the decimal point</td></tr>
     * <tr><td>Show tick marks</td><td>Boolean</td><td>false</td>
     * <td>Show or hide the tick marks on the number bars</td></tr>
    </table> *
     */
    THREE_AXIS_ACCELEROMETER("3-Axis Accelerometer"),
    /**
     * Displays a gyro with a dial from 0 to 360 degrees.
     * <br></br>Supported types:
     *
     *  * [edu.wpi.first.wpilibj.ADXRS450_Gyro]
     *  * [edu.wpi.first.wpilibj.AnalogGyro]
     *  * Any custom subclass of `GyroBase` (such as a MXP gyro)
     *
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Major tick spacing</td><td>Number</td><td>45</td><td>Degrees</td></tr>
     * <tr><td>Starting angle</td><td>Number</td><td>180</td>
     * <td>How far to rotate the entire dial, in degrees</td></tr>
     * <tr><td>Show tick mark ring</td><td>Boolean</td><td>true</td></tr>
    </table> *
     */
    GYRO("Gyro"),
    /**
     * Displays a relay with toggle buttons for each supported mode (off, on, forward, reverse).
     * <br></br>Supported types:
     *
     *  * [edu.wpi.first.wpilibj.Relay]
     *
     * <br></br>This widget has no custom properties.
     */
    RELAY("Relay"),
    /**
     * Displays a differential drive with a widget that displays the speed of each side of the
     * drivebase and a vector for the direction and rotation of the drivebase. The widget will be
     * controllable if the robot is in test mode.
     * <br></br>Supported types:
     *
     *  * [edu.wpi.first.wpilibj.drive.DifferentialDrive]
     *
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Number of wheels</td><td>Number</td><td>4</td><td>Must be a positive even integer
    </td></tr> *
     * <tr><td>Wheel diameter</td><td>Number</td><td>80</td><td>Pixels</td></tr>
     * <tr><td>Show velocity vectors</td><td>Boolean</td><td>true</td></tr>
    </table> *
     */
    DIFFERENTIAL_DRIVE("Differential Drivebase"),
    /**
     * Displays a mecanum drive with a widget that displays the speed of each wheel, and vectors for
     * the direction and rotation of the drivebase. The widget will be controllable if the robot is
     * in test mode.
     * <br></br>Supported types:
     *
     *  * [edu.wpi.first.wpilibj.drive.MecanumDrive]
     *
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Show velocity vectors</td><td>Boolean</td><td>true</td></tr>
    </table> *
     */
    MECANUM_DRIVE("Mecanum Drivebase"),
    /**
     * Displays a camera stream.
     * <br></br>Supported types:
     *
     *  * [edu.wpi.cscore.VideoSource] (as long as it is streaming on an MJPEG server)
     *
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Show crosshair</td><td>Boolean</td><td>true</td>
     * <td>Show or hide a crosshair on the image</td></tr>
     * <tr><td>Crosshair color</td><td>Color</td><td>"white"</td>
     * <td>Can be a string or a rgba integer</td></tr>
     * <tr><td>Show controls</td><td>Boolean</td><td>true</td><td>Show or hide the stream controls
    </td></tr> *
     * <tr><td>Rotation</td><td>String</td><td>"NONE"</td>
     * <td>Rotates the displayed image. One of `["NONE", "QUARTER_CW", "QUARTER_CCW", "HALF"]`
    </td></tr> *
    </table> *
     */
    CAMERA_STREAM("Camera Stream")
}