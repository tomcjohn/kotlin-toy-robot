package com.tomcjohn.robot.domain

enum class Direction(val left: String, val right: String) {
    NORTH("WEST", "EAST"),
    EAST("NORTH", "SOUTH"),
    SOUTH("EAST", "WEST"),
    WEST("SOUTH", "NORTH");

    fun left(): Direction {
        return valueOf(left)
    }

    fun right(): Direction {
        return valueOf(right)
    }
}
