# Developer Guide

## Acknowledgements

* Base project structure adapted from [SE-EDU AddressBook Level-2](https://github.com/se-edu/addressbook-level2)

## Design & Implementation

### Architecture Overview

ClassMate is a CLI-based Java application. The main components are:

* `ClassMate` — The main entry point. Handles user input loop and command execution.
* `Parser` — Parses raw user input into `Command` objects.
* `Command` — Stores the command word and arguments.
* `Major` — Stores and manages the list of CEG core modules.
* `Module` — Represents a single university module with code, name, units, semester, and prerequisites.
* `Specialisation` — Represents a CEG specialisation and its required modules.
* `ClassMateException` — Custom exception class for application-specific errors.

### Module Information Display Feature

The `printModuleInfo` command allows users to query details of one or more modules.

**Implementation:**
1. User types `printmoduleinfo MODULE_CODE [MORE_MODULE_CODES]...`
2. `Parser` splits the input and returns a `Command` with command word `printmoduleinfo`
3. `ClassMate` splits the args by whitespace to get individual module codes
4. For each code, `Major.findModule()` is called to retrieve the `Module` object
5. `Module.printInfo()` returns a formatted string with code, name, units, semester, prerequisites and availability

**Example:**
```
printmoduleinfo CS2113
Module Info for CS2113
Code: CS2113 Name: Software Engineering & Object-Oriented Programming Units: 4 Semester: 1/2 Prerequisites: CS2040C Can take: NO
```

### Module Availability Check Feature

The `queryModuleAvailability` command allows users to check if a module is offered in a specific semester.

**Implementation:**
1. User types `queryModuleAvailability MODULE_CODE sem1/sem2`
2. `Parser` returns a `Command` with command word `querymoduleavailability`
3. `ClassMate` splits the args to get module code and semester
4. `Major.findModule()` retrieves the `Module` object
5. `Module.checkAvailability()` compares the module's semester field against the queried semester

**Example:**
```
querymoduleavailability CG2023 sem2
Yes, CG2023 is only available in Semester 2.
```

## Product Scope

### Target User Profile

* NUS Computer Engineering (CEG) undergraduate students
* Students who need to plan their course schedule and track graduation requirements
* Students who prefer CLI-based tools for faster interaction

### Value Proposition

ClassMate helps CEG students plan their academic journey by providing quick access to module information, prerequisites, availability, and specialisation requirements — all through a fast CLI interface.

## User Stories

| Version | As a ... | I want to ... | So that I can ... |
|---------|----------|---------------|-------------------|
| v1.0 | new user | see usage instructions | refer to them when I forget how to use the application |
| v1.0 | CEG student | view all graduation requirements | know what modules I need to complete |
| v1.0 | CEG student | query prerequisites for a module | plan which modules to take first |
| v1.0 | CEG student | view module information | know the details of a module before taking it |
| v1.0 | CEG student | check module availability by semester | plan my timetable accordingly |
| v2.0 | CEG student | view specialisation requirements | plan my specialisation pathway |

## Non-Functional Requirements

* Should work on any mainstream OS (Windows, macOS, Linux) with Java 17 installed.
* Should respond to any command within 1 second.
* Should be able to handle all 18 CEG core modules without performance issues.

## Glossary

* **Module Code** — A unique identifier for a university module e.g., CS2113
* **Prerequisites** — Modules that must be completed before taking a given module
* **Semester** — Academic term; either Semester 1 (August) or Semester 2 (January)
* **CEG** — Computer Engineering, an undergraduate programme at NUS
* **Specialisation** — A focus area within CEG that requires completing a specific set of modules

## Instructions for Manual Testing

1. Launch the application: `java -jar classmate.jar`
2. Test help command: type `help`
3. Test module info: type `printmoduleinfo CS2113`
4. Test availability: type `querymoduleavailability CG2023 sem2`
5. Test prerequisites: type `prereq CS2113`
6. Test graduation requirements: type `view grad req`
7. Exit: type `bye`