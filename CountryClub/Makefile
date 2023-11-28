# Define the Java compiler and runtime
JAVAC = javac
JAVA = java

# Directories
SOURCE_DIR = src
BUILD_DIR = bin

# Find all java files in the source directory and its subdirectories
SOURCE_FILES := $(SOURCE_DIR)/App.java $(SOURCE_DIR)/CountryClub.java $(SOURCE_DIR)/BaseClasses/CapacityCheckinbase.java $(SOURCE_DIR)/Interfaces/ICheckin.java $(SOURCE_DIR)/Interfaces/ICountryClubFacility.java $(SOURCE_DIR)/Interfaces/Ireservation.java $(SOURCE_DIR)/Models/Gym.java $(SOURCE_DIR)/Models/Member.java $(SOURCE_DIR)/Models/Pool.java $(SOURCE_DIR)/Models/Reservation.java $(SOURCE_DIR)/Models/Restaurant.java

# Replace source directory with build directory and .java with .class in file paths
CLASS_FILES := $(SOURCE_FILES:$(SOURCE_DIR)/%.java=$(BUILD_DIR)/%.class)

# Compiler flags
JAVAC_FLAGS = -d $(BUILD_DIR) -cp $(SOURCE_DIR)

# Main class for running the application
MAIN_CLASS = App

# Phony targets for make commands
.PHONY: all run run-exception clean

# Detect the operating system and set the appropriate clean command
ifeq ($(OS),Windows_NT)
	CLEAN_COMMAND = rmdir /s /q $(BUILD_DIR)
else
	CLEAN_COMMAND = rm -rf $(BUILD_DIR)
endif

# Default target
all: $(CLASS_FILES)
	@echo "Compilation completed."

# Rule for compiling java files
$(BUILD_DIR)/%.class: $(SOURCE_DIR)/%.java | $(BUILD_DIR)
	$(JAVAC) $(JAVAC_FLAGS) $<

# Rule to create the build directory
$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

# Rule to run the application
run: all
	$(JAVA) -cp $(BUILD_DIR) $(MAIN_CLASS)

# Rule to clean the build directory
clean:
	$(CLEAN_COMMAND)
