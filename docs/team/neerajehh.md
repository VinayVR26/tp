---
layout: page
title: Neeraj's Project Portfolio Page
---

### Project: ClassMate

ClassMate is a desktop application for CEG students to plan their modules and track their academic progress. The user interacts with it using a CLI.

Given below are my contributions to the project.

* **New Feature**: `viewModuleInfo`
  * What it does: Displays detailed information about a specified CEG module including prerequisites, units, and semester availability.
  * Justification: Students need a quick way to look up module details without referring to external sources like NUSMods.

* **New Feature**: `queryModuleAvailability`
  * What it does: Checks if a module is available in a given semester (sem1 or sem2).
  * Justification: Helps students plan which semester to take a module, avoiding unnecessary delays in their academic plan.

* **New Feature**: `checkPrereqStatus`
  * What it does: Shows which prerequisites for a module the user has completed and which are still outstanding.
  * Justification: Students need to know if they are eligible to take a module based on their completed modules, without manually cross-referencing the curriculum.

* **New Feature**: `markDone`
  * What it does: Allows users to mark modules as completed, which is saved persistently across sessions. Now enforces prerequisite checking before allowing a module to be marked as done.
  * Justification: Students need to track their academic progress accurately. Enforcing prerequisites ensures the profile reflects a realistic and valid academic history.

* **New Feature**: `viewDone`
  * What it does: Displays the list of all modules the user has marked as completed.
  * Justification: Students need a quick overview of what they have already completed to plan their remaining workload.

* **New Feature**: `Storage`
  * What it does: Handles persistent saving and loading of completed modules and specialisations to and from text files, so progress is retained between sessions.
  * Justification: Without persistence, students would have to re-enter their completed modules every time they launch the app, making it unusable for long-term planning.

* **Bug fixes**:
  * Fixed `checkPrereqStatus` error message to match UG format — changed from `"Module X not found"` to `"Module not found: X"`.
  * Fixed `queryModuleAvailability` invalid semester input to use proper error formatting with `(!) ERROR:` prefix, consistent with all other error messages in the app.
  * Fixed `markDone` to check prerequisites before marking a module as done — previously allowed marking without satisfying prerequisites, leading to an inconsistent profile state.
  * Fixed `queryModuleAvailability` to reject extra arguments — previously accepted and silently ignored additional unexpected arguments instead of showing an error.

* **Code contributed**: [RepoSense link](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=neerajehh)

* **Contributions to the UG**:
  * Wrote documentation for `viewModuleInfo`, `queryModuleAvailability`, `checkPrereqStatus`, `markDone`, `viewDone`, and `unmarkDone` commands — including command format, examples, expected output, and error cases.
  * Updated `viewGradReqs` description to reflect filtering of completed modules.
  * Fixed `viewSpecialisations` expected output (removed invalid "Others" entry).
  * Fixed `removeSpecialisation` command summary example.

* **Contributions to the DG**:
  * Added UML sequence diagram for `checkPrereqStatus` illustrating how components interact when the command is executed.
  * Added UML sequence diagram for `markDone` (v2.1) illustrating the full flow from user input to prerequisite validation to storage persistence.
  * Wrote the entire Storage component design section — the most technically detailed section in the DG — covering file management, startup/update data flow, and 3 design considerations.
  * Added implementation walkthrough and design considerations for `checkPrereqStatus`, `markDone`, `viewDone`, `unmarkDone`, and `Storage`.
  * Fixed DG typo in architecture description ("applicationc ontrol flow").
  * Removed 3 unimplemented user stories from DG appendix to keep it accurate.

* **Contributions to team-based tasks**:
  * Implemented the entire `Storage` class from scratch — the only persistence layer in the app, handling both completed modules and specialisations across sessions.
  * Added data corruption guard to `Storage` — validates module codes and specialisation names on load, skipping invalid entries with a warning log (addresses NFR #4).
  * Fixed checkstyle violations across multiple files to ensure clean CI builds.
  * Added `@@author` tags to all 9 contributed files for accurate RepoSense attribution.
  * Reviewed and merged PRs from teammates.

* **Review/mentoring contributions**:
  * Reviewed PRs from teammates and provided feedback on code quality and correctness.

* **Additional Bug fixes (v2.1)**:
  * Fixed `viewGradReqs` to filter out completed modules — previously showed all modules regardless of completion status, making it less useful for progress tracking.
  * Added `unmarkDone` command — allows users to remove a module from their completed list if marked incorrectly, preventing an unrecoverable state.
  * Fixed UG typo "Space Technolgy" → "Space Technology" in the specialisations section.
  * Fixed `viewPrereqs` to be case-insensitive as stated in UG — previously failed silently for lowercase input.
