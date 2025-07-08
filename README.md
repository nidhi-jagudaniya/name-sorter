# NameSorter

**NameSorter** is a Java command-line application that reads a list of unsorted names from a text file, sorts them alphabetically by last name (then by given names if last names match), displays the sorted names to the console, and writes them to a new output file.

---
## Highlights of Implementation

- Reads names from a plain text file.
- Ignores empty or blank lines.
- Sorts names by last name, then given names.
- Displays the sorted list to the console.
- Writes the sorted list to a file.
- Clean separation of concerns using interfaces and service classes.
- Implemented Unit teasts with JUnit and Mockito.
- Generic interfaces for read, write and sort. Which can be used in expansion of other data sorting.

---

## Prerequisites

Make sure you have the following software installed:


#### To run from Command-line
- Install Java 17 from **https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html** 
- Once it is installed, press **Win + S**  or go to **Environment Variables**.
- Click **"Edit the system environment variables"**.
- Under System variables,find and select **Path** -> click **Edit**.
- Click **New** and add full path to the bin folder of installed java - **C:\Program Files\Java\jdk-17\bin**
- Verify by running **java -version** in Command Prompt.

#### To run from InteliJIdea
- Install IntelliJIdea Community Edition from **https://www.jetbrains.com/idea/download/?section=windows**

- Install Java 17 and add in System path.
- Install Maven 3.9.9 and add in System path.
---
## How to Run
- Clone git repo from
- Main method is at **NameSorter/src/main/java/Main.java**.
- Two ways to run the program one is from commandline and from IDE.

#### From Command-line
- You can place your file to test in **src/main/java/resources/** folder and change file name in below command or give absolute path of file in your device.
- Go inside project folder NameSorter and open command-line at that location.
- Run **java -jar target/name-sorter-1.0-SNAPSHOT.jar "resources/unsorted-names-list.txt"**
- That will print sorted list and add it to the file at **resources/sorted-names-list.txt**

#### From InteliJIdea

- Open InteliJIdea. Go to File > Open > select NameSorter project > click OK
- Run configurations are exported at '.idea\runConfigurations', So it will be available to use.
- NameSorter-Run configuration has default file added in command-line argument as resources/unsorted-names-list.txt
- you can place your file to test in **src/main/java/resources/** folder and change file name in command-line argument or give absolute path of file in your device. 
- Run NameSorter-clean-install to build project from Run configuration.
- Run NameSorter-Run to run project from Run configuration.
- It will print sorted names on console, and it will also write in the file **resources/sorted-names-list.txt**

mented unit test cases.