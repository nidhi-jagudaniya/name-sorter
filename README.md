[![Build status](https://ci.appveyor.com/api/projects/status/github/nidhi-jagudaniya/name-sorter?branch=main&svg=true)](https://ci.appveyor.com/project/nidhi-jagudaniya/name-sorter)

# NameSorter

**NameSorter** is a Java command-line application that reads a list of unsorted names from a text file, sorts them
alphabetically by last name (then by given names if last names match), displays the sorted names to the console, and
writes them to a new output file.

---

## Highlights of Implementation

- Reads names from a plain text input file.
- Automatically ignores empty or blank lines.
- Sorts names by last name, then given names.
- Outputs the sorted list to both the console and an output file.
- Clean, modular design with separation of concerns using service classes and interfaces.
- Generic Reader, Writer, and Sorter interfaces for easy extension to other types of data.
- Unit tests implemented using JUnit and Mockito.
- AppVeyor CI is configured at **https://ci.appveyor.com/project/nidhi-jagudaniya/name-sorter** to:
    - Trigger builds on every commit or pull request.
    - Build and run the application (Main class).
    - Output the sorted names in the AppVeyor build logs
---

## How to Run

- Clone git repo from **https://github.com/nidhi-jagudaniya/name-sorter**
- Main method is at **NameSorter/src/main/java/Main.java**.
- Two ways to run the program - from command-line and from IDE.

### From Command-line

#### Prerequisites
- Install Java 17 from **https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html**
- Once it is installed, press **Win + S**  or go to **Environment Variables**.
- Click **"Edit the system environment variables"**.
- Under System variables,find and select **Path** -> click **Edit**.
- Click **New** and add full path to the bin folder of installed java - **C:\Program Files\Java\jdk-17\bin**
- Verify by running `java -version` in Command Prompt.

#### Execution
- You can place your file to test in **src/main/java/resources/** folder and change file name in below command or give
  absolute path of file in your device.
- Go inside project folder NameSorter and open command-line at that location.
- Run `mvn clean install` to build the project.
- Run `java -jar target/name-sorter-1.0-SNAPSHOT.jar "resources/unsorted-names-list.txt"`
- It will print sorted names on command-line, and it will also write in the file **resources/sorted-names-list.txt**

### From InteliJIdea

#### Prerequisites
- Install IntelliJIdea Community Edition from **https://www.jetbrains.com/idea/download/?section=windows**
- Install Java 17 and add in System path.
- Install Maven 3.9.9 and add in System path.

#### Execution
- Open InteliJIdea. Go to File > Open > select NameSorter project > click OK
- Run configurations are exported at '.idea\runConfigurations', So it will be available to use.
- NameSorter-Run configuration has default file added in command-line argument as resources/unsorted-names-list.txt
- you can place your file to test in **src/main/java/resources/** folder and change file name in command-line argument
  or give absolute path of file in your device.
- Run NameSorter-clean-install to build project from Run configuration.
- Run NameSorter-Run to run project from Run configuration.
- It will print sorted names on console, and it will also write in the file **resources/sorted-names-list.txt**
