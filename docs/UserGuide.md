# User Guide

ClassMate is a CLI-based chatbot that assists NUS UG CEG students with timetable and course schedule planning, so as to tailor to their academic pursuits and scheduling needs, while tracking progress toward graduation, specialisation, minor, and other degree requirements.

* [Quick Start](#quick-start)
* [Features](#features)
    * [Viewing major requirements: `view major reqs`](#viewing-major-requirements-view-major-reqs)
    * [Printing module info: `view module info`](#printing-module-info-view-module-info)
    * [Querying prerequisites: `query prereqs`](#querying-prerequisites-query-prereqs)
    * [Checking availability: `query mod avail`](#checking-availability-query-mod-avail)
    * [Viewing list of specialisations: `view specialisations`](#viewing-list-of-specialisations-view-specialisations)
* [Command Summary](#command-summary)

## Quick Start

1. Ensure that you have Java 17 or above installed.
2. Download the latest version of `ClassMate` from [here](https://github.com/AY2526S2-CS2113-W11-4/tp/releases).
3. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar classmate.jar` command to run the application.

## Features 

<div markdown="block" class="alert alert-info">

### Command Format

* Words in `UPPER_CASE` are the parameters to be supplied by the user.
* Parameters can be in any order.
* **Flexible Formats**: ClassMate supports multiple formats (e.g., `view major reqs`, `view grad reqs`, and `printMajorRequirements` are synonymous).
* **Case Insensitivity**: Commands are case-insensitive (e.g., `view module info` == `VIEW MODULE INFO`).
</div>

### Viewing major requirements: `view major reqs`

Shows a list of modules the student has to clear in order to graduate.

Format: `view major reqs`

Examples:
* `view major reqs`
* `view major requirements`
* `view grad reqs`

### Querying prerequisites: `query prereqs`

Given a module code, queries for the prerequisite tree.

Format: `query prereqs MODULE_CODE`

Examples:
* `query prereq CG2028`
* `query prereqs CS2113`

### Checking availability: `query mod avail`

Checks if a module is available in Semester 1, Semester 2, or both.

Format: `query mod avail MODULE_CODE`

Examples:
* `query mod avail cg2023`
* `query module availability cg2028`

### Printing module info: `view module info`

Shows details for specific modules, such as title, academic units, and prerequisites.

Format: `view module info MODULE_CODE [MORE_MODULE_CODES]...`

Examples:
* `view module info CS1010`
* `view module info CS1010 CS1231 CG2028`

### Viewing list of specialisations: `view specialisations`

Provides an overview of available CEG specialisations.

Format: `view specialisations`

### View specialisation info: `view specialisation`

Provides the list of modules to take in order to fulfill the specialisation.

Format: `view specialisation SPECIALISATION_NAME`

Examples:
* `view specialisation Advanced Electronics`
* `view specialisation iot`


### Create and plan schedule for semester: 
[COMING SOON]

---

## Command Summary

| Action | Format | Examples |
| :--- | :--- | :--- |
| **Major Reqs** | `view major reqs` | `view major reqs`, `view grad reqs` |
| **Module Info** | `view module info MODULE_CODE...` | `view module info CS1010 CS1231` |
| **Prerequisites** | `query prereqs MODULE_CODE` | `query prereqs CG2028` |
| **Availability** | `query mod avail MODULE_CODE` | `query mod avail cg2023` |
| **Specialisation List** | `view specialisations` | `view specs`, `view specialisations` |
| **Specialisation Info** | `view specialisation SPECIALISATION_NAME` | `view specialisation Advanced Electronics` |
