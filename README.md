# CS Portfolio — Software Testing and Quality Assurance

**Student:** Marcos García León
**Course:** CS 320 — Software Testing, Automation, and Quality Assurance
**Institution:** Southern New Hampshire University

---

## About This Portfolio

This repository contains projects I completed as part of my Computer Science
coursework. The focus of this work is on software testing, quality assurance,
and building reliable programs using good development practices.

---

## Project One — Contact Service (Java)

This project is a Contact Service application written in Java with full unit
testing using JUnit 5. The goal was to build a system that manages contact
records while making sure data is always valid and the service behaves
correctly under different conditions.

### Files Included

| File | Description |
|---|---|
| `Contact.java` | Defines the Contact class with validated fields (ID, name, phone, address) |
| `ContactService.java` | Manages adding, deleting, and updating contact records in memory |
| `ContactTest.java` | Unit tests for the Contact class covering valid and invalid inputs |
| `ContactServiceTest.java` | Unit tests for the ContactService class covering all required operations |

---

## Project Two — Summary and Reflections Report

A written report summarizing what I learned throughout the course, including
my approach to testing, software design, and understanding user requirements.

### File Included

| File | Description |
|---|---|
| `7-2 Project Two Submission - Marcos Garcia Leon.docx` | Written reflection on software testing practices and course outcomes |

---

## Reflections

### How can I ensure that my code, program, or software is functional and secure?

The most important thing I learned is that testing has to be intentional, not
just an afterthought. In Project One, I used JUnit to write tests for every
method, including edge cases like null values, empty strings, and inputs that
were too long. That process made me think about what could go wrong, not just
what should work. On the security side, I learned that validating inputs before
storing or processing them is one of the simplest and most effective habits you
can build. If bad data gets into the system, everything downstream can break,
so catching it at the entry point matters a lot.

### How do I interpret user needs and incorporate them into a program?

User needs are usually buried inside the requirements, you have to read
carefully and ask yourself what this feature is actually trying to do for a
real person. For example, in the Contact Service project, the requirement said
a contact's ID had to be unique and could never be changed after it was
created. That understanding changed how I built the validation logic. I also
found it helpful to turn each requirement into a test case right away, which
kept me focused on what the user actually needs instead of getting lost in
implementation details.

### How do I approach designing software?

I try to start with what the program needs to do before thinking about how to
do it. Once I understand the goal, I break it into small pieces where each one
has a single, clear responsibility. That approach made a big difference in this
course because when each class and method does just one thing, it becomes much
easier to test and easier to fix when something goes wrong. A design is not
really done when the code runs, it is done when the tests pass and someone
else could read it and understand what is happening without needing an
explanation.

---

*This portfolio was built as part of a Computer Science degree program.*
*Marcos García León — Southern New Hampshire University*
