---
layout: page
title: Shao Ann's Project Portfolio Page
---

## Project ClassMate

ClassMate is a CLI-based course planning assistant for NUS CEG students.
Classmate is designed to help users view module information, check prerequisites, track completed modules, and manage specialisations.

### Summary of Contributions

* **New Feature**: Implemented the command-processing pipeline for the application.
    * What it does: converts raw user input into executable command objects and routes them through the main execution flow.
    * Justification: This serves as the primary command-processing layer, standardising how the application executes user requests.
    * Highlights: This feature required designing a clean separation between input parsing, command creation, and command execution. It also needed careful handling of invalid or empty input so that errors were caught early.

* **New Feature**: Created the `Command` base class to standardise command execution.
    * What it does: defines a common interface for all commands, ensuring consistent execution and error handling.
    * Justification: This provides a foundation for extensibility and maintainability, allowing new commands to be added without disrupting existing code.
    * Highlights: This abstraction supports a command-based architecture and keeps feature-specific logic isolated inside individual command classes.

* **New Feature**: Implemented the help command.
    * What it does: provides users with a central reference of available commands and their usages through the UI.
    * Justification: This improves user experience by making it easier for users to understand and use the application.
    * Highlights: This feature integrates with the UI layer to provide a user-friendly summary of command formats and categories.

* **Enhancements to existing features**:
    * Improved command validation and error handling for invalid or empty input.
    * Refined the application execution flow so that command creation and command execution are clearly separated.
    * Supported future extensibility by ensuring new commands can be added with minimal changes to the parser and command manager.

* **Bugs Fixed**:
    * Fixed parser handling for empty or malformed input so that invalid commands are rejected consistently with a clear error message.
    * Fixed help command output to stay in sync with newly added commands and updated command formats.
    * Fixed command routing issues where certain valid commands were not passed correctly from the parser to the command manager.
    * Fixed error handling for unknown commands, so the application now responds gracefully instead of failing unexpectedly.

* **Code contributed:** [RepoSense link](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=shaun-gsa)

* **Documentation**:
    * **User Guide**:
        * Added and improved command descriptions for key CLI features, including usage format and expected behaviour.
        * Helped make the command reference clearer and more consistent for users.
    * **Developer Guide**:
        * Documented the parser-command architecture and execution flow.
        * Added explanations of how user input is transformed into executable commands.

* **Testing**:
    * Wrote and updated unit tests for parser and command manager behaviour.
    * Verified correct handling of valid commands, unknown commands, and malformed input.
    * Ensured command creation logic remained consistent as the application evolved.

* **Community**:
    * Reviewed teammates’ PRs and gave feedback on design and correctness.
    * Helped improve documentation quality and consistency across the project.
    * Contributed to discussions on command flow and application structure.

* **Tools**:
    * Used IntelliJ IDEA and Gradle for development and testing.
    * Worked with GitHub for version control, code review, and collaboration.

* _You can add/remove categories depending on what best reflects your contributions._
