package io.github.kuberatest.actiongenerate;

public class ActionGeneratorTool {
    public static void main(String[] args) {
        ActionGenerator actionGenerator = new ActionGenerator();
        actionGenerator.execute(args[0]);
    }
}