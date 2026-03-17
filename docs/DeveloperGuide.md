# User Guide

ClassMate is a CLI-based chatbot that assists NUS UG CEG students with timetable and course schedule planning, so as to tailor to their academic pursuits and scheduling needs, while tracking progress toward graduation, specialisation, minor, and other degree requirements.

* [Quick Start](#quick-start)
* [Features](#features)
  * [Viewing major requirements: `view grad req`](#viewing-major-requirements-view-grad-req)
  * [Printing module info: `printModuleInfo`](#printing-module-info-printmoduleinfo)
  * [Querying prerequisites: `prereq`](#querying-prerequisites-prereq)
  * [Checking availability: `queryModuleAvailability`](#checking-availability-querymoduleavailability)
  * [Viewing list of specialisations: `specialisations`](#viewing-list-of-specialisations-specialisations)
  * [Viewing specialisation info: `specialisation`](#viewing-specialisation-info-specialisation)
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
* **Case Insensitivity**: Commands are case-insensitive.

</div>

### Viewing major requirements: `view grad req`

Shows a list of modules the student has to clear in order to graduate.

Format: `view grad req`

Examples:
* `view grad req`

### Printing module info: `printModuleInfo`

Shows details for specific modules, such as title, academic units, prerequisites, and whether the module can be taken.

Format: `printModuleInfo MODULE_CODE [MORE_MODULE_CODES]...`

Examples:
* `printModuleInfo CS2113`
* `printModuleInfo CS2113 CG2028 CS2040C`

Expected output:
```
printModuleInfo CS2113
Module Info for CS2113
 Code: CS2113
 Name: Software Engineering & Object-Oriented Programming
 Units: 4
 Semester: 1/2
 Prerequisites: CS2040C
 Can take: NO
```

### Querying prerequisites: `prereq`

Given a module code, queries for the prerequisite tree.

Format: `prereq MODULE_CODE`

Examples:
* `prereq CG2028`
* `prereq CS2113`

### Checking availability: `queryModuleAvailability`

Checks if a module is available in Semester 1, Semester 2, or both.

Format: `queryModuleAvailability MODULE_CODE sem1/sem2`

Examples:
* `queryModuleAvailability CG2023 sem2`
* `queryModuleAvailability CS2113 sem1`

Expected output:
```
queryModuleAvailability CG2023 sem2
Yes, CG2023 is only available in Semester 2.
```

### Viewing list of specialisations: `specialisations`

Provides an overview of available CEG specialisations.

Format: `specialisations`

### Viewing specialisation info: `specialisation`

Provides the list of modules to take in order to fulfill the specialisation.

Format: `specialisation SPECIALISATION_NAME`

Examples:
* `specialisation Advanced Electronics`
* `specialisation iot`

---

## Command Summary

| Action | Format | Examples |
| :--- | :--- | :--- |
| **Major Reqs** | `view grad req` | `view grad req` |
| **Module Info** | `printModuleInfo MODULE_CODE...` | `printModuleInfo CS2113 CG2028` |
| **Prerequisites** | `prereq MODULE_CODE` | `prereq CG2028` |
| **Availability** | `queryModuleAvailability MODULE_CODE sem1/sem2` | `queryModuleAvailability CG2023 sem2` |
| **Specialisation List** | `specialisations` | `specialisations` |
| **Specialisation Info** | `specialisation SPECIALISATION_NAME` | `specialisation Advanced Electronics` |