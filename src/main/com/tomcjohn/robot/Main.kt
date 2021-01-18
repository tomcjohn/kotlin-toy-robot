package com.tomcjohn.robot

import com.tomcjohn.robot.domain.Direction
import com.tomcjohn.robot.domain.Position
import com.tomcjohn.robot.domain.Robot

class Main {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            println(Robot(Position(1,1), Direction.NORTH))
        }
    }
}