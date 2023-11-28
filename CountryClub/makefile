# Define the main class
MAIN_CLASS = App

# Directories
SOURCE_DIR = src
BUILD_DIR = bin

# Source files
SOURCE_FILES = $(wildcard $(SOURCE_DIR)/*.java)
CLASS_FILES = $(patsubst $(SOURCE_DIR)/%.java, $(BUILD_DIR)/%.class, $(SOURCE_FILES))

# Java compiler and flags
JAVAC = javac
JAVAC_FLAGS = -d $(BUILD_DIR) -cp $(SOURCE_DIR)

# Java runtime command
JAVA = java

# Targets
.PHONY: all run clean

all: $(CLASS_FILES)
	@echo "Compilation completed."

$(BUILD_DIR)/%.class: $(SOURCE_DIR)/%.java | $(BUILD_DIR)
	$(JAVAC) $(JAVAC_FLAGS) $<

$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

run: all
	$(JAVA) -cp $(BUILD_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(BUILD_DIR)
