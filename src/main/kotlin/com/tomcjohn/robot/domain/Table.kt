package com.tomcjohn.robot.domain

class Table(private val bottomLeft: Position, private val topRight: Position) {

    fun doCommand(cmd: String, robot: Robot?): Robot? {
        val splitCmd = cmd.split(" ")

        if (robot == null) {
            return if (splitCmd[0] == "PLACE") {
                val placeArgs = splitCmd[1].split(",")
                val newPos = Position(placeArgs[0].toInt(), placeArgs[1].toInt())
                val newDir = Direction.valueOf(placeArgs[2])
                val newRobot = Robot(newPos, newDir)
                if (onTable(newRobot)) newRobot else robot
            } else {
                robot
            }
        } else {
            return when (splitCmd[0]) {
                "PLACE" -> {
                    val placeArgs = splitCmd[1].split(",")
                    val newPos = Position(placeArgs[0].toInt(), placeArgs[1].toInt())
                    val newDir = Direction.valueOf(placeArgs[2])
                    val newRobot = Robot(newPos, newDir)
                    if (onTable(newRobot)) newRobot else robot
                }
                "MOVE" -> {
                    val newRobot = robot.move()
                    if (onTable(newRobot)) newRobot else robot
                }
                "LEFT" -> robot.left()
                "RIGHT" -> robot.right()
                "REPORT" -> robot.report()

                else -> {
                    println("Unrecognised command: $cmd")
                    robot
                }
            }
        }
    }

    private fun onTable(r: Robot): Boolean {
        return r.position.x >= bottomLeft.x && r.position.x <= topRight.x &&
                r.position.y >= bottomLeft.y && r.position.y <= topRight.y
    }
}
