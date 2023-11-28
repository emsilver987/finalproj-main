# Define the Java compiler and runtime
JAVAC = javac
JAVA = java

# Directories
SOURCE_DIR = src
BUILD_DIR = bin

# Find all java files in the source directory and its subdirectories
SOURCE_FILES := $(shell find $(SOURCE_DIR) -name '*.java')
# Replace source directory with build directory and .java with .class in file paths
CLASS_FILES := $(SOURCE_FILES:$(SOURCE_DIR)/%.java=$(BUILD_DIR)/%.class)

# Compiler flags
JAVAC_FLAGS = -d $(BUILD_DIR) -cp $(SOURCE_DIR)

# Main class for running the application
# Replace 'App' with the fully qualified name if it's in a package
MAIN_CLASS = App

# Phony targets for make commands
.PHONY: all run clean

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
	rm -rf $(BUILD_DIR)
