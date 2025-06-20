# 🌐 Web UI Automation with Katalon Studio – demoqa.com

This repository contains web UI automated tests using **Katalon Studio** to validate multiple interactive elements on [https://demoqa.com](https://demoqa.com).

---

## 🔧 Features
- ✅ Tests for:
  - Text Box
  - Check Box
  - Radio Button
  - Buttons
  - Upload and Download
- 📋 Implemented both **manual steps** and **BDD (Cucumber)** tests
- 🧠 Handles dynamic elements, smart waits, and headless browser issues
- 📂 Uses Page Object pattern via Object Repository
- 🧾 Organized into modular Test Cases, Test Suites, and Step Definitions

---

## 🚀 Sample Test Cases

| Test Case | Action | Validation |
|-----------|--------|------------|
| `TC_TextBox_ValidInput` | Fill form | Output field contains input |
| `TC_CheckBox_SelectDocs` | Click nested checkboxes | Result includes "Documents" |
| `TC_RadioButton_SelectYes` | Select radio button | Text "You have selected Yes" visible |
| `TC_Button_DoubleClick` | Perform double click | Message appears |
| `TC_UploadFile` | Upload file | Success message appears |

---

## 🛠 Tools Used
- [Katalon Studio](https://www.katalon.com/)
- Cucumber BDD
- WebUI automation
- GitHub for version control

---

## 💡 Notes
- Global Variables used for base URL and reusable test data
- Tests support headless mode (with custom screen size and smart wait)
- Object Repository structured by page/component

---
