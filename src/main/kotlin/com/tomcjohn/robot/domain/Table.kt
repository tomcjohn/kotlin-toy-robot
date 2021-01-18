package com.tomcjohn.robot.domain

class Table(bottomLeft: Position, bottomRight: Position) {

    fun doCommand(cmd: String, robot: Robot): Robot {
        val splitCmd = cmd.split(" ")

        return when (splitCmd[0]) {
            "PLACE" -> {
                val placeArgs = splitCmd[1].split(",")
                val newPos = Position(placeArgs[0].toInt(), placeArgs[1].toInt())
                val newDir = Direction.valueOf(placeArgs[2])
                Robot(newPos, newDir)
            }
            "MOVE" -> robot.move()
            "LEFT" -> robot.left()
            "RIGHT" -> robot.right()
            "REPORT" -> robot.report()
            else -> {
                println("Unrecognised command: " + cmd)
                robot
            }
        }
    }
}
