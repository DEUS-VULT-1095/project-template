package edu.hw2.task4;


public final class Task4 {

    private Task4() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTraceElements[2];
        return new CallingInfo(stackTraceElement.getClassName(), stackTraceElement.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {}
}
