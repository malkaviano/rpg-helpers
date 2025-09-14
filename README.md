# RPG-Helpers

A Scala library providing helper utilities for building Role-Playing Games (RPGs). This project is built with SBT and designed to offer reusable components for common RPG mechanics.

## Features

This library provides several modules to help with game development:

*   **Dice System:** A comprehensive dice rolling system that includes:
    *   Standard polyhedral dice: `TwoSidedDice`, `ThreeSidedDice`, `FourSidedDice`, `SixSidedDice`, `EightSidedDice`, `TenSidedDice`, `TwelveSidedDice`, `TwentySidedDice`, and `HundredSidedDice`.
    *   A `Bag` trait for rolling multiple dice at once.
    *   Clear and extensible traits for `Dice`, `DiceRange`, and `DiceResult`.

*   **Basic Integer Behaviors:** A system for managing integer-based values, suitable for character attributes, stats, or any mutable numeric value in a game. It supports:
    *   Creation of named integer values (`BasicIntValue`).
    *   Arithmetic operations between values.
    *   Traits for defining behaviors and options for value collections.

*   **Specific Memory:** A generic behavior (`SpecificMemoryBehavior`) for tracking a set of memories or states for any given entity. It provides simple `remember` and `forget` methods.

## Getting Started

To use RPG-Helpers in your SBT project, add the following dependency to your `build.sbt` file:

```scala
libraryDependencies += "com.rkss" %% "rpg-helpers" % "1.3.0"
```

## Building the Project

You can compile the project from source using SBT:

```shell
sbt compile
```

## Running Tests

To run the test suite, use the following SBT command:

```shell
sbt test
```