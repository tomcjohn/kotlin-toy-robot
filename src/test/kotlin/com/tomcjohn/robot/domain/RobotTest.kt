package com.tomcjohn.robot.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RobotTest () {
    @Test
    fun testTurnLeft() {
        val position = Position(3,5)
        var robot = Robot(position, Direction.NORTH)

        robot = robot.left()
        assertEquals(position, robot.position)
        assertEquals(Direction.WEST, robot.direction)

        robot = robot.left()
        assertEquals(position, robot.position)
        assertEquals(Direction.SOUTH, robot.direction)

        robot = robot.left()
        assertEquals(position, robot.position)
        assertEquals(Direction.EAST, robot.direction)

        robot = robot.left()
        assertEquals(position, robot.position)
        assertEquals(Direction.NORTH, robot.direction)
    }

    @Test
    fun testTurnRight() {
        val position = Position(3,5)
        var robot = Robot(position, Direction.NORTH)

        robot = robot.right()
        assertEquals(position, robot.position)
        assertEquals(Direction.EAST, robot.direction)

        robot = robot.right()
        assertEquals(position, robot.position)
        assertEquals(Direction.SOUTH, robot.direction)

        robot = robot.right()
        assertEquals(position, robot.position)
        assertEquals(Direction.WEST, robot.direction)

        robot = robot.right()
        assertEquals(position, robot.position)
        assertEquals(Direction.NORTH, robot.direction)
    }

    @Test
    fun testMoveNorth() {
        val position = Position(3,5)
        var robot = Robot(position, Direction.NORTH)

        robot = robot.move()
        assertEquals(Direction.NORTH, robot.direction)
        assertEquals(Position(3,6), robot.position)
    }

    @Test
    fun testMoveEast() {
        val position = Position(3,5)
        var robot = Robot(position, Direction.EAST)

        robot = robot.move()
        assertEquals(Direction.EAST, robot.direction)
        assertEquals(Position(4,5), robot.position)
    }

    @Test
    fun testMoveSouth() {
        val position = Position(3,5)
        var robot = Robot(position, Direction.SOUTH)

        robot = robot.move()
        assertEquals(Direction.SOUTH, robot.direction)
        assertEquals(Position(3,4), robot.position)
    }

    @Test
    fun testMoveWest() {
        val position = Position(3,5)
        var robot = Robot(position, Direction.WEST)

        robot = robot.move()
        assertEquals(Direction.WEST, robot.direction)
        assertEquals(Position(2,5), robot.position)
    }
}
