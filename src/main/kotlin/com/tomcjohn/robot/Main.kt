package com.tomcjohn.robot

import com.tomcjohn.robot.domain.Position
import com.tomcjohn.robot.domain.Robot
import com.tomcjohn.robot.domain.Table
import java.io.File

fun main() {
    val table = Table(Position(0,0), Position(5,5))
    val cmds: List<String> = File("robot-test.in").readLines()

    var robot: Robot? = null
    for (cmd in cmds) {
        robot = table.doCommand(cmd, robot)
    }
}
