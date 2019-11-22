package com.first1444.dashboard.shuffleboard

/**
 * The importance of an event marker in Shuffleboard.  The exact meaning of each importance level is
 * up for interpretation on a team-to-team basis, but users should follow the general guidelines
 * of the various importance levels.  The examples given are for reference and may be ignored or
 * considered to be more or less important from team to team.
 */
enum class EventImportance (val simpleName: String) {
    // Maintainer note: this enum is mirrored in WPILibC and in Shuffleboard
    // Modifying the enum or enum strings requires a corresponding change to the C++ enum
    // and the enum in Shuffleboard

    /**
     * A trivial event such as a change in command state.
     */
    TRIVIAL("TRIVIAL"),

    /**
     * A low importance event such as acquisition of a game piece.
     */
    LOW("LOW"),

    /**
     * A "normal" importance event, such as a transition from autonomous mode to teleoperated control.
     */
    NORMAL("NORMAL"),

    /**
     * A high-importance event such as scoring a game piece.
     */
    HIGH("HIGH"),

    /**
     * A critically important event such as a brownout, component failure, or software deadlock.
     */
    CRITICAL("CRITICAL")
}