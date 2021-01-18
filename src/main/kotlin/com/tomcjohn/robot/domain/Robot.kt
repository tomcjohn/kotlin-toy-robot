package com.tomcjohn.robot.domain

class Robot (val position: Position, val direction: Direction){

    fun left(): Robot {
        return Robot(position, direction.left())
    }

    fun right(): Robot {
        return Robot(position, direction.right())
    }

    fun move(): Robot {
        return when (direction) {
            Direction.NORTH -> Robot(Position(position.x, position.y+1), direction)
            Direction.EAST -> Robot(Position(position.x+1, position.y), direction)
            Direction.SOUTH -> Robot(Position(position.x, position.y-1), direction)
            Direction.WEST -> Robot(Position(position.x-1, position.y), direction)
        }
    }

    fun report() {
        // (2,4,North)
        println("($position.x,$position.y,$direction)")
    }

    override fun toString(): String {
        return "Robot(position=$position, direction=$direction)"
    }
}
