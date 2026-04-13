# ClassMate

**ClassMate** is a CLI-based chatbot tailored for NUS Computer Engineering (CEG) students to simplify academic planning. It helps you manage graduation requirements, explore specialisation tracks, and track your modular progress through an efficient text-based interface.

```
                  "  ____ _               __  __       _\n"
                + " / ___| | __ _ ___ ___|  \\/  | __ _| |_ ___\n"
                + "| |   | |/ _` / __/ __| |\\/| |/ _` | __/ _ \\\n"
                + "| |___| | (_| \\__ \\__ \\ |  | | (_| | ||  __/\n"
                + " \\____|_|\\__,_|___/___/_|  |_|\\__,_|\\__\\___|\n";

```

---

## Quick Start

1. **Prerequisites:** Ensure you have **Java 17** or above installed on your machine.
2. **Download:** Grab the latest `ClassMate.jar` from our [Releases](https://github.com/AY2526S2-CS2113-W11-4/tp/releases).
3. **Launch:** Open your terminal, navigate to the folder containing the file, and run:
   ```bash
   java -jar ClassMate.jar

---

## Usage
Refer to our User Guide for more information. Download it together with the Jar file from our [Releases](https://github.com/AY2526S2-CS2113-W11-4/tp/releases) or view it [here](https://github.com/AY2526S2-CS2113-W11-4/tp/blob/master/docs/UserGuide.md)

Provided below is a Command Summary Table as of ClassMate v2.1. Refer to User Guide for more information.

| Category | Action | Format | Examples |
| :--- | :--- | :--- | :--- |
| **General** | **Get Help** | `help` | `help` |
| | **Exit Application** | `bye` | `bye` |
| **Major** | **View Core Requirements** | `viewGradReqs` | `viewGradReqs` |
| | **View Module Details** | `viewModuleInfo MODULE_CODE` | `viewModuleInfo CS2113` |
| | **Check Availability** | `queryModuleAvailability MODULE_CODE sem1/sem2` | `queryModuleAvailability CG2023 sem2` |
| | **View Prerequisite Tree** | `viewPrereqs MODULE_CODE` | `viewPrereqs EE4204` |
| **Spec** | **List All Specialisations** | `viewSpecialisations` | `viewSpecialisations` |
| | **View Specialisation Info** | `viewSpecialisationInfo INDEX` | `viewSpecialisationInfo 2` |
| | **Add Specialisation** | `setSpecialisation NAME` | `setSpecialisation Robotics` |
| | **Remove Specialisation** | `removeSpecialisation NAME` | `removeSpecialisation Robotics` |
| **Profile** | **Mark Module as Done** | `markDone MODULE_CODE` | `markDone CS2040C` |
| | **View Completed Modules** | `viewDone` | `viewDone` |
| | **Unmark Module as Done** | `unmarkDone MODULE_CODE` | `unmarkDone CS1010` |
| | **Check Academic Profile** | `checkProfile` | `checkProfile` |
| | **Check Prereq Checklist** | `checkPrereqStatus MODULE_CODE` | `checkPrereqStatus CS2113` |

