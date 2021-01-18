package com.tomcjohn.robot

import com.tomcjohn.robot.domain.Direction.*
import com.tomcjohn.robot.domain.Position
import com.tomcjohn.robot.domain.Robot
import com.tomcjohn.robot.domain.Table
// import java.io.File

fun main() {
//    val lines: List<String> = File("robot-test.in").readLines()

    val t = Table(Position(0,0), Position(9,9))
    val r = Robot(Position(3,3), NORTH)
    val cmds: List<String> = arrayListOf("PLACE 1,3,NORTH", "REPORT", "RIGHT", "MOVE", "SDSD", "LEFT", "MOVE", "REPORT")
    cmds.map({ cmd -> t.doCommand(cmd, r) })
    println("Goodbye, world!")
}
