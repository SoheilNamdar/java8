package functional.principles;

// Function in java: SAM (Single Abstract Method)
@FunctionalInterface
interface Operation{
    int applyOperation(int number);
}
