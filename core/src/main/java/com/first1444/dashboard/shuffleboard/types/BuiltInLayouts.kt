package com.first1444.dashboard.shuffleboard.types

enum class BuiltInLayouts(
        override val layoutName: String
) : LayoutType {

    /**
     * Groups components in a vertical list. New widgets added to the layout will be placed at the
     * bottom of the list.
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Label position</td><td>String</td><td>"BOTTOM"</td>
     * <td>The position of component labels inside the grid. One of
     * `["TOP", "LEFT", "BOTTOM", "RIGHT", "HIDDEN"`</td></tr>
    </table> *
     */
    LIST("List Layout"),

    /**
     * Groups components in an *n* x *m* grid. Grid layouts default to 3x3.
     * <br></br>Custom properties:
     * <table>
     * <tr><th>Name</th><th>Type</th><th>Default Value</th><th>Notes</th></tr>
     * <tr><td>Number of columns</td><td>Number</td><td>3</td><td>Must be in the range [1,15]</td>
    </tr> *
     * <tr><td>Number of rows</td><td>Number</td><td>3</td><td>Must be in the range [1,15]</td></tr>
     * <tr>
     * <td>Label position</td>
     * <td>String</td>
     * <td>"BOTTOM"</td>
     * <td>The position of component labels inside the grid.
     * One of `["TOP", "LEFT", "BOTTOM", "RIGHT", "HIDDEN"`</td>
    </tr> *
    </table> *
     */
    GRID("Grid Layout"),
    ;
}