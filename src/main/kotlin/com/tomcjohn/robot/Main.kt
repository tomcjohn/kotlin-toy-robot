package com.tomcjohn.robot

import com.tomcjohn.robot.domain.Position
import com.tomcjohn.robot.domain.Robot
import com.tomcjohn.robot.domain.Table

fun main() {
    val table = Table(Position(0,0), Position(9,9))
    val cmds: List<String> = arrayListOf("PLACE 1,3,NORTH", "REPORT", "RIGHT", "PLACE 10,3,NORTH", "MOVE", "SDSD", "LEFT", "MOVE", "REPORT")

    var robot: Robot? = null
    for (cmd in cmds) {
        robot = table.doCommand(cmd, robot)
    }
}
