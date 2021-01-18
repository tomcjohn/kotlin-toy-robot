package com.tomcjohn.robot.domain

import com.tomcjohn.robot.domain.Direction.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TableTest {
    @Test
    fun testPlace() {
        val table = Table(Position(0, 0), Position(9, 9))

        var newRobot = table.doCommand("PLACE 3,5,NORTH", null)
        assertNotNull(newRobot!!)
        assertEquals(Position(3,5), newRobot.position)
        assertEquals(NORTH, newRobot.direction)

        val ignoredRobot = Robot(Position(1,3), SOUTH)
        newRobot = table.doCommand("PLACE 3,5,NORTH", ignoredRobot)
        assertNotNull(newRobot!!)
        assertEquals(Position(3,5), newRobot.position)
        assertEquals(NORTH, newRobot.direction)
    }

    @Test
    fun testMove() {
        val table = Table(Position(0, 0), Position(9, 9))

        assertNull(table.doCommand("MOVE", null))

        doMoveTest(table, NORTH, Position(3, 5), Position(3,6))
        doMoveTest(table, EAST, Position(3, 5), Position(4,5))
        doMoveTest(table, SOUTH, Position(3, 5), Position(3,4))
        doMoveTest(table, WEST, Position(3, 5), Position(2,5))
    }

    private fun doMoveTest(table: Table, direction: Direction, position: Position, newPosition: Position) {
        val robot = Robot(position, direction)
        val newRobot = table.doCommand("MOVE", robot)
        assertNotNull(newRobot!!)
        assertEquals(newPosition, newRobot.position)
        assertEquals(direction, newRobot.direction)
    }

    @Test
    fun testLeft() {
        val table = Table(Position(0, 0), Position(9, 9))

        assertNull(table.doCommand("LEFT", null))

        doTurnTest(table, "LEFT", NORTH, WEST)
        doTurnTest(table, "LEFT", EAST, NORTH)
        doTurnTest(table, "LEFT", SOUTH, EAST)
        doTurnTest(table, "LEFT", WEST, SOUTH)
    }

    @Test
    fun testRight() {
        val table = Table(Position(0, 0), Position(9, 9))

        assertNull(table.doCommand("RIGHT", null))

        doTurnTest(table, "RIGHT", NORTH, EAST)
        doTurnTest(table, "RIGHT", EAST, SOUTH)
        doTurnTest(table, "RIGHT", SOUTH, WEST)
        doTurnTest(table, "RIGHT", WEST, NORTH)
    }

    private fun doTurnTest(table: Table, turn: String, direction: Direction, newDirection: Direction) {
        val position = Position(3, 5)
        val robot = Robot(position, direction)
        val newRobot = table.doCommand(turn, robot)
        assertNotNull(newRobot!!)
        assertEquals(position, newRobot.position)
        assertEquals(newDirection, newRobot.direction)
    }
}
